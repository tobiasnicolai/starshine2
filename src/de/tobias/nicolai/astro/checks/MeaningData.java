package de.tobias.nicolai.astro.checks;

import javax.naming.directory.InvalidAttributesException;
import java.util.ArrayList;
import java.util.List;

public class MeaningData {
    private List<Meaning> m;

    private AstroObj[] posiblePlanet;
    private AstroAni[] possibleAni;
    private AstroObj[] possibleHouses;
    private AstroObj[] otherObjToZodiac;


    public MeaningData() throws InvalidAttributesException {
        this.posiblePlanet = new AstroObj[]{AstroObj.Sun, AstroObj.Moon, AstroObj.Mercury, AstroObj.Venus, AstroObj.Mars, AstroObj.Jupiter, AstroObj.Saturn, AstroObj.Uranus, AstroObj.Neptune, AstroObj.Pluto};
        this.possibleAni = new AstroAni[]{AstroAni.Aquarius, AstroAni.Aries, AstroAni.Cancer, AstroAni.Capricornus, AstroAni.Gemini, AstroAni.Leo, AstroAni.Libra, AstroAni.Pisces, AstroAni.Sagittarius, AstroAni.Scorpio, AstroAni.Taurus, AstroAni.Virgo};
        this.possibleHouses = new AstroObj[]{AstroObj.house1, AstroObj.house2, AstroObj.house3, AstroObj.house4, AstroObj.house5, AstroObj.house6, AstroObj.house7, AstroObj.house8, AstroObj.house9, AstroObj.house10, AstroObj.house11, AstroObj.house12};
        this.otherObjToZodiac = new AstroObj[]{AstroObj.ascendant, AstroObj.mc};

        m = new ArrayList<Meaning>();

        Meaning meaning;
        Constalation constalation;

        //Objekte im Sternzeichen
        for (AstroObj planet : this.posiblePlanet) {
            for (AstroAni ani : this.possibleAni) {
                meaning = new Meaning(planet.name() + " in " + ani.name(), "kein Text", -1);
                constalation = new ZodiacConstalation(planet, ani);
                meaning.addConstalation(constalation);
                m.add(meaning);
            }
            for (AstroObj house : this.possibleHouses) {
                meaning = new Meaning(planet.name() + " in " + house.name(), "kein Text", -1);
                constalation = new HouseConstalation(planet, house);
                meaning.addConstalation(constalation);
                m.add(meaning);
            }
        }

        for (AstroObj obj : this.otherObjToZodiac) {
            for (AstroAni ani : this.possibleAni) {
                meaning = new Meaning(obj.name() + " in " + ani.name(), "kein Text", -1);
                constalation = new ZodiacConstalation(obj, ani);
                meaning.addConstalation(constalation);
                m.add(meaning);
            }
        }

        AstroObj planet = AstroObj.meanNode;
        for (AstroObj house : this.possibleHouses) {
            meaning = new Meaning(planet.name() + " in " + house.name(), "kein Text", -1);
            constalation = new HouseConstalation(planet, house);
            meaning.addConstalation(constalation);
            m.add(meaning);
        }

//        m.add(new Meaning("Der prometische Urfunke","",20));
//        m.get(0).addConstalation(new ZodiacConstalation(AstroObj.Sun,AstroAni.Aries));
//        m.add(new Meaning("Die Liebe zur Scholle oder der heiße Brei","",21));
//        m.get(1).addConstalation(new ZodiacConstalation(AstroObj.Sun,AstroAni.Taurus));
//        m.add(new Meaning("Der Rösselsprung","",21));
//        m.get(2).addConstalation(new ZodiacConstalation(AstroObj.Sun,AstroAni.Gemini));
//        m.add(new Meaning("Die Reflexion des Lichtes","",21));
//        m.get(3).addConstalation(new ZodiacConstalation(AstroObj.Sun,AstroAni.Cancer));
//        m.add(new Meaning("Der Sonnenkönig","",22));
//        m.get(4).addConstalation(new ZodiacConstalation(AstroObj.Sun,AstroAni.Leo));
//        m.add(new Meaning("Das rechte Maß","",22));
//        m.get(5).addConstalation(new ZodiacConstalation(AstroObj.Sun,AstroAni.Virgo));
//        m.add(new Meaning("Der kluge Sinn","",23));
//        m.get(6).addConstalation(new ZodiacConstalation(AstroObj.Sun,AstroAni.Libra));
//        m.add(new Meaning("Der Leuchtturm im Ozean des Unbewußten","",23));
//        m.get(7).addConstalation(new ZodiacConstalation(AstroObj.Sun,AstroAni.Scorpio));
//        m.add(new Meaning("Das Feuer der Erkenntnis","",24));
//        m.get(8).addConstalation(new ZodiacConstalation(AstroObj.Sun,AstroAni.Sagittarius));
//        m.add(new Meaning("Das kontrollierte Wacstum","",24));
//        m.get(9).addConstalation(new ZodiacConstalation(AstroObj.Sun,AstroAni.Capricornus));
//        m.add(new Meaning("Der galaktische Poet","",25));
//        m.get(10).addConstalation(new ZodiacConstalation(AstroObj.Sun,AstroAni.Aquarius));
//        m.add(new Meaning("Die Ungeborenen","",25));
//        m.get(11).addConstalation(new ZodiacConstalation(AstroObj.Sun,AstroAni.Pisces));

//        meaning = new Meaning(AstroObj.Sun, AstroObj.Venus, "", 165);
//        meaning.addConstalation(new ConjunktionConstalation(100, AstroObj.Sun, AstroObj.Venus));
//        meaning.addConstalation(new MirrorConstalation(100, AstroObj.Sun, AstroObj.Venus));
//        meaning.addConstalation(new HalfquadratConstalation(85, AstroObj.Sun, AstroObj.Venus));
//        meaning.addConstalation(new ZodiacConstalation(85, AstroObj.Venus, AstroAni.Leo));
//        meaning.addConstalation(new HalfsextilConstalation(75, AstroObj.Sun, AstroObj.Venus));
//        meaning.addConstalation(new HouseConstalation(75, AstroObj.Sun, AstroObj.house7));
//        meaning.addConstalation(new ZodiacConstalation(75, AstroObj.Sun, AstroAni.Libra));
//        meaning.addConstalation(new HouseConstalation(60, AstroObj.Venus, AstroObj.house5));
//        meaning.addConstalation(new HouseConstalation(50, AstroObj.Sun, AstroObj.house2));
//        meaning.addConstalation(new ZodiacConstalation(50, AstroObj.Sun, AstroAni.Taurus));
//        meaning.addConstalation(new ZodiacConstalation(50, AstroObj.house7, AstroAni.Leo));
//        meaning.addConstalation(new ZodiacConstalation(40, AstroObj.house5, AstroAni.Libra));
//        meaning.addConstalation(new ZodiacConstalation(25, AstroObj.house2, AstroAni.Leo));
//        meaning.addConstalation(new ZodiacConstalation(25, AstroObj.house5, AstroAni.Taurus));
//        meaning.addConstalation(new ZodiacConstalation(25, AstroObj.house2, AstroAni.Leo));
//        meaning.addConstalation(new MasterInHouseConstalation(25, AstroObj.house7, AstroObj.house5));
//        meaning.addConstalation(new MasterInHouseConstalation(25, AstroObj.house2, AstroObj.house5));
//        meaning.addConstalation(new MasterInHouseConstalation(25, AstroObj.house5, AstroObj.house7));
//        meaning.addConstalation(new MasterInHouseConstalation(25, AstroObj.house5, AstroObj.house2));
//        m.add(meaning);

        String text =
                "ne/pl/text/1#" +
                        "100%#se 0.5°#" +
                        "85%#hc ne h8#hc pl h12#" +
                        "75%#hs#hq#se 1°#" +
                        "60%#zc h8 fi#zc h12 sk#" +
                        "50%#zc ne sk#mh h8 h12#mh h12 h8#" +
                        "40%#mz h8 fi#mz h12 sk#" +
                "so/mo/text/165#" +
                        "100%#ko -#tr +#qu -#op -#sp -#" +
                        "85%#se +#" +
                        "75%#an -#qx -#hc so h4#zc mo lo#" +
                        "60%#hq -#hc mo h5#zc so kr#" +
                        "50%#hs#zc h4 lo#" +
                        "40%#zc h5 lo#" +
                        "25%#mh h4 h5#mh h5 h4#" +
                "so/me/text/171#" +
                        "100%#ko 3°#sp#" +
                        "85%#ko 4°#" +
                        "60%#hc so h3#hc so h6#hc me h5#zc so zw#zc so jf#zc me lo#" +
                        "50%#ko 5°#" +
                        "40%#zc h3 lo#zc h6 lo#zc h5 zw#zc h5 jf#" +
                        "25%#mh h3 h5#mh h6 h5#mh h5 h3#mh h5 h6#" +
                "so/ve/text/176#" +
                        "100%#ko#sp#" +
                        "85%#hq#zc ve lo#" +
                        "75%#hs#hc so h7#zc so wa#" +
                        "60%#hc ve h5#" +
                        "50%#hc so h2#zc so st#zc h7 lo#" +
                        "40%#zc h5 wa#" +
                        "25%#zc h2 lo#zc h5 st#mh h7 h5#mh h2 h5#mh h5 h7#mh h5 h2#" +
                "so/ma/text/180#" +
                        "100%#ko +#qu -#tr +#op -#sp +#" +
                        "85%#se +#hc so h1#" +
                        "75%#an -#qx -#zc ma lo#zc so wi#" +
                        "60%#hq -#hc ma h5#" +
                        "50%#hs#zc h1 lo#" +
                        "40%#zc h5 wi#mh h1 h5#" +
                        "25%#mh h5 h1#" +
                "so/ju/text/185#" +
                        "100%#ko +#qu -#tr +#op -#sp#" +
                        "85%#se +#" +
                        "75%#an -#qx -#hc so h9#zc so sc#" +
                        "60%#hq -#hc ju h5#" +
                        "50%#hs#zc ju lo#" +
                        "40%#zc h5 sc#zc h9 lo#" +
                        "25%#mh h9 h5#mh h5 h9#" +
                "so/sa/text/190#" +
                        "100%#ko#qu#op#sp#" +
                        "85%#an#qx#" +
                        "75%#hq#zc so sb#" +
                        "60%#tr#hc so h10#hc sa h5#" +
                        "50%#se#zc h10 lo#" +
                        "40%#hs#zc sa lo#zc h5 sb#" +
                        "25%#mh h5 h10#mh h10 h5#" +
                "so/ur/text/196#" +
                        "100%#ko#qu#op#sp#" +
                        "85%#an#qx#" +
                        "75%#hq#zc so wm#" +
                        "60%#tr#hc so h11#hc ur h5#" +
                        "50%#se#" +
                        "40%#hs#zc h5 wm#zc h11 lo#" +
                        "25%#zc ur lo#mh h5 h11#mh h11 h5#" +
                "so/ne/text/202#" +
                        "100%#ko#qu#op#sp#" +
                        "85%#an#qx#" +
                        "75%#hq#hc so h12#zc so fi#" +
                        "60%#tr#hc ne h5#" +
                        "50%#se#" +
                        "40%#hs#zc h5 fi#zc h12 lo#" +
                        "25%#zc ne lo#mh h5 h12#mh h12 h5#" +
                "so/pl/text/207#" +
                        "100%#ko#qu#op#sp#" +
                        "85%#an#qx#" +
                        "75%#hq#hc so h8#zc so sk#" +
                        "60%#tr#hc pl h5#" +
                        "50%#se#" +
                        "40%#hs#zc h5 sk#zc h8 lo#" +
                        "25%#zc pl lo#mh h5 h8#mh h8 h5#" +
                "mo/me/text/212#" +
                        "100%#ko -#qu -#tr +#op -#sp -#" +
                        "85%#se +#" +
                        "75%#an -#qx -#hc me h4#" +
                        "60%#hq -#hc mo h3#zc mo zw#zc me kr#" +
                        "50%#hs#hc mo h6#zc mo jf#zc h4 jf#zc h3 kr#zc h6 kr#" +
                        "40%#zc h4 jf#zc h3 kr#zc h6 kr#" +
                        "25%#mh h3 h4#mh h6 h4#mh h4 h3#mh h4 h6#" +
                "mo/ve/text/219#" +
                        "100%#ko +#qu -#tr +#op -#sp +#" +
                        "85%#se +#hs -#" +
                        "75%#hc mo h2#zc mo st#hc mo h7#zc mo wa#hc ve h4#zc ve kr#" +
                        "60%#hq -#an -#qx -#" +
                        "50%#zc h7 kr#zc h4 wa#" +
                        "40%#zc h4 st#zc h2 kr#" +
                        "25%#mh h2 h4#mh h7 h4#mh h4 h2#mh h4 h7#" +
                "mo/ma/text/225#" +
                        "100%#ko -#qu -#tr +#op -#sp -#" +
                        "85%#se +#hc mo h1#" +
                        "75%#an -#qx -#zc mo wi#hc ma h4#" +
                        "60%#hq -#zc ma kr#" +
                        "50%#hs#zc h1 kr#" +
                        "40%#zc h4 wi#mh h1 h4#" +
                        "25%#mh h4 h1#" +
                "mo/ju/text/232#" +
                        "100%#ko +#qu -#tr +#op -#sp +#" +
                        "85%#se +#hc mo h9#" +
                        "75%#an -#qx -#zc mo sc#hc ju h4#" +
                        "60%#hq -#" +
                        "50%#hs#zc ju kr#zc h4 sc#" +
                        "40%#zc h9 kr#" +
                        "25%#mh h9 h4#mh h4 h9#" +
                "mo/sa/text/238#" +
                        "100%#ko#qu#op#sp#" +
                        "85%#an#qx#" +
                        "75%#hq#zc mo sb#hc sa h4#" +
                        "60%#tr#hc mo h10#" +
                        "50%#se#zc h10 kr#zc h4 sb#" +
                        "40%#hs#zc sa kr#" +
                        "25%#mh h4 h10#mh h10 h4#" +
                "mo/ur/text/244#" +
                        "100%#ko#qu#op#sp#" +
                        "85%#an#qx#" +
                        "75%#hq#zc mo wm#hc ur h4#" +
                        "60%#tr#hc mo h11#" +
                        "50%#se#zc h4 wm#" +
                        "40%#hs#zc h11 kr#" +
                        "25%#zc ur kr#mh h4 h11#mh h11 h4#" +
                "mo/ne/text/250#" +
                        "100%#ko#qu#tr#op#sp#" +
                        "85%#se#hc mo h12#zc mo fi#" +
                        "75%#an#qx#hc ne h4#" +
                        "60%#hq#" +
                        "50%#hs#zc h4 fi#" +
                        "40%#zc h12 kr#" +
                        "25%#mh h4 h12#mh h12 h4#" +
                "mo/pl/text/255#" +
                        "100%#ko#qu#op#sp#" +
                        "85%#an#qx#hc mo h8#" +
                        "75%#hq#zc mo sk#hc pl h4#" +
                        "60%#tr#" +
                        "50%#se#zc h4 sk#" +
                        "40%#hs#zc h8 kr#" +
                        "25%#zc pl kr#mh h4 h8#mh h8 h4#" +
                "me/ve/text/1#" +
                        "100%#ko#sp#" +
                        "85%#hq#se#" +
                        "75%#hs#hc me h7#zc me wa#" +
                        "60%#hc ve h3#zc ve zw#" +
                        "50%#hc me h2#hc ve h6#zc me st#zc ve jf#zc dc zw#" +
                        "40%#zc dc jf#zc h3 wa#" +
                        "25%#zc h6 wa#zc h2 zw#zc h2 jf#zc h3 st#zc h6 st#mh h7 h3#mh h2 h3#mh h7 h6#mh h2 h6#mh h3 h7#mh h6 h7#mh h3 h2#mh h6 h2#" +
                "me/ma/text/1#" +
                        "100%#ko +#qu -#tr +#op -#sp +#" +
                        "85%#se +#" +
                        "75%#an -#qx -#hc me h1#zc me wi#" +
                        "60%#hq -#hc ma h3#zc ma zw#" +
                        "50%#hs#hc ma h6#zc ma jf#zc ac zw#" +
                        "40%#zc ac jf#zc h3 wi#mh h1 h3#mh h1 h6#" +
                        "25%#zc h6 wi#mh h3 h1#mh h6 h1#" +
                "me/ju/text/1#" +
                        "100%#ko +#qu -#tr +#op -#sp +#" +
                        "85%#se +#hc me h9#" +
                        "75%#an -#qx -#zc me sc#" +
                        "60%#hq -#hc ju h3#" +
                        "50%#hs#hc ju h6#zc ju zw#" +
                        "40%#zc ju jf#zc h9 zw#zc h3 sc#" +
                        "25%#zc h9 jf#zc h6 sc#mh h9 h3#mh h9 h6#mh h3 h9#mh h6 h9#" +
                "me/sa/text/1#" +
                        "100%#ko#qu#op#sp#" +
                        "85%#an#qx#" +
                        "75%#hq#zc me sb#" +
                        "60%#tr#hc me h10#hc sa h3#" +
                        "50%#se#hc sa h6#zc mc zw#" +
                        "40%#hs#zc sa zw#zc mc jf#zc h3 sb#" +
                        "25%#zc sa jf#zc h6 sb#mh h3 h10#mh h6 h10#mh h10 h3#mh h10 h6#" +
                "me/ur/text/1#" +
                        "100%#ko#qu#op#sp#" +
                        "85%#an#qx#" +
                        "75%#hq#zc me wm#" +
                        "60%#tr#hc me h11#hc ur h3#" +
                        "50%#se#hc ur h6#" +
                        "40%#hs#zc ur zw#zc h3 wm#zc h11 zw#" +
                        "25%#zc ur jf#zc h6 wm#zc h11 jf#mh h3 h11#mh h6 h11#mh h11 h3#mh h11 h6#" +
                "me/ne/text/1#" +
                        "100%#ko#qu#op#sp#" +
                        "85%#an#qx#" +
                        "75%#hq#hc me h12#zc me fi#" +
                        "60%#tr#hc ne h3#" +
                        "50%#se#hc ne h6#" +
                        "40%#hs#zc h3 fi#zc h12 zw#" +
                        "25%#zc ne jf#zc h6 fi#zc h12 jf#mh h3 h12#mh h6 h12#mh h12 h3#mh h12 h6#" +
                "me/pl/text/1#" +
                        "100%#ko#qu#op#sp#" +
                        "85%#an#qx#" +
                        "75%#hq#hc me h8#zc me sk#" +
                        "60%#tr#hc pl h3#" +
                        "50%#se#hc pl h6#" +
                        "40%#hs#zc h3 sk#zc h8 zw#" +
                        "25%#zc pl jf#zc h6 sk#zc h8 jf#mh h3 h8#mh h6 h8#mh h8 h3#mh h8 h6#" +
                "ve/ma/text/1#" +
                        "100%#ko -#qu -#tr +#op -#sp -#" +
                        "85%#se +#hc ve h1#" +
                        "75%#an -#qx -#hc ma h7#zc ve wi#" +
                        "60%#hq -#zc ma wa#" +
                        "50%#hs#zc ac wa#" +
                        "40%#hc ma h2#zc ma st#mh h1 h7#" +
                        "25%#zc ac st#zc h2 wi#mh h1 h2#mh h7 h1#mh h2 h1#" +
                "ve/ju/text/1#" +
                        "100%#ko +#qu -#tr +#op -#sp +#" +
                        "85%#se +#hc ju h2#" +
                        "75%#an -#qx -#zc ve sc#hc ju h7#" +
                        "60%#hq -#hc ve h9#zc ju st#" +
                        "50%#hs#zc ju wa#" +
                        "40%#zc h9 st#zc h9 wa#zc h2 sc#zc h7 sc#" +
                        "25%#mh h9 h2#mh h9 h7#mh h2 h9#mh h7 h9#" +
                "ve/sa/text/1#" +
                        "100%#ko#qu#op#sp#" +
                        "85%#an#qx#" +
                        "75%#hq#zc ve sb#hc sa h7#" +
                        "60%#tr#hc ve h10#" +
                        "50%#se#hc sa h2#zc mc wa#zc dc sb#" +
                        "40%#hs#zc sa wa#zc mc st#" +
                        "25%#zc sa st#zc h2 sb#mh h7 h10#mh h2 h10#mh h10 h7#mh h10 h2#" +
                "ve/ur/text/1#" +
                        "100%#ko#qu#op#sp#" +
                        "85%#an#qx#" +
                        "75%#hq#zc ve wm#hc ur h7#" +
                        "60%#tr#hc ve h11#" +
                        "50%#se#hc ur h2#zc dc wa#" +
                        "40%#hs#zc h11 wa#" +
                        "25%#zc ur wa#zc ur st#zc h2 wm#zc h11 st#mh h7 h11#mh h2 h11#mh h11 h7#mh h11 h2#" +
                "ve/ne/text/1#" +
                        "100%#ko#qu#tr#op#sp#" +
                        "85%#se#hc ve h12#zc ve fi#" +
                        "75%#an#qx#hc ne h7#" +
                        "60%#hq#" +
                        "50%#hs#hc ne h2#zc dc fi#" +
                        "40%#zc h12 wa#" +
                        "25%#zc ne wa#zc h2 fi#zc h12 st#mh h7 h12#mh h2 h12#mh h12 h7#mh h12 h2#" +
                "ve/pl/text/1#" +
                        "100%#ko#qu#op#sp#" +
                        "85%#an#qx#hc ve h8#" +
                        "75%#hq#zc ve sk#hc pl h7#" +
                        "60%#tr#" +
                        "50%#se#hc pl h2#zc dc sk#" +
                        "40%#hs#zc h8 wa#" +
                        "25%#zc pl wa#zc h2 sk#zc h8 st#mh h7 h8#mh h2 h8#mh h8 h7#mh h8 h2#" +
                "ma/ju/text/1#" +
                        "100%#ko#qu#tr#op#sp#" +
                        "85%#se#hc ju h1#" +
                        "75%#an#qx#hc ma h9#zc ma sc#" +
                        "60%#hq#" +
                        "50%#hs#zc ju wi#zc ac sc#" +
                        "40%#zc h9 wi#mh h1 h9#" +
                        "25%#mh h9 h1#" +
                "ma/sa/text/1#" +
                        "100%#ko#qu#op#sp#" +
                        "85%#an#qx#" +
                        "75%#hq#hc sa h1#zc ma sb#" +
                        "60%#tr#hc ma h10#" +
                        "50%#se#zc ac sb#zc mc wi#" +
                        "40%#hs#zc sa wi#mh h1 h10#" +
                        "25%#mh h10 h1#" +
                "ma/ur/text/1#" +
                        "100%#ko#qu#op#sp#" +
                        "85%#an#qx#" +
                        "75%#hq#hc ur h1#zc ma wm#" +
                        "60%#tr#hc ma h11#" +
                        "50%#se#zc ac wm#" +
                        "40%#hs#zc h11 wi#mh h1 h11#" +
                        "25%#zc ur wi#mh h11 h1#" +
                "ma/ne/text/1#" +
                        "100%#ko#qu#op#sp#" +
                        "85%#an#qx#hc ma h12#" +
                        "75%#hq#hc ne h1#zc ma fi#" +
                        "60%#tr#" +
                        "50%#se#zc ac fi#" +
                        "40%#hs#zc h12 wi#mh h1 h12#" +
                        "25%#mh h12 h1#" +
                "ma/pl/text/1#" +
                        "100%#ko#qu#op#sp#" +
                        "85%#an#qx#hc ma h8#" +
                        "75%#hq#hc pl h1#zc ma sk#" +
                        "60%#tr#" +
                        "50%#se#zc ac sk#" +
                        "40%#hs#zc h8 wi#mh h1 h8#" +
                        "25%#mh h8 h1#" +
                "ju/sa/text/1#" +
                        "100%#ko#qu#op#sp#" +
                        "85%#an#qx#" +
                        "75%#hq#hc sa h9#" +
                        "60%#tr#hc ju h10#" +
                        "50%#se#zc ju sb#zc mc sc#" +
                        "40%#hs#zc sa sc#zc h9 sb#" +
                        "25%#mh h9 h10#mh h10 h9#" +
                "ju/ur/text/1#" +
                        "100%#ko#qu#op#sp#" +
                        "85%#an#qx#" +
                        "75%#hq#hc ur h9#" +
                        "60%#tr#hc ju h11#" +
                        "50%#se#zc ju wm#" +
                        "40%#hs#zc h9 wm#zc h11 sc#" +
                        "25%#zc ur sc#mh h9 h11#mh h11 h9#" +
                "ju/ne/text/1#" +
                        "100%#ko#qu#tr#op#sp#" +
                        "85%#se#hc ju h12#" +
                        "75%#an#qx#hc ne h9#" +
                        "60%#hq#" +
                        "50%#hs#zc ju fi#" +
                        "40%#zc h9 fi#zc h12 sc#" +
                        "25%#zc ne sc#mh h9 h12#mh h12 h9#" +
                "ju/pl/text/1#" +
                        "100%#ko#qu#op#sp#" +
                        "85%#an#qx#" +
                        "75%#hq#hc ju h8#hc pl h9#" +
                        "60%#tr#" +
                        "50%#se#zc ju sk#" +
                        "40%#hs#zc h8 sc#zc h9 sk#" +
                        "25%#zc pl sc#mh h8 h9#mh h9 h8#" +
                "sa/ur/text/1#" +
                        "100%#ko#qu#op#sp#" +
                        "85%#an#qx#" +
                        "75%#hq#" +
                        "60%#tr#hc sa h11#hc ur h10#" +
                        "50%#se#zc mc wm#" +
                        "40%#hs#zc sa wm#zc h11 sb#" +
                        "25%#zc ur sb#mh h11 h10#mh h10 h11#" +
                "sa/ne/text/1#" +
                        "100%#ko#qu#op#sp#" +
                        "85%#an#qx#" +
                        "75%#hq#hc sa h12#" +
                        "60%#tr#hc ne h10#" +
                        "50%#se#zc mc fi#" +
                        "40%#hs#zc sa fi#zc h12 sb#" +
                        "25%#zc ne sb#mh h10 h12#mh h12 h10#" +
                "sa/pl/text/1#" +
                        "100%#ko#qu#op#sp#" +
                        "85%#an#qx#" +
                        "75%#hq#hc sa h8#" +
                        "60%#tr#hc pl h10#" +
                        "50%#se#zc mc sk#" +
                        "40%#hs#zc sa sk#zc h8 sb#" +
                        "25%#mh h8 h10#mh h10 h8#" +
                "ur/ne/text/1#" +
                        "100%#ko#se#qu#tr#sp#" +
                        "85%#hc ur h12#hc ne h11#" +
                        "75%#hs#hq#an#qx#" +
                        "60%#zc h11 fi#zc h12 wm#" +
                        "50%#mh h11 h12#mh h12 h11#" +
                        "40%#mz h11 fi#mz h12 wm#" +
                "ur/pl/text/1#" +
                        "100%#ko#qu#sp#" +
                        "85%#hc ur h8#hc pl h11#" +
                        "75%#hs#hq#se#" +
                        "60%#zc ur sk#zc h8 wm#zc h11 sk#" +
                        "50%#mh h8 h11#mh h11 h8#" +
                        "40%#mz h8 wm#mz h11 sk#" +
                "ne/pl/text/1#" +
                        "100%#se 0.5°#" +
                        "85%#hc ne h8#hc pl h12#" +
                        "75%#hs#hq#se 1°#" +
                        "60%#zc h8 fi#zc h12 sk#" +
                        "50%#zc ne sk#mh h8 h12#mh h12 h8#" +
                        "40%#mz h8 fi#mz h12 sk#";

        List<Meaning> additionalMeanings = parseMeanings(text);

        m.addAll(additionalMeanings);
    }

    public List<Meaning> parseMeanings(String text) throws InvalidAttributesException {
        String[] textParts = text.split("#");
        String[] partParts = null;
        Integer weight = 0;
        Boolean prozessed = false;
        String lastPart = null;
        String forlastPart = null;
        String prefix = null;
        String conType = null;
        double fade = 0;
        List<Meaning> meaningsList = new ArrayList<Meaning>();
        Meaning meaning = null;
        Constalation constalation = null;
        for (String part : textParts) {
            //New Meaning
            if (part.contains("/")) {
                if (meaning != null) {
                    meaningsList.add(meaning);
                }
                partParts = part.split("/");

                meaning = new Meaning(parseObj(partParts[0]), parseObj(partParts[1]), partParts[2], Integer.parseInt(partParts[3]));
            } else if (!prozessed && part.contains("%")) {//set temp weigth
                weight = Integer.parseInt(part.substring(0, part.length() - 1));
            } else if(meaning != null)
            //must be an Constalation
            {
                partParts = part.split(" ");

                lastPart = null;
                forlastPart = null;
                prefix = null;
                conType = null;
                fade = 0;

                //check for last Parts
                if (partParts.length >= 2) {
                    lastPart = partParts[partParts.length - 1];
                }
                if (partParts.length >= 3) {
                    forlastPart = partParts[partParts.length - 2];
                }

                //check Prefixes
                if (lastPart != null && (lastPart.equals("+") || lastPart.equals("-"))) {
                    prefix = lastPart;
                }
                if (forlastPart != null && (forlastPart.equals("+") || forlastPart.equals("-"))) {
                    prefix = forlastPart;
                }

                //check fade
                if (lastPart != null && lastPart.contains("°")) {
                    fade = Double.parseDouble(lastPart.substring(0, lastPart.length() - 1));
                }
                if (forlastPart != null && forlastPart.contains("°")) {
                    fade = Double.parseDouble(forlastPart.substring(0, lastPart.length() - 1));
                }

                //check for constalation type
                conType = partParts[0];
                //check for Angel based Constalation
                if (conType.equals("ko")) {
                    constalation = new ConjunktionConstalation(weight, meaning.getPl1(), meaning.getPl2());
                    if (prefix != null) ((AngelConstalation) constalation).setPrefix(prefix);
                    if (fade > 0) ((AngelConstalation) constalation).setFade(fade);
                } else
                if (conType.equals("an")) {
                    constalation = new EighthalfquadratConstalation(weight, meaning.getPl1(), meaning.getPl2());
                    if (prefix != null) ((AngelConstalation) constalation).setPrefix(prefix);
                    if (fade > 0) ((AngelConstalation) constalation).setFade(fade);
                } else
                if (conType.equals("hq")) {
                    constalation = new HalfquadratConstalation(weight, meaning.getPl1(), meaning.getPl2());
                    if (prefix != null) ((AngelConstalation) constalation).setPrefix(prefix);
                    if (fade > 0) ((AngelConstalation) constalation).setFade(fade);
                } else
                if (conType.equals("hs")) {
                    constalation = new HalfsextilConstalation(weight, meaning.getPl1(), meaning.getPl2());
                    if (prefix != null) ((AngelConstalation) constalation).setPrefix(prefix);
                    if (fade > 0) ((AngelConstalation) constalation).setFade(fade);
                } else
                if (conType.equals("sp")) {
                    constalation = new MirrorConstalation(weight, meaning.getPl1(), meaning.getPl2());
                    if (prefix != null) ((AngelConstalation) constalation).setPrefix(prefix);
                    if (fade > 0) ((AngelConstalation) constalation).setFade(fade);
                } else
                if (conType.equals("op")) {
                    constalation = new OppositionConstalation(weight, meaning.getPl1(), meaning.getPl2());
                    if (prefix != null) ((AngelConstalation) constalation).setPrefix(prefix);
                    if (fade > 0) ((AngelConstalation) constalation).setFade(fade);
                } else
                if (conType.equals("qu")) {
                    constalation = new QuadratConstalation(weight, meaning.getPl1(), meaning.getPl2());
                    if (prefix != null) ((AngelConstalation) constalation).setPrefix(prefix);
                    if (fade > 0) ((AngelConstalation) constalation).setFade(fade);
                } else
                if (conType.equals("qx")) {
                    constalation = new QuincunxConstalation(weight, meaning.getPl1(), meaning.getPl2());
                    if (prefix != null) ((AngelConstalation) constalation).setPrefix(prefix);
                    if (fade > 0) ((AngelConstalation) constalation).setFade(fade);
                } else
                if (conType.equals("se")) {
                    constalation = new SextilConstalation(weight, meaning.getPl1(), meaning.getPl2());
                    if (prefix != null) ((AngelConstalation) constalation).setPrefix(prefix);
                    if (fade > 0) ((AngelConstalation) constalation).setFade(fade);
                } else
                if (conType.equals("tr")) {
                    constalation = new TrigonConstalation(weight, meaning.getPl1(), meaning.getPl2());
                    if (prefix != null) ((AngelConstalation) constalation).setPrefix(prefix);
                    if (fade > 0) ((AngelConstalation) constalation).setFade(fade);
                } else
                if (conType.equals("zc")) {
                    constalation = new ZodiacConstalation(weight, parseObj(partParts[1]), parseAni(partParts[2]));
                } else
                if (conType.equals("mz")) {
                    constalation = new MasterInZodiacConstalation(weight, parseObj(partParts[1]), parseAni(partParts[2]));
                } else
                if (conType.equals("hc")) {
                    constalation = new HouseConstalation(weight, parseObj(partParts[1]), parseObj(partParts[2]));
                } else
                if (conType.equals("mh")) {
                    constalation = new MasterInHouseConstalation(weight, parseObj(partParts[1]), parseObj(partParts[2]));
                }
                else {
                    throw new InvalidAttributesException("Spezifikation nicht gefunden: "+conType);
                }
                meaning.addConstalation(constalation);
            }
        }
        if(meaning != null) meaningsList.add(meaning);
        return meaningsList;
    }

    public AstroObj parseObj(String objStr) {
        switch (objStr) {
            case "so":
                return AstroObj.Sun;
            case "mo":
                return AstroObj.Moon;
            case "me":
                return AstroObj.Mercury;
            case "ve":
                return AstroObj.Venus;
            case "ma":
                return AstroObj.Mars;
            case "ju":
                return AstroObj.Jupiter;
            case "sa":
                return AstroObj.Saturn;
            case "ur":
                return AstroObj.Uranus;
            case "ne":
                return AstroObj.Neptune;
            case "pl":
                return AstroObj.Pluto;
            case "h1":
            case "ac":
                return AstroObj.house1;
            case "h2":
                return AstroObj.house2;
            case "h3":
                return AstroObj.house3;
            case "h4":
            case "ic":
                return AstroObj.house4;
            case "h5":
                return AstroObj.house5;
            case "h6":
                return AstroObj.house6;
            case "h7":
            case "dc":
                return AstroObj.house7;
            case "h8":
                return AstroObj.house8;
            case "h9":
                return AstroObj.house9;
            case "h10":
            case "mc":
                return AstroObj.house10;
            case "h11":
                return AstroObj.house11;
            case "h12":
                return AstroObj.house12;
            case "mk":
                return AstroObj.trueNode;
            default:
                throw new IllegalArgumentException(objStr);
        }
    }

    public AstroAni parseAni(String objStr) {
        switch (objStr) {
            case "wi":
                return AstroAni.Aries;
            case "st":
                return AstroAni.Taurus;
            case "zw":
                return AstroAni.Gemini;
            case "kr":
                return AstroAni.Cancer;
            case "lo":
                return AstroAni.Leo;
            case "jf":
                return AstroAni.Virgo;
            case "wa":
                return AstroAni.Libra;
            case "sk":
                return AstroAni.Scorpio;
            case "sc":
                return AstroAni.Sagittarius;
            case "sb":
                return AstroAni.Capricornus;
            case "wm":
                return AstroAni.Aquarius;
            case "fi":
                return AstroAni.Pisces;
            default:
                throw new IllegalArgumentException(objStr);
        }
    }

    public List<Meaning> getMeanings() {
        return m;
    }
}
