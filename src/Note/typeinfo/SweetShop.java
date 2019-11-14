package Note.typeinfo;

class Candy {
    static {
        System.out.println("Candy()");
    }
}

class Gum {
    static {
        System.out.println("Gum()");
    }
}

class Cookie {
    static {
        System.out.println("Cookie");
    }
}

public class SweetShop {
    public static void main(String[] args) {
        System.out.println("start main()");
        new Candy();
        System.out.println("after new Candy()");
        try{
            Class.forName("Note.typeinfo.Gum");
        }catch(ClassNotFoundException e) {
            System.out.println("class not find");
        }
        System.out.println("after class.forName()");
        new Cookie();
        System.out.println("after new Cookie()");
    }
}
