package Note.typeinfo.pets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class PetCreator {
    private Random rand = new Random(66);
    // 抽象方法，在导出类中实现
    public abstract List<Class<? extends Pet>> types();

    public Pet randomPet() {
        /**
         * 随即返回一个宠物
         */
        int n = rand.nextInt(types().size());
        try {
            return types().get(n).newInstance();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Pet[] createArray(int size) {
        /**
         * 返回一个由随机宠物组成的数组
         */
        Pet[] pets = new Pet[size];
        for (int i = 0; i < size; i++) {
            pets[i] = randomPet();
        }
        return pets;
    }

    public ArrayList<Pet> arrayList(int size) {
        /**
         * 返回一个由随机宠物组成的ArrayList
         */
        ArrayList<Pet> petArrayList = new ArrayList<>();
        Collections.addAll(petArrayList, createArray(size));
        return petArrayList;
    }
}
