import java.math.BigDecimal;

public class MyBigDecimal {
    private String integ, decimal;
    private double input;
    MyBigDecimal(double input){
        String[] input_list = (input + "").split("\\.");
        integ = input_list[0];
        decimal = input_list[1];
        this.input = input;
    }

    MyBigDecimal(){}

    private Long replenish(long arg, int len) {
        String sarg = arg + "";
        while(sarg.length() < len){
            sarg  = sarg + "0";
        }
        return Long.parseLong(sarg);
    }

    public static void add(MyBigDecimal mbd, MyBigDecimal mbd2){
        int max_length = 0;  // 小数部分最大长度
        String x1z,x1x,x2z,x2x;
        x1z = mbd2.integ;  // x1整数部分
        x1x = mbd2.decimal;  // x1小数部分
        x2z = mbd.integ;  // x2整数部分
        x2x = mbd.decimal;  // x2小数部分

        String rz, rx;  // 计算结果整数部分，小数部分的引用

        // 补充长度，使小数部分等长
        if(x1x.length() < x2x.length()){
            while(x1x.length() < x2x.length()){
                x1x = x1x + "0";
            }
            max_length = x2x.length();
        }else{
            while(x2x.length() < x1x.length()){
                x2x += "0";
            }
            max_length = x1x.length();
        }

        rz = (Integer.valueOf(x1z) + Integer.valueOf(x2z)) + "";
        rx = (Integer.valueOf(x2x) + Integer.valueOf(x1x)) + "";

        if(rx.length() > max_length){
            rx = rx.substring(1, max_length+1);
            rz = (Integer.valueOf(rz) + 1) + "";
        } else if(rx.length() < max_length){
            while (rx.length() < max_length){
                rx = "0" + rx;
            }
        }
        System.out.println(mbd.integ + "." + mbd.decimal + " + " +
                mbd2.integ + "." + mbd2.decimal + " = " + rz + "." + rx);
    }

    public static void multiply(MyBigDecimal x1, MyBigDecimal x2){
        MyBigDecimal myBigDecimal = new MyBigDecimal();
        int x1Integ = Integer.valueOf(x1.integ);
        int x2Integ = Integer.valueOf(x2.integ);
        int x1Decimal = Integer.valueOf(x1.decimal);
        int x2Decimal = Integer.valueOf(x2.decimal);
        long jinWei = 0;

        long resultInteg = x1Integ * x2Integ;

        // x1 的整数部分乘以 x2 的小数部分
        long resultLeft = x1Integ * x2Decimal;
        long resultLeftInteg = resultLeft / (int) Math.pow(10, x2.decimal.length());
        long resultLeftDecial = resultLeft % (int) Math.pow(10, x2.decimal.length());
        resultLeftDecial = myBigDecimal.replenish(resultLeftDecial, (x1.decimal.length() + x2.decimal.length()));

        // x2 的整数部分乘以 x1 的小数部分

        long resultRight = x2Integ * x1Decimal;
        long resultRightInteg = resultRight / (int) Math.pow(10, x1.decimal.length());
        long resultRightDecial = resultRight % (int) Math.pow(10, x1.decimal.length());
        resultRightDecial = myBigDecimal.replenish(resultRightDecial, (x1.decimal.length() + x2.decimal.length()));

        // 小数部分乘以小数部分
        long resultDouble = x1Decimal * x2Decimal;
        long resultDoubleInteg = resultDouble / (int) Math.pow(10, x1.decimal.length() + x2.decimal.length());
        long resultDoubleDecial = resultDouble % (int) Math.pow(10, x1.decimal.length() + x2.decimal.length());

        long resultDecial = resultLeftDecial + resultRightDecial + resultDoubleDecial;

        jinWei = resultDecial / (int) Math.pow(10, x1.decimal.length() + x2.decimal.length());
        resultDecial = resultDecial % (int) Math.pow(10, x1.decimal.length() + x2.decimal.length());

        resultInteg = resultInteg + resultLeftInteg + resultRightInteg + jinWei + resultDoubleInteg;

        System.out.println(x1Integ + "." + x1Decimal + " * "
                + x2Integ + "." + x2Decimal + " = " + resultInteg + "." + resultDecial);
    }

    private static double div(MyBigDecimal mdb1, MyBigDecimal mbd2, int scale){
        if (scale < 0) {
            throw new IllegalArgumentException(" the scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(mdb1.input));
        BigDecimal b2 = new BigDecimal(Double.toString(mbd2.input));
        double result = b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(mdb1.input + " / " + mbd2.input + " = " + result);
        return result;
    }

    public static void main(String[] args) {
        MyBigDecimal mbd1 = new MyBigDecimal(12.1232348);
        MyBigDecimal mbd2 = new MyBigDecimal(5.90099);
        add(mbd2, mbd1);
        multiply(mbd1, mbd2);
        div(mbd1,mbd2,4);
    }
}
