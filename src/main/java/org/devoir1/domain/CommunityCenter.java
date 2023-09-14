package org.devoir1.domain;

import java.util.LinkedList;

public class CommunityCenter {
    TriageType triageType;
    LinkedList<Patient> queue = new LinkedList<>();
    public CommunityCenter(TriageType triageType) {
        this.triageType = triageType;
    }

    public void triagePatient(String name, int gravity) {
        Patient newPatient = new Patient(name,gravity);

        if (triageType.equals(TriageType.GRAVITY) && newPatient.gravity > 5) {
            queue.addFirst(newPatient);
        } else {
            queue.add(newPatient);
        }
    }

    public Patient getNextInQueue() {
        return queue.poll();
    }
}
