package Note.Chapter10_4;

// 匿名内部类使用外部定义的参数
public class Parcel9 {
    public Contents contents(int out){
        out += 1;
        int finalOut = out;
        return new Contents() {
            private int inner = finalOut;
            @Override
            public int value() {
                inner ++;
                return inner;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 parcel9 = new Parcel9();
        Contents contents = parcel9.contents(8);
        System.out.println(contents.value());
    }
}
