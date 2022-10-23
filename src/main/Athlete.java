package main;

import java.util.ArrayList;
import java.util.List;

public class Athlete {
    private List<Symptom> symptoms;

    public Athlete() {
        this.symptoms = new ArrayList<>();
        symptoms.add(new Symptom("headache", 0));
        symptoms.add(new Symptom("pressure in head", 0));
        symptoms.add(new Symptom("neck pain", 0));
        symptoms.add(new Symptom("nausea and vomiting", 0));
        symptoms.add(new Symptom("dizziness", 0));
        symptoms.add(new Symptom("blurred vision", 0));
        symptoms.add(new Symptom("balance problems", 0));
        symptoms.add(new Symptom("sensitivity to light", 0));
        symptoms.add(new Symptom("sensitivity to noise", 0));
        symptoms.add(new Symptom("feeling slowed down", 0));
        symptoms.add(new Symptom("feeling like \"in a fog\"", 0));
        symptoms.add(new Symptom("\"don't feel right\"", 0));
        symptoms.add(new Symptom("difficulty concentrating", 0));
        symptoms.add(new Symptom("difficulty remembering", 0));
        symptoms.add(new Symptom("fatigue or low energy", 0));
        symptoms.add(new Symptom("confusion", 0));
        symptoms.add(new Symptom("drowsiness", 0));
        symptoms.add(new Symptom("trouble falling asleep", 0));
        symptoms.add(new Symptom("more emotional", 0));
        symptoms.add(new Symptom("irritability", 0));
        symptoms.add(new Symptom("sickness", 0));
        symptoms.add(new Symptom("nervous or anxious", 0));
    }

    public List<Symptom> getSymptoms() {
        return symptoms;
    }
}
