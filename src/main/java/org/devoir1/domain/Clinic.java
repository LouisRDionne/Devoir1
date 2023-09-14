package org.devoir1.domain;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Clinic {
    Queue<Patient> doctorQueue;
    Queue<Patient> radiologyQueue;
    public Clinic(TriageType doctorTriageType, TriageType radiologyTriageType) {
        if (doctorTriageType.equals(TriageType.FIFO)) {
            doctorQueue = new LinkedList<>();
        } else {
            doctorQueue = new PriorityQueue<>();
        }

        if (radiologyTriageType.equals(TriageType.FIFO)) {
            radiologyQueue = new LinkedList<>();
        } else {
            radiologyQueue = new PriorityQueue<>();
        }
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        Patient newPatient = new Patient(name,gravity,visibleSymptom);
        doctorQueue.add(newPatient);
        if (visibleSymptom.equals(VisibleSymptom.BROKEN_BONE) || visibleSymptom.equals(VisibleSymptom.SPRAIN)) {
            radiologyQueue.add(newPatient);
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