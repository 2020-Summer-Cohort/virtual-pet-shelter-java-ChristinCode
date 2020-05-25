package shelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*### VirtualPetShelter class
 ***[ ] return a specific `VirtualPet` given its name*/

public class virtualPetShelter {
    //Map
    private Map<String, virtualPet> shelterMap = new HashMap<>();

//Constructor

    //Map to add
    public void addPet(virtualPet animal) {
        shelterMap.put(animal.getPetName(), animal);
    }

    //Map to remove
    public void removePet(String petName) {
        shelterMap.remove(petName);
    }

    //Map collection
    public Collection<virtualPet> fetchingValuesOfAllPets() {
        return shelterMap.values();
    }

    //Map to Feed and sleep all
    public void feedAll(int fed) {
        for (virtualPet hungryPet : shelterMap.values()) {
            hungryPet.feed(fed);
        }
    }

    public void sleepAll(int nap) {
        for (virtualPet tirednessPet : shelterMap.values()) {
            tirednessPet.sleep(nap);
        }
    }

    //play individual
    public void playOnePet(String petName, int activity) {
        shelterMap.get(petName).play(activity);
    }

    //name
    public virtualPet returnOnePet(String petName) {
        return shelterMap.get(petName);
    }

    //getnames
    public void receivePetNames() {
        for (virtualPet nameOfPet : shelterMap.values()) {
            System.out.println(nameOfPet.getPetName() + ": " + nameOfPet.getDescription());
        }
    }


    //Tick Method
    public void tickAll() {
        for (virtualPet tickForPet : shelterMap.values()) {
            tickForPet.tick();
        }
    }

    public boolean isAnimalInShelter(String petName) {
        return shelterMap.containsKey(petName);
    }

}

