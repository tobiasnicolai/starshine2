package de.tobias.nicolai.astro.checks;

import de.tobias.nicolai.astro.Ephemeris;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constalation {
    protected Integer weight;

    protected Boolean check(Ephemeris eph){
        return true;
    }

    protected Boolean isInZodiac(Double objPos, AstroAni ani){
        switch(ani){
            case Aries: return objPos >= 0.0 && objPos < 30.0;
            case Taurus: return objPos >= 30.0 && objPos < 60.0;
            case Gemini: return objPos >= 60.0 && objPos < 90.0;
            case Cancer: return objPos >= 90.0 && objPos < 120.0;
            case Leo: return objPos >= 120.0 && objPos < 150.0;
            case Virgo: return objPos >= 150.0 && objPos < 180.0;
            case Libra: return objPos >= 180.0 && objPos < 210.0;
            case Scorpio: return objPos >= 210.0 && objPos < 240.0;
            case Sagittarius: return objPos >= 240.0 && objPos < 270.0;
            case Capricornus: return objPos >= 270.0 && objPos < 300.0;
            case Aquarius: return objPos >= 300.0 && objPos < 330.0;
            case Pisces: return objPos >= 330.0 && objPos < 360.0;
            default: return false;
        }
    }

    protected AstroAni calcZodiacOf(Double objPos){
        if(objPos >= 0.0 && objPos < 30.0) return AstroAni.Aries;
            if(objPos >= 30.0 && objPos < 60.0) return AstroAni.Taurus;
            if(objPos >= 60.0 && objPos < 90.0) return AstroAni.Gemini;
            if(objPos >= 90.0 && objPos < 120.0) return AstroAni.Cancer;
            if(objPos >= 120.0 && objPos < 150.0) return AstroAni.Leo;
            if(objPos >= 150.0 && objPos < 180.0) return AstroAni.Virgo;
            if(objPos >= 180.0 && objPos < 210.0) return AstroAni.Libra;
            if(objPos >= 210.0 && objPos < 240.0) return AstroAni.Scorpio;
            if(objPos >= 240.0 && objPos < 270.0) return AstroAni.Sagittarius;
            if(objPos >= 270.0 && objPos < 300.0) return AstroAni.Capricornus;
            if(objPos >= 300.0 && objPos < 330.0) return AstroAni.Aquarius;
            if(objPos >= 330.0 && objPos < 360.0) return AstroAni.Pisces;
        return null;
    }

    protected AstroObj calcMasterOf(AstroAni ani){
        switch(ani){
            case Aries: return AstroObj.Mars;
            case Taurus: return AstroObj.Venus;
            case Gemini: return AstroObj.Mercury;
            case Cancer: return AstroObj.Moon;
            case Leo: return AstroObj.Sun;
            case Virgo: return AstroObj.Mercury;
            case Libra: return AstroObj.Venus;
            case Scorpio: return AstroObj.Pluto;
            case Sagittarius: return AstroObj.Jupiter;
            case Capricornus: return AstroObj.Saturn;
            case Aquarius: return AstroObj.Uranus;
            case Pisces: return AstroObj.Neptune;
            default: return null;
        }
    }

    protected AstroObj calcMaster(Double objPos){
        return calcMasterOf(calcZodiacOf(objPos));
    }

    protected Boolean isInHouse(Double objPos, AstroObj house, Ephemeris eph){
        AstroObj[] possibleHouses = new AstroObj[] {AstroObj.house1, AstroObj.house2, AstroObj.house3, AstroObj.house4, AstroObj.house5, AstroObj.house6, AstroObj.house7, AstroObj.house8, AstroObj.house9, AstroObj.house10, AstroObj.house11, AstroObj.house12};
        List<AstroObj> possibleHousesList = new ArrayList<AstroObj>(Arrays.asList(possibleHouses));
        AstroObj nextHouse;

        // set nextHouse
        if(house == AstroObj.house12){
            nextHouse = AstroObj.house1;
        } else {
            nextHouse = possibleHousesList.get(possibleHousesList.indexOf(house) + 1);
        }

        Double housePos = eph.getAstroObjPos(house);
        Double nextHousePos = eph.getAstroObjPos(nextHouse);
        //check if house contains 0°
        if(nextHousePos < housePos){
            return objPos >= housePos || ( objPos > 0.0 && objPos < nextHousePos );
        } else {
            return objPos >= housePos && objPos < nextHousePos;
        }
    }

    public Double getAngelBetween(Double a, Double b){
        Double diff;
        if(a>b){
            diff = a-b;
        } else {
            diff = b-a;
        }
        if(diff > 180.0){
            diff = 360.0 - diff;
        }
        return diff;
    }

    public Integer getWeight() {
        return weight;
    }

    public String toName() {
        return "n/a";
    }
}
