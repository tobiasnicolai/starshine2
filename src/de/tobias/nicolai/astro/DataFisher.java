package de.tobias.nicolai.astro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DataFisher {

    public void testAll(String date, String time) throws IOException, ParseException {

//        List<Ephemeris> allEpheremerises = interpretText(getEphiWithHouses(date, time, "0.00", "52.00"), date, "1");
//        List<Ephemeris> allEpheremerises = interpretText(getEphiRow(date, time, "1", "1m"), date, "1m");
//        Integer n = 0;
//        Double diffS, diffM;
//        for(Ephemeris eph : allEpheremerises) {
////            if(eph.getSun() == 274.0 + ((1.0 / 60) * 49) + ((1.0 / 3600) * 12)
////                    && eph.getMoon() == 283.0 + ((1.0 / 60) * 10) + ((1.0 / 3600) * 29))
////            {
////                System.out.println(n);
////                System.out.println(eph.getTime());
//                System.out.println(eph.toString());
////            }
////            diffS = (274.0 + ((1.0 / 60) * 49) + ((1.0 / 3600) * 12)) - eph.getSun();
////            diffM = (283.0 + ((1.0 / 60) * 10) + ((1.0 / 3600) * 29)) - eph.getMoon();
////            System.out.println(n.toString() + ": " + diffS.toString() + "; " + diffM.toString());
//            n++;
//        }
    }

    // +-house%5B0.00%2C51.50%2Cp%5D&arg=-ut

    public String getEphiWithHouses(String date, String time, String longi, String langi, String steps, String stepSize) throws IOException {
        String url = "https://www.astro.com/cgi/swetest.cgi?b="+date+"&n="+steps+"&s="+stepSize+"&p=p&e=-eswe&f=PL+-house%5B"+longi+"%2C"+langi+"%2CP%5D&arg=-ut"+time;
        return getDataFromWeb(url);
    }

    public String getEphiRow(String date, String time, String steps, String stepSize) throws IOException {
        String url = "https://www.astro.com/cgi/swetest.cgi?b="+date+"&n="+steps+"&s="+stepSize+"&p=p&e=-eswe&f=PL&arg=-ut"+time;
        return getDataFromWeb(url);
    }

    public String getDataFromWeb(String url) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) obj.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
            } in .close();

            // print result
            return stripData(response.toString());
        } else {
            return null;
        }
    }

    public String stripData(String data){
        data = data.substring(data.indexOf("Sun"));
        data = data.substring(0, data.indexOf("</font>"));
        return data;
    }

    public List<Ephemeris> interpretText(String text, String date, String time,  String stepsSize) throws ParseException {
//        String[] lines = text.split("\\r?\\n");

        SimpleDateFormat sdf = new SimpleDateFormat("d.M.yyyy HH:mm");
        Date objDate = sdf.parse(date+" "+time);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(objDate);

        Long stepMs = 0L;

        switch(stepsSize){
            case "1m": stepMs = 60000L; break;
            case "15m": stepMs = 15L * 60000L; break;
            case "60m": stepMs = 60L * 60000L; break;
            case "1": stepMs = 24L * 60L * 60000L; break;
        }

        List<String> lines = new ArrayList<String>();
        List<Ephemeris> ephemerises = new ArrayList<Ephemeris>();

        while(text.length() > 31) {
            lines.add(text.substring(0,31));
            text = text.substring(31);
        }

        String pl = "";
        String po = "";

        Double poF;
        Integer g, m, s;

        String firstObject = null;
        Date timeForEphemeris = null;
        Ephemeris curEphemeris = null;

        for (String line : lines) {
            if(line != null) {
                pl = line.substring(0, 16).trim();
                po = line.substring(17);

                if(firstObject == null){
                    firstObject = pl;
                    timeForEphemeris = objDate;
                    curEphemeris = new Ephemeris(new Date(calendar.getTimeInMillis()));
                } else {
                    if (pl.equals(firstObject)){
                        ephemerises.add(curEphemeris);

                        calendar.setTimeInMillis(calendar.getTimeInMillis() + stepMs);
                        curEphemeris = new Ephemeris(new Date(calendar.getTimeInMillis()));
                    }
                }

                g = Integer.parseInt(po.substring(0, 3).trim());
                m = Integer.parseInt(po.substring(4, 6).trim());
//                s = Double.parseDouble(po.substring(7, 14).trim());
                s = Integer.parseInt(po.substring(7, 9).trim());

                poF = g.floatValue() + ((1.0 / 60) * m) + ((1.0 / 3600) * s);

//                System.out.println(pl + ": " + poF);
                curEphemeris.setAstroObject(pl,poF);
            }
        }
        ephemerises.add(curEphemeris);
        return ephemerises;
    }
}