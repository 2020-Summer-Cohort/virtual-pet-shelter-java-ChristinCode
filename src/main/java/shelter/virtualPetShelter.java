package shelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class virtualPetShelter {

    private Map<String, virtualPet> shelterMap = new HashMap<>();

    public void addPet(virtualPet animal) {
        shelterMap.put(animal.getPetName(), animal);
    }

    public void removePet(String petName) {
        shelterMap.remove(petName);
    }

    public Collection<virtualPet> fetchingValuesOfAllPets() {
        return shelterMap.values();
    }

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

    public void playOnePet(String petName, int activity) {
        shelterMap.get(petName).play(activity);
    }

    public virtualPet returnOnePet(String petName) {
        return shelterMap.get(petName);
    }

    public void receivePetNames() {
        for (virtualPet nameOfPet : shelterMap.values()) {
            System.out.println(nameOfPet.getPetName() + ": " + nameOfPet.getDescription());
        }
    }

    public void tickAll() {
        for (virtualPet tickForPet : shelterMap.values()) {
            tickForPet.tick();
        }
    }

    public boolean isAnimalInShelter(String petName) {
        return shelterMap.containsKey(petName);
    }
}