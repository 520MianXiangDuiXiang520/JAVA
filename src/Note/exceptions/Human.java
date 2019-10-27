package Note.exceptions;

class Annoyance extends Exception {}
class Sneeze extends Annoyance {}

public class Human {
    public static void main(String[] args) {
        try{
            throw new Sneeze();
        } catch(Sneeze s) {
            System.out.println("sneeze");
        } catch (Annoyance a) {
            System.out.println("annoyance");
        }

//        try {
//            throw new Sneeze();
//        } catch (Annoyance a) {
//            System.out.println("new Annoyance");
//        } catch (Sneeze s){
//            System.out.println(".....");
//        }
    }
}
