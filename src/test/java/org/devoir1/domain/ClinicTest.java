package org.devoir1.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClinicTest {

    // Doctor : FIFO Radiology : FIFO
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

    // Doctor : GRAVITY Radiology : FIFO
    @Test
    public void patientHasMoreSevereSymptomsOfFlu_ShouldBeFirstDoctorQueue_NotBeInRadiologyQueue() {
        Clinic clinic = new Clinic(TriageType.GRAVITY, TriageType.FIFO);

        clinic.triagePatient("John", 4, VisibleSymptom.MIGRAINE);
        clinic.triagePatient("Robert", 7, VisibleSymptom.FLU);

        Assertions.assertEquals("Robert", clinic.getNextInDoctorQueue().name);
        Assertions.assertNull(clinic.getNextInRadiologyQueue());
    }

    @Test
    public void patientHasMoreSevereRadiologySymptoms_ShouldBeFirstInDoctorQueue_ShouldBeSecondInRadiologyQueue() {
        Clinic clinic = new Clinic(TriageType.GRAVITY, TriageType.FIFO);

        clinic.triagePatient("Bob", 2, VisibleSymptom.SPRAIN);
        clinic.triagePatient("Jack", 7, VisibleSymptom.BROKEN_BONE);

        Assertions.assertEquals("Jack", clinic.getNextInDoctorQueue().name);
        Assertions.assertEquals("Bob", clinic.getNextInDoctorQueue().name);

        Assertions.assertEquals("Bob", clinic.getNextInRadiologyQueue().name);
        Assertions.assertEquals("Jack", clinic.getNextInRadiologyQueue().name);
    }
}