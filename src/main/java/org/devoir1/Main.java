package org.devoir1;

import org.devoir1.domain.Clinic;
import org.devoir1.domain.TriageType;
import org.devoir1.domain.VisibleSymptom;

public class Main {
    public static void main(String[] args) {
        // Ceci n'est pas un test!! C'est un exemple d'utilisation.
        TriageType doctorTriageType = TriageType.FIFO;
        TriageType radiologyTriageType = TriageType.FIFO;

        Clinic clinic = new Clinic(doctorTriageType, radiologyTriageType);
        clinic.triagePatient("John", 4, VisibleSymptom.MIGRAINE);
    }
}