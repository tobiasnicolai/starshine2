package de.tobias.nicolai.astro.checks;

import de.tobias.nicolai.astro.Ephemeris;

public class MasterInHouseConstalation extends HouseConstalation {
    private AstroAni zodiacOfObj;
    private AstroObj masterOfZodiac;
    public MasterInHouseConstalation(AstroObj obj, AstroObj ani) {
        super(obj, ani);
    }

    public MasterInHouseConstalation(Integer weight, AstroObj obj, AstroObj ani) {
        super(weight, obj, ani);
    }

    private void calculate(Ephemeris eph){
        zodiacOfObj = calcZodiacOf(eph.getAstroObjPos(planet));
        masterOfZodiac = calcMasterOf(zodiacOfObj);
    }

    @Override
    protected Boolean check(Ephemeris eph) {
        calculate(eph);
        return super.isInHouse(eph.getAstroObjPos(masterOfZodiac),house,eph);
    }

    @Override
    public String toName() {
        return "Herrscher ("+zodiacOfObj.name()+"/"+masterOfZodiac.name()+") von " + planet.name()+" in "+house.name();
    }

    @Override
    public String toString() {
        return "MasterInZodiacConstalation{" +
                "obj=" + planet +
                ", ani=" + house +
                ", weight=" + weight +
                '}';
    }
}
