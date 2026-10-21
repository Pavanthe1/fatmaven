
package com.voting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VotingEligibilitySystem {

    public static List<String> checkEligibility(Voter voter) {
        List<String> reasons = new ArrayList<>();

        if (voter.getAge() < 18) {
            reasons.add("Underage: voter must be at least 18 years old");
        }

        if (!"Indian".equalsIgnoreCase(
                voter.getCitizenship().trim())) {
            reasons.add("Not an Indian citizen");
        }

        if (voter.getVoterId() == null
                || voter.getVoterId().trim().isEmpty()
                || !voter.isVoterIdValid()) {
            reasons.add("Missing or invalid voter ID");
        }

        return reasons;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of voters: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        if (count <= 0) {
            System.out.println("Number of voters must be positive.");
            scanner.close();
            return;
        }

        for (int i = 1; i <= count; i++) {
            System.out.println("\nEnter details for voter " + i);

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Citizenship (Indian/Other): ");
            String citizenship = scanner.nextLine();

            System.out.print("Voter ID: ");
            String voterId = scanner.nextLine();

            System.out.print("Is voter ID valid? (yes/no): ");
            boolean valid = scanner.nextLine()
                    .trim().equalsIgnoreCase("yes");

            Voter voter = new Voter(
                    name, age, citizenship, voterId, valid);

            List<String> reasons = checkEligibility(voter);

            System.out.println("\nResult for " + voter.getName() + ":");

            if (reasons.isEmpty()) {
                System.out.println("ELIGIBLE TO VOTE");
            } else {
                System.out.println("NOT ELIGIBLE TO VOTE");
                for (String reason : reasons) {
                    System.out.println("- " + reason);
                }
            }
        }

        scanner.close();
    }
}
