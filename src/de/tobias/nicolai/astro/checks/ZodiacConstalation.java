package de.tobias.nicolai.astro.checks;

import de.tobias.nicolai.astro.Ephemeris;

public class ZodiacConstalation extends Constalation {
    protected AstroObj obj;
    protected AstroAni ani;

    public ZodiacConstalation(AstroObj obj, AstroAni ani) {
        this.obj = obj;
        this.ani = ani;
        this.weight = 100;
    }

    public ZodiacConstalation(Integer weight, AstroObj obj, AstroAni ani) {
        this.obj = obj;
        this.ani = ani;
        this.weight = weight;
    }

    @Override
    protected Boolean check(Ephemeris eph) {
        return super.isInZodiac(eph.getAstroObjPos(obj),ani);
    }

    @Override
    public String toName() {
        return obj.name()+" in "+ani.name();
    }

    @Override
    public String toString() {
        return "ZodiacConstalation{" +
                "obj=" + obj +
                ", ani=" + ani +
                ", weight=" + weight +
                '}';
    }
}
