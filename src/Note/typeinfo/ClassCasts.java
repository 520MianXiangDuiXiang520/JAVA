package Note.typeinfo;

import 上课.interfacedemo.B;

class Building {}
class House extends Building {}

public class ClassCasts {
    public static void main(String[] args) {
        Building building = new House();
        Class<House> houseClass = House.class;
        House h = houseClass.cast(building);
//        House h = (House) building;
    }
}
