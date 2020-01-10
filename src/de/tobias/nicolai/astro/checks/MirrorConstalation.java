package de.tobias.nicolai.astro.checks;

import de.tobias.nicolai.astro.Ephemeris;

public class MirrorConstalation extends AngelConstalation {

    private final Double defaultAngel = 0.0;
    private final Double defaultFade = 0.75;

    private String achse = "";

    @Override
    public String toName() {
        return "Spiegelpunkt zur "+achse+"-Achse (+/-"+((Double)(this.fade)).toString()+"°) -> "+this.prefix+this.weight+"%";
    }

    public MirrorConstalation(Integer weight, AstroObj planet1, AstroObj planet2) {
        this.weight = weight;
        this.planet1 = planet1;
        this.planet2 = planet2;
        this.angel = this.defaultAngel;
        this.fade = this.defaultFade;
        this.prefix = "";
    }

    public MirrorConstalation(Integer weight, AstroObj planet1, AstroObj planet2, Double fade) {
        this.weight = weight;
        this.planet1 = planet1;
        this.planet2 = planet2;
        this.angel = this.defaultAngel;
        this.fade = fade/2.0;
        this.prefix = "";
    }

    public MirrorConstalation(Integer weight, AstroObj planet1, AstroObj planet2, String prefix) {
        this.weight = weight;
        this.planet1 = planet1;
        this.planet2 = planet2;
        this.angel = this.defaultAngel;
        this.fade = this.defaultFade;
        this.prefix = prefix;
    }

    public MirrorConstalation(Integer weight, AstroObj planet1, AstroObj planet2, Double fade, String prefix) {
        this.weight = weight;
        this.planet1 = planet1;
        this.planet2 = planet2;
        this.angel = 0.0;
        this.fade = fade/2.0;
        this.prefix = prefix;
    }

    @Override
    protected Boolean check(Ephemeris eph) {
        Double posP1 = eph.getAstroObjPos(planet1);
        Double posP2 = eph.getAstroObjPos(planet2);

        Double diffP190 = getAngelBetween(posP1, 90.0);
        Double diffP290 = getAngelBetween(posP2, 90.0);
        Double diffP10 = getAngelBetween(posP1, 0.0);
        Double diffP20 = getAngelBetween(posP2, 0.0);

        if(diffP190 > diffP290 - fade && diffP190 < diffP290 + fade){
            achse = AstroAni.Cancer.name()+"/"+AstroAni.Capricornus.name();
            return true;
        }else if(diffP10 > diffP20 - fade && diffP10 < diffP20 + fade){
            achse = AstroAni.Aries.name()+"/"+AstroAni.Libra.name();
            return true;
        }else{
            return false;
        }
    }
}
