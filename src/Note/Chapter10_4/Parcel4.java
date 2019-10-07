package Note.Chapter10_4;

public class Parcel4 {
    private class PDestinstion implements Destination{
        // PDestination 内部类实现了 Destination 接口，但它被定义为 private 只有Parcel4这个类才能访问他
        private String label;

        PDestinstion(String label){
            this.label = label;
        }

        @Override
        public String readLabel(){
            return label;
        }
    }

    class PContents implements Contents{
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    public Destination getDestination(String label){
        return new PDestinstion(label);
    }

    public Contents getContents(){
        return new PContents();
    }
}
