package de.tobias.nicolai.astro.checks;

import java.util.*;

public class Meaning implements Comparable<Meaning>{
    String title;
    String text;
    List<Constalation> constalations;
    Integer page;
    AstroObj pl1 = null;
    AstroObj pl2 = null;

    Integer weight;

    public Meaning(String title, String text) {
        this.title = title;
        this.text = text;
        this.weight = 0;
        this.constalations = new ArrayList<Constalation>();
        this.page = 0;
    }

    public Meaning(String title, String text, Integer page) {
        this.title = title;
        this.text = text;
        this.weight = 0;
        this.constalations = new ArrayList<Constalation>();
        this.page = page;
    }

    public Meaning(String title, String text, List<Constalation> constalations) {
        this.title = title;
        this.text = text;
        this.constalations = constalations;
        this.weight = 0;
        this.page = 0;
    }

    public Meaning(AstroObj planet1, AstroObj planet2, String text, Integer page){
        this.title = planet1.name() + "/" + planet2.name();
        this.text = text;
        this.weight = 0;
        this.constalations = new ArrayList<Constalation>();
        this.page = page;
        this.pl1 = planet1;
        this.pl2 = planet2;
    }

    public void printMeaning(){
        System.out.println("==========================================================================================");
        System.out.println(this.title + "("+this.weight+"%)");
        System.out.println(this.text + "-- Seite " + this.page);
        for(Constalation constalation : this.constalations){
            System.out.println("    "+constalation.toName());
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Constalation> getConstalations() {
        return constalations;
    }

    public void setConstalations(List<Constalation> constalations) {
        this.constalations = constalations;
    }

    public void addConstalation(Constalation constalation) {
        this.constalations.add(constalation);
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void raiseWeight(Integer add) {
        this.weight = this.weight + add;
    }

    public AstroObj getPl1() {
        return pl1;
    }

    public AstroObj getPl2() {
        return pl2;
    }

    @Override
    public int compareTo(Meaning meaning) {
        return this.getWeight().compareTo(meaning.getWeight());
    }
}
