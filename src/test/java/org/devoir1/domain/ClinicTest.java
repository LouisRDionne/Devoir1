package org.devoir1.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClinicTest {
    @Test
    public void patientHasMigraine_ShouldBeFirstInDoctorQueue_NotInRadiologyQueue() {
        Clinic clinic = new Clinic(TriageType.FIFO,TriageType.FIFO);

        clinic.triagePatient("John",4, VisibleSymptom.MIGRAINE);

        Assertions.assertEquals("John", clinic.getNextInDoctorQueue().name);
        Assertions.assertNull(clinic.getNextInRadiologyQueue());
    }

    @Test
    public void twoPatientsShowUp_SecondPatientShouldBeSecondInDoctorQueue_NotInRadiologyQueue() {
        Clinic clinic = new Clinic(TriageType.FIFO,TriageType.FIFO);

        clinic.triagePatient("John", 4,VisibleSymptom.MIGRAINE);
        clinic.triagePatient("Adam",9,VisibleSymptom.FLU);

        clinic.getNextInDoctorQueue();

        Assertions.assertEquals("Adam", clinic.getNextInDoctorQueue().name);
        Assertions.assertNull(clinic.getNextInRadiologyQueue());
    }

    @Test
    public void patientHasSprain_ShouldBeFirstInDoctorQueue_ShouldBeFirstInRadiologyQueue() {
        Clinic clinic = new Clinic(TriageType.FIFO,TriageType.FIFO);

        clinic.triagePatient("Paul",6, VisibleSymptom.SPRAIN);

        Assertions.assertEquals("Paul", clinic.getNextInDoctorQueue().name);
        Assertions.assertEquals("Paul", clinic.getNextInRadiologyQueue().name);
    }
}