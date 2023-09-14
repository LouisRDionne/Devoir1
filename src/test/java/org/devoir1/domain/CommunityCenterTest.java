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
}