package de.tobias.nicolai.astro.checks;

import de.tobias.nicolai.astro.Ephemeris;

public class HouseConstalation extends Constalation {
    protected AstroObj planet;
    protected AstroObj house;

    public HouseConstalation(AstroObj planet, AstroObj house) {
        this.planet = planet;
        this.house = house;
        this.weight = 100;
    }

    public HouseConstalation(Integer weight, AstroObj planet, AstroObj house) {
        this.planet = planet;
        this.house = house;
        this.weight = weight;
    }

    @Override
    protected Boolean check(Ephemeris eph) {
        return isInHouse(eph.getAstroObjPos(planet),house,eph);
    }

    @Override
    public String toName() {
        return planet.name() + " in " + house.name();
    }
}
