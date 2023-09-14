package org.devoir1.domain;

public class Patient {
    String name;
    int gravity;
    VisibleSymptom visibleSymptom;

    public Patient(String name, int gravity, VisibleSymptom visibleSymptom) {
        this.name = name;
        this.gravity = gravity;
        this.visibleSymptom = visibleSymptom;
    }
}
