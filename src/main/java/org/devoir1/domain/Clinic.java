package org.devoir1.domain;

import java.util.LinkedList;

public class Clinic {

    TriageType doctorTriageType;
    TriageType radiologyTriageType;
    LinkedList<Patient> doctorQueue = new LinkedList<>();
    LinkedList<Patient> radiologyQueue = new LinkedList<>();
    public Clinic(TriageType doctorTriageType, TriageType radiologyTriageType) {
        this.doctorTriageType = doctorTriageType;
        this.radiologyTriageType = radiologyTriageType;
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        Patient newPatient = new Patient(name,gravity,visibleSymptom);
        if (newPatient.visibleSymptom != VisibleSymptom.CORONAVIRUS) {
            if (doctorTriageType.equals(TriageType.GRAVITY) && newPatient.gravity >5) {
                doctorQueue.addFirst(newPatient);
            } else {
                doctorQueue.add(newPatient);
            }

            if (visibleSymptom.equals(VisibleSymptom.BROKEN_BONE) || visibleSymptom.equals(VisibleSymptom.SPRAIN)) {
                if (radiologyTriageType.equals(TriageType.GRAVITY) && newPatient.gravity >5) {
                    radiologyQueue.addFirst(newPatient);
                } else {
                    radiologyQueue.add(newPatient);
                }
            }
        }
    }

    public Patient getNextInDoctorQueue() {
        return doctorQueue.poll();
    }

    public Patient getNextInRadiologyQueue() {
        return radiologyQueue.poll();
    }

    // D'autres méthodes peuvent être nécessaires

}