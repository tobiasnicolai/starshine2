package de.tobias.nicolai.astro.checks;

import de.tobias.nicolai.astro.Ephemeris;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeaningChecker {
    public static List<Meaning> checkMeanings(List<Meaning> meanings, Ephemeris eph) {
        List<Constalation> constalations = null;
        for(Meaning meaning : meanings){
            constalations = meaning.getConstalations();
            List<Constalation> newConstalations = new ArrayList<Constalation>();
            meaning.setWeight(0);
            for(Constalation constalation : constalations){
                if(constalation.check(eph)){
                    meaning.raiseWeight(constalation.getWeight());
                    newConstalations.add(constalation);
                }
            }
            meaning.setConstalations(newConstalations);
        }
        return meanings;
    }

    public static List<Constalation> cloneList(List<Constalation> list){
        return new ArrayList<Constalation>(list);
    }

    public static void printMeanings(List<Meaning> meanings){
        Collections.sort(meanings, Collections.reverseOrder());

        for(Meaning meaning : meanings){
            if(meaning.getWeight() > 0){
                meaning.printMeaning();
            }
        }
    }
}
