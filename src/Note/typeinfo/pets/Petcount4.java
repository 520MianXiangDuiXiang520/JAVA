package Note.typeinfo.pets;

import junbao.tool.TypeCounter;

public class Petcount4 {
    public static void main(String[] args) {
        TypeCounter typeCounter = new TypeCounter(Pet.class);
        for(Pet pet: Pets.createArray(20)){
            typeCounter.count(pet);
        }
        System.out.println(typeCounter);
    }
}
