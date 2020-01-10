package de.tobias.nicolai.astro;

import de.tobias.nicolai.astro.checks.Meaning;
import de.tobias.nicolai.astro.checks.MeaningChecker;
import de.tobias.nicolai.astro.checks.AstroObj;
import de.tobias.nicolai.astro.checks.MeaningData;

import javax.naming.directory.InvalidAttributesException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, ParseException, InvalidAttributesException {
////	    MainFrame mf = new MainFrame();
////	    mf.setVisible(true);
//
        DataFisher df = new DataFisher();
//
        List<Ephemeris> myEphemeris = df.interpretText(df.getEphiWithHouses("11.2.1986", "12:30", "12.39", "51.52" , "1", "1"), "11.2.1986","12:30", "1");
////        List<Ephemeris> myEphemeris = df.interpretText(df.getEphiRow("1.1.2020", "00:00",  String.valueOf(4*24*2), "15m"), "1.1.2020", "00:00", "15m");
//////        System.out.println(myEphemeris);
        MeaningData md = new MeaningData();
        List<Meaning> meaningBase = md.getMeanings();
////        for(Ephemeris eph : myEphemeris){
////            List<Meaning> myMeanings = MeaningChecker.checkMeanings(meaningBase,eph);
////            if(myMeanings.contains(meaningBase.get(meaningBase.size()-1))) {
////                MeaningChecker.printMeanings(myMeanings);
////            }
////        }
        List<Meaning> myMeanings = MeaningChecker.checkMeanings(meaningBase,myEphemeris.get(0));
        MeaningChecker.printMeanings(myMeanings);
//
//        DataSaver.saveData(myEphemeris);

//        showSelect();
//        testDates();

//        fishManyData("1.1.2020","00:00",3000,"15m");
    }

    public static void showSelect() {
        List<AstroObj> planets = new ArrayList<AstroObj>(Arrays.asList(new AstroObj[]{AstroObj.Sun, AstroObj.Moon, AstroObj.Mercury, AstroObj.Venus, AstroObj.Mars, AstroObj.Jupiter, AstroObj.Saturn, AstroObj.Uranus, AstroObj.Neptune, AstroObj.Pluto}));
        List<AstroObj> planets2 = new ArrayList<AstroObj>(Arrays.asList(new AstroObj[]{AstroObj.Sun, AstroObj.Moon, AstroObj.Mercury, AstroObj.Venus, AstroObj.Mars, AstroObj.Jupiter, AstroObj.Saturn, AstroObj.Uranus, AstroObj.Neptune, AstroObj.Pluto}));

        String[] funcs = new String[]{"0", "30", "45", "60", "90", "120", "135", "150","180", "_sp"};

        for(AstroObj planet1 : planets){
            planets2.remove(planet1);
            for(AstroObj planet2 : planets2){
                for(String fnc : funcs){
                    System.out.println("asp"+fnc+"("+planet1.name().toLowerCase()+","+planet2.name().toLowerCase()+") AS "+planet1.name()+"_"+planet2.name()+fnc+",");
                }
            }
        }
    }

    public static void fishManyData(String beginDate, String beginTime, Integer steps, String stepSize) throws IOException, ParseException {
        DataFisher df = new DataFisher();

        SimpleDateFormat sdf = new SimpleDateFormat("d.M.yyyy HH:mm");
        SimpleDateFormat odf = new SimpleDateFormat("d.M.yyyy");
        SimpleDateFormat otf = new SimpleDateFormat("HH:mm");
        Date objDate = sdf.parse(beginDate+" "+beginTime);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(objDate);

        Long stepMs = 0L;

        switch(stepSize){
            case "1m": stepMs = 60000L; break;
            case "15m": stepMs = 15L * 60000L; break;
            case "60m": stepMs = 60L * 60000L; break;
            case "1": stepMs = 24L * 60L * 60000L; break;
        }

        Integer partSteps = 500;
        Integer stepsDone = 0;

        do{
            Integer stepsLeft = Math.min(partSteps,steps);
            String date = odf.format(calendar.getTime());
            String time = otf.format(calendar.getTime());

            System.out.println("Work package "+stepsDone+"/"+(stepsDone+stepsLeft)+" from "+steps+" begin "+sdf.format(calendar.getTime())+" step size "+stepSize);

            List<Ephemeris> myEphemeris = df.interpretText(df.getEphiRow(date, time,  String.valueOf(stepsLeft), stepSize), date, time, stepSize);
            DataSaver.saveData(myEphemeris);

            calendar.setTimeInMillis(calendar.getTimeInMillis()+(stepMs*partSteps));
            stepsDone += stepsLeft;
            steps -= partSteps;
        }while(steps > 0);
    }
}
