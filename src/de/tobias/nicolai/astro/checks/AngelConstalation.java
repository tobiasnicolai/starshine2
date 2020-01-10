package de.tobias.nicolai.astro.checks;

import de.tobias.nicolai.astro.Ephemeris;

public class AngelConstalation extends Constalation{
    protected AstroObj planet1;
    protected AstroObj planet2;

    protected Double angel;
    protected Double fade; //half of Winkelbereich

    protected String prefix;

    @Override
    protected Boolean check(Ephemeris eph) {
        Double diff = this.getAngelBetween(eph.getAstroObjPos(planet1), eph.getAstroObjPos(planet2));
        return diff > angel - fade && diff < angel + fade;
    }

    public void setFade(Double fade) {
        this.fade = fade;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
