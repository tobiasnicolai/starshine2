package de.tobias.nicolai.astro.checks;

import de.tobias.nicolai.astro.Ephemeris;

public class MasterInZodiacConstalation extends ZodiacConstalation {
    private AstroAni zodiacOfObj;
    private AstroObj masterOfZodiac;
    public MasterInZodiacConstalation(AstroObj obj, AstroAni ani) {
        super(obj, ani);
    }

    public MasterInZodiacConstalation(Integer weight, AstroObj obj, AstroAni ani) {
        super(weight, obj, ani);
    }

    private void calculate(Ephemeris eph){
        zodiacOfObj = calcZodiacOf(eph.getAstroObjPos(obj));
        masterOfZodiac = calcMasterOf(zodiacOfObj);
    }

    @Override
    protected Boolean check(Ephemeris eph) {
        calculate(eph);
        return super.isInZodiac(eph.getAstroObjPos(masterOfZodiac),ani);
    }

    @Override
    public String toName() {
        return "Herrscher ("+zodiacOfObj.name()+"/"+masterOfZodiac.name()+") von " + obj.name()+" in "+ani.name();
    }

    @Override
    public String toString() {
        return "MasterInZodiacConstalation{" +
                "obj=" + obj +
                ", ani=" + ani +
                ", weight=" + weight +
                '}';
    }
}
