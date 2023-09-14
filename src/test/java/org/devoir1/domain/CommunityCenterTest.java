package org.devoir1.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CommunityCenterTest {
    // FIFO
    @Test
    public void threePatientsShowUp_ShouldBeInOrderFIFO() {
        CommunityCenter cc = new CommunityCenter(TriageType.FIFO);

        cc.triagePatient("John", 6);
        cc.triagePatient("Bob", 3);
        cc.triagePatient("Adam", 5);

        Assertions.assertEquals("John", cc.getNextInQueue().name);
        Assertions.assertEquals("Bob", cc.getNextInQueue().name);
        Assertions.assertEquals("Adam", cc.getNextInQueue().name);
    }

    // GRAVITY
    @Test
    public void patientHasMoreSevereSymptom_ShouldBeFirstInQueue() {
        CommunityCenter cc = new CommunityCenter(TriageType.GRAVITY);

        cc.triagePatient("Bob", 3);
        cc.triagePatient("John", 6);

        Assertions.assertEquals("John", cc.getNextInQueue().name);
    }

    // CORONA
    @Test
    public void patientsHaveCoronavirus_ShouldNotBeInQueue() {
        CommunityCenter cc = new CommunityCenter(TriageType.FIFO);

        cc.triagePatient("John", 6, VisibleSymptom.CORONAVIRUS);
        cc.triagePatient("Bob", 3, VisibleSymptom.CORONAVIRUS);
        cc.triagePatient("Adam", 5, VisibleSymptom.CORONAVIRUS);

        Assertions.assertNull(cc.getNextInQueue());
    }

    @Test
    public void mixOfPatientsWithAnWithoutCoronavirus_PatientsWithoutShouldBeInQueue() {
        CommunityCenter cc = new CommunityCenter(TriageType.FIFO);

        cc.triagePatient("John", 6, VisibleSymptom.CORONAVIRUS);
        cc.triagePatient("Bob", 3);
        cc.triagePatient("Adam", 5, VisibleSymptom.CORONAVIRUS);

        Assertions.assertEquals("Bob", cc.getNextInQueue().name);
    }
}