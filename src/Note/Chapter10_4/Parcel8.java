package Note.Chapter10_4;

// 匿名内部类基类有非默认构造器的情况
public class Parcel8 {
    public Wrapping wrapping(int i){
        return new Wrapping(i) {

            @Override
            public int value () {
                return super.value() * 47;
            }
        };
    }

    public static void main(String[] args) {
        Parcel8 parcel8 = new Parcel8();
        Wrapping wrapping = parcel8.wrapping(1);
        System.out.println(wrapping.value());
    }
}
