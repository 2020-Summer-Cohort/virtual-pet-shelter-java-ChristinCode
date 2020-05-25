package shelter;

import java.util.Random;

public class virtualPet {
    private String name;
    private String description;
    private int hunger;
    private int boredom;
    private int tiredness;
    private int tickCount;

    public virtualPet(String petName, String petDescription) {
        Random generateNumber = new Random();
        int numberGenerated;

        this.name = petName;
        this.description = petDescription;
        numberGenerated = generateNumber.nextInt(50);
        this.hunger = numberGenerated;
        numberGenerated = generateNumber.nextInt(50);
        this.boredom = numberGenerated;
        numberGenerated = generateNumber.nextInt(50);
        this.tiredness = numberGenerated;
        this.tickCount = 0;
    }

    public String getPetName() {

        return name;
    }

    public String getDescription() {

        return description;
    }

    public int getBoredom() {

        return boredom;
    }

    public int getHungry() {

        return hunger;
    }

    public int getTiredness() {

        return tiredness;
    }

    public int getTickCount() {

        return tickCount;
    }

    public void feed(int fed) {
        if (hunger - fed >= 0) {
            hunger = hunger - fed;
        } else {
            hunger = 0;
        }
        if (boredom + 5 <= 50) {
            boredom = boredom + 5;
        } else {
            boredom = 50;
        }
        if (tiredness + 5 <= 50) {
            tiredness = tiredness + 5;
        } else {
            tiredness = 50;
        }
    }

    public void play(int activity) {
        if (boredom - activity >= 0) {
            boredom = boredom - activity;
        } else {
            boredom = 0;
        }
        if (tiredness + 5 <= 50) {
            tiredness = tiredness + 5;
        } else {
            tiredness = 50;
        }
        if (hunger + 5 <= 50) {
            hunger = hunger + 5;
        } else {
            hunger = 50;
        }
    }

    public void sleep(int nap) {
        if (tiredness - nap >= 0) {
            tiredness = tiredness - nap;
        } else {
            tiredness = 0;
        }
        if (hunger + 5 <= 50) {
            hunger = hunger + 5;
        } else {
            hunger = 50;
        }
        if (boredom + 5 <= 50) {
            boredom = boredom + 5;
        } else {
            boredom = 50;
        }
    }

    public void tick() {
        Random selfDetermination = new Random();
        int randomMood;
        tickCount++;

        randomMood = selfDetermination.nextInt(51);
        if (randomMood == 50) {
            feed(5);
        } else if (randomMood >= 45) {
            sleep(5);
        } else if (randomMood >= 26 && randomMood <= 48) {
            play(5);
        }
        if (hunger + 1 <= 50) {
            hunger = hunger + 1;
        } else {
            hunger = 50;
        }
        if (boredom + 1 <= 50) {
            boredom = boredom + 1;
        } else {
            boredom = 50;
        }
        if (tiredness + 2 <= 50) {
            tiredness = tiredness + 2;
        } else {
            tiredness = 50;
        }
    }
}


