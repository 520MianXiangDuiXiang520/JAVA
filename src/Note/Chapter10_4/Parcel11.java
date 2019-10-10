package Note.Chapter10_4;

public class Parcel11 {
    private static class ParcelContents implements Contents {
        private int i = 11;
        @Override
        public int value() {
            return i;
        }
    }

    protected static class ParcelDestination implements Destination {
        private String label;
        private ParcelDestination(String whereTo){
            label = whereTo;
        }
        @Override
        public String readLabel() {
            return label;
        }
        public static void f(){ }
        static int x = 10;
        static class AnotherLabel {
            public static void f() {}
            static int x = 10;
        }
    }

    public static Destination destination(String s){
        return new ParcelDestination(s);
    }

    public static Contents contents() {
        return new ParcelContents();
    }

    public static void main(String[] args) {
        Contents contents = contents();
        Destination destination = destination("aa");
    }

}
