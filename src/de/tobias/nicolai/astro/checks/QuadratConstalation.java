package de.tobias.nicolai.astro.checks;

public class QuadratConstalation extends AngelConstalation {

    private final Double defaultAngel = 90.0;
    private final Double defaultFade = 4.0;

    @Override
    public String toName() {
        return "Quadrat ("+this.angel.toString()+"°+/-"+((Double)(this.fade)).toString()+"°) -> "+this.prefix+this.weight+"%";
    }

    public QuadratConstalation(Integer weight, AstroObj planet1, AstroObj planet2) {
        this.weight = weight;
        this.planet1 = planet1;
        this.planet2 = planet2;
        this.angel = this.defaultAngel;
        this.fade = this.defaultFade;
        this.prefix = "";
    }

    public QuadratConstalation(Integer weight, AstroObj planet1, AstroObj planet2, Double fade) {
        this.weight = weight;
        this.planet1 = planet1;
        this.planet2 = planet2;
        this.angel = this.defaultAngel;
        this.fade = fade/2.0;
        this.prefix = "";
    }

    public QuadratConstalation(Integer weight, AstroObj planet1, AstroObj planet2, String prefix) {
        this.weight = weight;
        this.planet1 = planet1;
        this.planet2 = planet2;
        this.angel = this.defaultAngel;
        this.fade = this.defaultFade;
        this.prefix = prefix;
    }

    public QuadratConstalation(Integer weight, AstroObj planet1, AstroObj planet2, Double fade, String prefix) {
        this.weight = weight;
        this.planet1 = planet1;
        this.planet2 = planet2;
        this.angel = 0.0;
        this.fade = fade/2.0;
        this.prefix = prefix;
    }
}
