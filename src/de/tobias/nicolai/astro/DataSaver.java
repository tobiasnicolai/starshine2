package de.tobias.nicolai.astro;

import de.tobias.nicolai.astro.checks.AstroObj;

import javax.naming.directory.InvalidAttributesException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class DataSaver {

    public static void saveData(List<Ephemeris> ephs) {
        System.out.println("Start inserting Ephirensises start with " + ephs.get(0).getTime().toString() + " rows: " + ephs.size());
        try {
            // create a mysql database connection
            String myDriver = "org.mariadb.jdbc.Driver";
            String myUrl = "jdbc:mariadb://localhost:3306/astro?user=root&password=root";

            Integer tmstpId;

            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            format.setTimeZone(TimeZone.getTimeZone("UTC"));
            Class.forName(myDriver);

            Connection conn = null;
            try {
                conn = DriverManager.getConnection(myUrl);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            Integer n = 0;
            Integer ges = ephs.size();

            for (Ephemeris eph : ephs) {
                n++;
                System.out.print(n.toString() + "/" + ges.toString() + " " + eph.getTime() + " (");

                calendar.setTime(eph.getTime());

                //===== check if date exists ========
                // the mysql insert statement
                String getQuery = " SELECT id FROM astro.moment WHERE timestp = STR_TO_DATE('" + format.format(calendar.getTime()) + "','%Y-%m-%d %H:%i');";

                String query = "";

                // create the mysql insert preparedstatement
                Statement stmt = conn.createStatement();

                // execute the preparedstatement
                ResultSet rs = stmt.executeQuery(getQuery);

                if (rs.next() == false) {

                    System.out.print("insert moment");
                    //Insert Timestamp
//                 the mysql insert statement
                    query = " insert into astro.moment (timestp)"
                            + " values (STR_TO_DATE(?,'%Y-%m-%d %H:%i'))";

                    // create the mysql insert preparedstatement
                    PreparedStatement prepareStmt = conn.prepareStatement(query);
                    prepareStmt.setString(1, format.format(calendar.getTime()));

                    // execute the preparedstatement
                    prepareStmt.execute();

                    rs = stmt.executeQuery(getQuery);
                    rs.next();
                }
                tmstpId = rs.getInt("id");

                AstroObj[] posiblePlanet = new AstroObj[]{AstroObj.Sun, AstroObj.Moon, AstroObj.Mercury, AstroObj.Venus, AstroObj.Mars, AstroObj.Jupiter, AstroObj.Saturn, AstroObj.Uranus, AstroObj.Neptune, AstroObj.Pluto};

                for (AstroObj planet : posiblePlanet) {
                    Integer astroObjId = -1;
                    switch (planet) {
                        case Sun:
                            astroObjId = 1;
                            break;
                        case Moon:
                            astroObjId = 2;
                            break;
                        case Mercury:
                            astroObjId = 3;
                            break;
                        case Venus:
                            astroObjId = 4;
                            break;
                        case Mars:
                            astroObjId = 5;
                            break;
                        case Jupiter:
                            astroObjId = 6;
                            break;
                        case Saturn:
                            astroObjId = 7;
                            break;
                        case Uranus:
                            astroObjId = 8;
                            break;
                        case Neptune:
                            astroObjId = 9;
                            break;
                        case Pluto:
                            astroObjId = 10;
                            break;
                        default:
                            throw new InvalidAttributesException("Ohn no Planet don't exists");
                    }

                    query = " insert into astro.position (astro_obj, moment, angel)"
                            + " values (?, ?, ?) ON DUPLICATE KEY UPDATE angel=? ";

                    // create the mysql insert preparedstatement
                    PreparedStatement prepareStmt = conn.prepareStatement(query);
                    prepareStmt.setInt(1, astroObjId);
                    prepareStmt.setInt(2, tmstpId);
                    prepareStmt.setDouble(3, eph.getAstroObjPos(planet));
                    prepareStmt.setDouble(4, eph.getAstroObjPos(planet));
                    prepareStmt.execute();
                }

                conn.commit();

                System.out.println(")");

            }
            conn.close();
        } catch (SQLException | ClassNotFoundException | InvalidAttributesException ex) {
            System.out.println(ex.toString());
            ex.printStackTrace();
        }
    }
}
