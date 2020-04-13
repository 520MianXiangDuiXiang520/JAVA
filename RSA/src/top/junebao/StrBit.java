package top.junebao;

import java.math.BigInteger;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class StrBit {

    public static List<BigInteger> stringToBigInt(String str) {
        LinkedList<BigInteger> bill = new LinkedList<>();
        char[] strChar = str.toCharArray();
        for (char c : strChar) {
            bill.add(new BigInteger(Integer.parseUnsignedInt(Integer.toBinaryString(c),2) + ""));
        }
        return bill;
    }

    //将二进制字符串转换成int数组
    private static int[] binStrToIntArray(String binStr) {
        char[] temp=binStr.toCharArray();
        int[] result=new int[temp.length];
        for(int i=0;i<temp.length;i++) {
            result[i]=temp[i]-48;
        }
        return result;
    }


    //将二进制转换成字符
    private static char binStrToChar(String binStr){
        int[] temp=binStrToIntArray(binStr);
        int sum=0;
        for(int i=0; i<temp.length;i++){
            sum +=temp[temp.length-1-i]<<i;
        }
        return (char)sum;
    }

    public static String bigIntToString(List<BigInteger> bigIntegers){
        StringBuilder sb = new StringBuilder();
        for (BigInteger bigInteger : bigIntegers) {
            sb.append(binStrToChar(bigInteger.toString(2)));
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(stringToBigInt("张君保"));
        System.out.println(bigIntToString(stringToBigInt("张君保")));
    }
}

//[24352, 21531, 20445]
//[24352, 21531, 20445]