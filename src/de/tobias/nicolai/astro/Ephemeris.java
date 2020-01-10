package de.tobias.nicolai.astro;

import de.tobias.nicolai.astro.checks.AstroAni;
import de.tobias.nicolai.astro.checks.AstroObj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Ephemeris {

    private Date time;

    private Double house1;
    private Double house2;
    private Double house3;
    private Double house4;
    private Double house5;
    private Double house6;
    private Double house7;
    private Double house8;
    private Double house9;
    private Double house10;
    private Double house11;
    private Double house12;
    private Double ascendant;
    private Double mc;
    private Double armc;
    private Double vertex;
    private Double equatAsc;
    private Double coAscWKoch;
    private Double coAscMunkasey;
    private Double polarAsc;
    private Double sun;
    private Double moon;
    private Double mercury;
    private Double venus;
    private Double mars;
    private Double jupiter;
    private Double saturn;
    private Double uranus;
    private Double neptune;
    private Double pluto;
    private Double meanNode;
    private Double trueNode;
    private Double meanApogee;
    private Double oscApogee;
    private Double intpApogee;
    private Double intpPerigee;
    private Double chiron;
    private Double pholus;
    private Double ceres;
    private Double pallas;
    private Double juno;
    private Double vesta;

    public Ephemeris(Date time) {
        this.time = time;
    }

    public void setAstroObject(String name, Double value) {
        switch (name) {
            case "Sun":
                this.sun = value;
                break;
            case "Moon":
                this.moon = value;
                break;
            case "Mercury":
                this.mercury = value;
                break;
            case "Venus":
                this.venus = value;
                break;
            case "Mars":
                this.mars = value;
                break;
            case "Jupiter":
                this.jupiter = value;
                break;
            case "Saturn":
                this.saturn = value;
                break;
            case "Uranus":
                this.uranus = value;
                break;
            case "Neptune":
                this.neptune = value;
                break;
            case "Pluto":
                this.pluto = value;
                break;
            case "mean Node":
                this.meanNode = value;
                break;
            case "true Node":
                this.trueNode = value;
                break;
            case "mean Apogee":
                this.meanApogee = value;
                break;
            case "osc. Apogee":
                this.oscApogee = value;
                break;
            case "intp. Apogee":
                this.intpApogee = value;
                break;
            case "intp. Perigee":
                this.intpPerigee = value;
                break;
            case "Chiron":
                this.chiron = value;
                break;
            case "Pholus":
                this.pholus = value;
                break;
            case "Ceres":
                this.ceres = value;
                break;
            case "Pallas":
                this.pallas = value;
                break;
            case "Juno":
                this.juno = value;
                break;
            case "Vesta":
                this.vesta = value;
                break;
            case "house  1":
                this.house1 = value;
                break;
            case "house  2":
                this.house2 = value;
                break;
            case "house  3":
                this.house3 = value;
                break;
            case "house  4":
                this.house4 = value;
                break;
            case "house  5":
                this.house5 = value;
                break;
            case "house  6":
                this.house6 = value;
                break;
            case "house  7":
                this.house7 = value;
                break;
            case "house  8":
                this.house8 = value;
                break;
            case "house  9":
                this.house9 = value;
                break;
            case "house 10":
                this.house10 = value;
                break;
            case "house 11":
                this.house11 = value;
                break;
            case "house 12":
                this.house12 = value;
                break;
            case "Ascendant":
                this.ascendant = value;
                break;
            case "MC":
                this.mc = value;
                break;
            case "ARMC":
                this.armc = value;
                break;
            case "Vertex":
                this.vertex = value;
                break;
            case "equat. Asc.":
                this.equatAsc = value;
                break;
            case "co-Asc. W.Koch":
                this.coAscWKoch = value;
                break;
            case "co-Asc Munkasey":
                this.coAscMunkasey = value;
                break;
            case "Polar Asc.":
                this.polarAsc = value;
                break;
            default:
                break;
        }
    }

    public Double getAstroObjPos(AstroObj obj) {
        switch (obj) {
            case Ceres:
                return getCeres();
            case Chiron:
                return getChiron();
            case intpApogee:
                return getIntpApogee();
            case intpPerigee:
                return getIntpPerigee();
            case Juno:
                return getJuno();
            case Jupiter:
                return getJupiter();
            case Mars:
                return getMars();
            case meanApogee:
                return getMeanApogee();
            case meanNode:
                return getMeanNode();
            case Mercury:
                return getMercury();
            case Moon:
                return getMoon();
            case Neptune:
                return getNeptune();
            case oscApogee:
                return getOscApogee();
            case Pallas:
                return getPallas();
            case Pholus:
                return getPholus();
            case Pluto:
                return getPluto();
            case Saturn:
                return getSaturn();
            case Sun:
                return getSun();
            case trueNode:
                return getTrueNode();
            case Uranus:
                return getUranus();
            case Venus:
                return getVenus();
            case Vesta:
                return getVesta();
            case armc:
                return getArmc();
            case ascendant:return getAscendant();
            case coAscMunkasey:return getCoAscMunkasey();
            case coAscWKoch:return getCoAscWKoch();
            case equatAsc:return getEquatAsc();
            case mc:return getMc();
            case polarAsc:return getPolarAsc();
            case vertex:return getVertex();
            case house1: return getHouse1();
            case house2: return getHouse2();
            case house3: return getHouse3();
            case house4: return getHouse4();
            case house5: return getHouse5();
            case house6: return getHouse6();
            case house7: return getHouse7();
            case house8: return getHouse8();
            case house9: return getHouse9();
            case house10: return getHouse10();
            case house11: return getHouse11();
            case house12: return getHouse12();
            default:
                return null;
        }
    }

    public double calcDiff(double a, double b) {
        double c = a - b;
        if (c < 0) c = c * (-1.0);
        if (c > 180.0) c = 360.0 - c;
        return c;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    public Double getSun() {
        return sun;
    }

    public Double getMoon() {
        return moon;
    }

    public Double getMercury() {
        return mercury;
    }

    public Double getVenus() {
        return venus;
    }

    public Double getMars() {
        return mars;
    }

    public Double getJupiter() {
        return jupiter;
    }

    public Double getSaturn() {
        return saturn;
    }

    public Double getUranus() {
        return uranus;
    }

    public Double getNeptune() {
        return neptune;
    }

    public Double getPluto() {
        return pluto;
    }

    public Double getMeanNode() {
        return meanNode;
    }

    public Double getTrueNode() {
        return trueNode;
    }

    public Double getMeanApogee() {
        return meanApogee;
    }

    public Double getOscApogee() {
        return oscApogee;
    }

    public Double getIntpApogee() {
        return intpApogee;
    }

    public Double getIntpPerigee() {
        return intpPerigee;
    }

    public Double getChiron() {
        return chiron;
    }

    public Double getPholus() {
        return pholus;
    }

    public Double getCeres() {
        return ceres;
    }

    public Double getPallas() {
        return pallas;
    }

    public Double getJuno() {
        return juno;
    }

    public Double getVesta() {
        return vesta;
    }

    public Double getHouse1() {
        return house1;
    }

    public Double getHouse2() {
        return house2;
    }

    public Double getHouse3() {
        return house3;
    }

    public Double getHouse4() {
        return house4;
    }

    public Double getHouse5() {
        return house5;
    }

    public Double getHouse6() {
        return house6;
    }

    public Double getHouse7() {
        return house7;
    }

    public Double getHouse8() {
        return house8;
    }

    public Double getHouse9() {
        return house9;
    }

    public Double getHouse10() {
        return house10;
    }

    public Double getHouse11() {
        return house11;
    }

    public Double getHouse12() {
        return house12;
    }

    public Double getAscendant() {
        return ascendant;
    }

    public Double getMc() {
        return mc;
    }

    public Double getArmc() {
        return armc;
    }

    public Double getVertex() {
        return vertex;
    }

    public Double getEquatAsc() {
        return equatAsc;
    }

    public Double getCoAscWKoch() {
        return coAscWKoch;
    }

    public Double getCoAscMunkasey() {
        return coAscMunkasey;
    }

    public Double getPolarAsc() {
        return polarAsc;
    }

    public String positionToZodiacFormat(Double pos){
        Integer posNr = (int)(pos/30.0) ;
        Double rest = pos % 30.0;
        List<AstroAni> zodiac = new ArrayList<AstroAni>(Arrays.asList(new AstroAni[] {AstroAni.Aquarius, AstroAni.Aries, AstroAni.Cancer, AstroAni.Capricornus, AstroAni.Gemini, AstroAni.Leo, AstroAni.Libra, AstroAni.Pisces, AstroAni.Sagittarius, AstroAni.Scorpio, AstroAni.Taurus, AstroAni.Virgo})) ;
        return zodiac.get(posNr) + " " + rest.toString();
    }

    @Override
    public String toString() {
        return "Ephemeris{" +
                "time=" + time +
                ", sun=" + sun +
                ", moon=" + moon +
                ", mercury=" + mercury +
                ", venus=" + venus +
                ", mars=" + mars +
                ", jupiter=" + jupiter +
                ", saturn=" + saturn +
                ", uranus=" + uranus +
                ", neptune=" + neptune +
                ", pluto=" + pluto +
                ", house1=" + house1 +
                ", house2=" + house2 +
                ", house3=" + house3 +
                ", house4=" + house4 +
                ", house5=" + house5 +
                ", house6=" + house6 +
                ", house7=" + house7 +
                ", house8=" + house8 +
                ", house9=" + house9 +
                ", house10=" + house10 +
                ", house11=" + house11 +
                ", house12=" + house12 +
                ", ascendant=" + ascendant +
                ", mc=" + mc +
                ", armc=" + armc +
                ", vertex=" + vertex +
                ", equatAsc=" + equatAsc +
                ", coAscWKoch=" + coAscWKoch +
                ", coAscMunkasey=" + coAscMunkasey +
                ", polarAsc=" + polarAsc +
                ", meanNode=" + meanNode +
                ", trueNode=" + trueNode +
                ", meanApogee=" + meanApogee +
                ", oscApogee=" + oscApogee +
                ", intpApogee=" + intpApogee +
                ", intpPerigee=" + intpPerigee +
                ", chiron=" + chiron +
                ", pholus=" + pholus +
                ", ceres=" + ceres +
                ", pallas=" + pallas +
                ", juno=" + juno +
                ", vesta=" + vesta +
                '}';
    }
}
