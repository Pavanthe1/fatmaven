
package com.voting;

public class Voter {
    private final String name;
    private final int age;
    private final String citizenship;
    private final String voterId;
    private final boolean voterIdValid;

    public Voter(String name, int age, String citizenship,
                 String voterId, boolean voterIdValid) {
        this.name = name;
        this.age = age;
        this.citizenship = citizenship;
        this.voterId = voterId;
        this.voterIdValid = voterIdValid;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public String getVoterId() {
        return voterId;
    }

    public boolean isVoterIdValid() {
        return voterIdValid;
    }
}
