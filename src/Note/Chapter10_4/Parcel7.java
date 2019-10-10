package Note.Chapter10_4;

// 匿名内部类
public class Parcel7 {
    public Contents contents() {
        return new Contents() {
            private int i = 11;

            @Override
            public int value() {
                return i;
            }
        };
    }

    public static void main(String[] args) {
        Parcel7 p7 = new Parcel7();
        Contents contents = p7.contents();
        System.out.println(contents.value());;
    }
}
