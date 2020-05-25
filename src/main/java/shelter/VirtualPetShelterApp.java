package shelter;

import java.util.Scanner;

/* how to fix lines for midnight*/
public class VirtualPetShelterApp {
    public static void main(String[] args) {
        int usersSelectionNumber = 1;
        String userSelectionName;
        String userSelectionDescription;
        VirtualPetArt art = new VirtualPetArt();

        Scanner stringInput = new Scanner(System.in);
        Scanner userInput = new Scanner(System.in);

        virtualPet pet1 = new virtualPet("Salem", "He is an older, cuddly cat with black fur and green eyes.");
        virtualPet pet2 = new virtualPet("Aspen", "She is a young puppy with long white and grey fur and blue eyes.");
        virtualPet pet3 = new virtualPet("Nina", "She is a brown and white gerbil who tends to bit while being held.");
        virtualPet pet4 = new virtualPet("Midnight", "He is a tiny gerbil with black fur and buck teeth.");

        virtualPetShelter actualShelter = new virtualPetShelter();
        actualShelter.addPet(pet1);
        actualShelter.addPet(pet2);
        actualShelter.addPet(pet3);
        actualShelter.addPet(pet4);

        welcomeStatement(actualShelter);

        while (usersSelectionNumber != 0) {
            directions();
            usersSelectionNumber = userInput.nextInt();
            if (usersSelectionNumber == 1) {
                actualShelter.feedAll(30);
                System.out.println("The animals look well fed. Thanks!");
            } else if (usersSelectionNumber == 2) {
                press2Play(stringInput, actualShelter);
            } else if (usersSelectionNumber == 3) {
                actualShelter.sleepAll(40);
                System.out.println("Shhh... They are all napping");
            } else if (usersSelectionNumber == 4) {
                press4Adopt(stringInput, actualShelter);
            } else if (usersSelectionNumber == 5) {
                press5TakeIn(stringInput, actualShelter);
            } else if (usersSelectionNumber == 6) {
                press6Bios(stringInput, actualShelter);
            }
            if (usersSelectionNumber != 0) {
                actualShelter.tickAll();
                animalsWellBeings(actualShelter);
            } else {
                System.out.println( art.exitGame+"\nThanks for helping today! We hope to have you back soon!");
            }
        }
    }

    private static void press6Bios(Scanner stringInput, virtualPetShelter actualShelter) {
        String userSelectionName;
        actualShelter.receivePetNames();
        System.out.println("Please type in the pets name you would like to learn more about.");
        userSelectionName = stringInput.nextLine();
        if (actualShelter.isAnimalInShelter(userSelectionName)) {
            System.out.println("You chose to learn more about " + actualShelter.returnOnePet(userSelectionName).getPetName() + ".\n"
                    + actualShelter.returnOnePet(userSelectionName).getDescription() + "\n");
        } else {
            System.out.println("Please pick from the names provided.\n");
        }
    }

    private static void press5TakeIn(Scanner stringInput, virtualPetShelter actualShelter) {
        String userSelectionName;
        String userSelectionDescription;
        System.out.println("Someone just found a stray. What should we name it?");
        userSelectionName = stringInput.nextLine();
        System.out.println("Please fill out the type of animal and a short description.");
        userSelectionDescription = stringInput.nextLine();
        virtualPet newPet = new virtualPet(userSelectionName, userSelectionDescription);
        actualShelter.addPet(newPet);
        System.out.println("Great! " + userSelectionName + " has been added.");
    }

    private static void press4Adopt(Scanner stringInput, virtualPetShelter actualShelter) {
        String userSelectionName;
        actualShelter.receivePetNames();
        System.out.println("Put in the name of the animal you are signing adoption paper work for:");
        userSelectionName = stringInput.nextLine();
        if (actualShelter.isAnimalInShelter(userSelectionName)) {
            System.out.println(actualShelter.returnOnePet(userSelectionName).getPetName() + " was just adopted.\n");
            actualShelter.removePet(userSelectionName);
        } else {
            System.out.println("Please pick from the names provided.\n");
        }
    }

    private static void press2Play(Scanner stringInput, virtualPetShelter actualShelter) {
        String userSelectionName;
        actualShelter.receivePetNames();
        System.out.println("Please type in the pets name you would like to play with:");
        userSelectionName = stringInput.nextLine();
        if (actualShelter.isAnimalInShelter(userSelectionName)) {
            actualShelter.returnOnePet(userSelectionName).play(25);
            System.out.println(actualShelter.returnOnePet(userSelectionName).getPetName() + " had fun playing with you!");
        } else {
            System.out.println("Please pick from the names provided.\n");
        }
    }

    private static void directions() {
        //Game Directions
        System.out.println("What would you like to do?\nPress 1 to feed all animals\nPress 2 to play with individual animal\nPress 3 to put all animals to bed\nPress 4 to sign adoption paper work\nPress 5 to take in a new animal\nPress 6 to read animal bio\nPress 0 to end shift and exit game");
    }

    private static void welcomeStatement(virtualPetShelter actualShelter) {
        //welcome statement
        System.out.println("Welcome to the Virtual Pet Shelter. We are excited to have your help taking care \nof our furry friends. " +
                "We will need help with feeding the animals, playing \nwith each one individually, and putting them to bed. " +
                "Below is a list of \nthe animals and their current well being status. " +
                "The well being status tracks \neach animal's hunger, boredom, and tiredness levels.\n");
        animalsWellBeings(actualShelter);
        System.out.println("\nSelecting 1-3 will help take care of the animals Well Being. The higher the number, the" +
                "\nmore attention he/she may need. Select 4 to adopt a pet and select 5 to admit a new pet" +
                "\ninto the shelter. If you are curious to learn about each pet in the shelter select 6." +
                "\nSelect 0 once your shift is complete.\n");
    }

    private static void animalsWellBeings(virtualPetShelter actualShelter) {
        //current status with for loop
        System.out.println("\t\t\t\t\t\t Well Being Levels\n" +
                "\tName:\t|\tHunger Level:\t|\tBoredom Level:\t|\tTiredness Level:\t\n" +
                "------------|-------------------|-------------------|-------------------");
        for (virtualPet animalPets : actualShelter.fetchingValuesOfAllPets()) {
            System.out.println(animalPets.getPetName() + "\t\t|\t\t" + animalPets.getHungry() + "\t\t\t|  \t\t"
                    + animalPets.getBoredom() + "\t\t\t|\t\t\t" + animalPets.getTiredness());
        }
    }
}