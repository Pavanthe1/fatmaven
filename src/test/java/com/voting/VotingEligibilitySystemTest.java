
package com.voting;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VotingEligibilitySystemTest {

    @Test
    void eligibleVoter() {
        Voter voter = new Voter(
                "Arun", 25, "Indian", "VOTER123", true);

        assertTrue(
                VotingEligibilitySystem.checkEligibility(voter).isEmpty());
    }

    @Test
    void underageVoter() {
        Voter voter = new Voter(
                "Ravi", 17, "Indian", "VOTER123", true);

        List<String> reasons =
                VotingEligibilitySystem.checkEligibility(voter);

        assertTrue(reasons.stream().anyMatch(
                reason -> reason.contains("Underage")));
    }

    @Test
    void nonIndianCitizen() {
        Voter voter = new Voter(
                "John", 30, "Other", "VOTER123", true);

        List<String> reasons =
                VotingEligibilitySystem.checkEligibility(voter);

        assertTrue(reasons.stream().anyMatch(
                reason -> reason.contains("Not an Indian citizen")));
    }

    @Test
    void invalidVoterId() {
        Voter voter = new Voter(
                "Meena", 22, "Indian", "VOTER123", false);

        List<String> reasons =
                VotingEligibilitySystem.checkEligibility(voter);

        assertTrue(reasons.stream().anyMatch(
                reason -> reason.contains("invalid voter ID")));
    }

    @Test
    void ageExactlyEighteenIsEligible() {
        Voter voter = new Voter(
                "Priya", 18, "Indian", "VOTER456", true);

        assertTrue(
                VotingEligibilitySystem.checkEligibility(voter).isEmpty());
    }

    @Test
    void multipleEligibilityFailuresAreReported() {
        Voter voter = new Voter(
                "Sam", 16, "Other", "", false);

        List<String> reasons =
                VotingEligibilitySystem.checkEligibility(voter);

        assertEquals(3, reasons.size());
    }

    @Test
    void citizenshipCheckIsCaseInsensitive() {
        Voter voter = new Voter(
                "Kiran", 20, "indian", "VOTER789", true);

        assertTrue(
                VotingEligibilitySystem.checkEligibility(voter).isEmpty());
    }
}
