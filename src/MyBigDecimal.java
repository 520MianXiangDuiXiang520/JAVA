public class MyBigDecimal {
    private String integ, decimal;
    MyBigDecimal(double input){
        String[] input_list = (input + "").split("\\.");
        integ = input_list[0];
        decimal = input_list[1];
    }

    private Long replenish(long arg, int len) {
        String sarg = arg + "";
        while(sarg.length() < len){
            sarg  = sarg + "0";
        }
        return Long.parseLong(sarg);
    }

    public void add(MyBigDecimal mbd){
        int max_length = 0;  // 小数部分最大长度
        String x1z,x1x,x2z,x2x;
        x1z = this.integ;  // x1整数部分
        x1x = this.decimal;  // x1小数部分
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
        System.out.println(rz + "." + rx);
    }

    public void multiply(MyBigDecimal x1, MyBigDecimal x2){
        int x1Integ = Integer.valueOf(x1.integ);
        int x2Integ = Integer.valueOf(x2.integ);
        int x1Decimal = Integer.valueOf(x1.decimal);
        int x2Decimal = Integer.valueOf(x2.decimal);
        long jinWei = 0;

        long resaultInteg = x1Integ * x2Integ;

        // x1 的整数部分乘以 x2 的小数部分

        long resaultLeft = x1Integ * x2Decimal;
        long resaultLeftInteg = resaultLeft / (int) Math.pow(10, x2.decimal.length());
        long resaultLeftDecial = resaultLeft % (int) Math.pow(10, x2.decimal.length());
        resaultLeftDecial = replenish(resaultLeftDecial, (x1.decimal.length() + x2.decimal.length()));

        // x2 的整数部分乘以 x1 的小数部分

        long resaultRight = x2Integ * x1Decimal;
        long resaultRightInteg = resaultRight / (int) Math.pow(10, x1.decimal.length());
        long resaultRightDecial = resaultRight % (int) Math.pow(10, x1.decimal.length());
        resaultRightDecial = replenish(resaultRightDecial, (x1.decimal.length() + x2.decimal.length()));

        // 小数部分乘以小数部分
        long resaultDouble = x1Decimal * x2Decimal;
        long resaultDoubleInteg = resaultDouble / (int) Math.pow(10, x1.decimal.length() + x2.decimal.length());
        long resaultDoubleDecial = resaultDouble % (int) Math.pow(10, x1.decimal.length() + x2.decimal.length());

        long resaultDecial = resaultLeftDecial + resaultRightDecial + resaultDoubleDecial;

        jinWei = resaultDecial / (int) Math.pow(10, x1.decimal.length() + x2.decimal.length());
        resaultDecial = resaultDecial % (int) Math.pow(10, x1.decimal.length() + x2.decimal.length());

        resaultInteg = resaultInteg + resaultLeftInteg + resaultRightInteg + jinWei + resaultDoubleInteg;

        System.out.println(x1Integ + "." + x1Decimal + " * "
                + x2Integ + "." + x2Decimal + " = " + resaultInteg + "." + resaultDecial);
    }

    public static void main(String[] args) {
        MyBigDecimal mbd1 = new MyBigDecimal(12.1232348);
        MyBigDecimal mbd2 = new MyBigDecimal(5.90099);
//        mbd1.add(mbd2);
        mbd1.multiply(mbd1, mbd2);
    }
}
