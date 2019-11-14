package Note.typeinfo.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {

    private static List<Class<? extends Pet>> types = new ArrayList<>();

    private static String[] typeNames = {
            "Note.typeinfo.pets.Mutt",
            "Note.typeinfo.pets.Pug",
            "Note.typeinfo.pets.EgyptianMau",
            "Note.typeinfo.pets.Manx",
            "Note.typeinfo.pets.Cymric",
            "Note.typeinfo.pets.Rat",
            "Note.typeinfo.pets.Mouse",
            "Note.typeinfo.pets.Hamster"
    };

    @SuppressWarnings("unchecked")
    private static void loader(){
        try{
            for(String s: typeNames){
                types.add((Class<? extends Pet>) Class.forName(s));
            }
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 由于@SuppressWarnings("unchecked")标签不能作用于直接作用于静态初始化子句之上
    // 故把它放在一个块中，保证最初执行
    static{
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }

    public static void main(String[] args) {
        ForNameCreator forNameCreator = new ForNameCreator();
    }
}
