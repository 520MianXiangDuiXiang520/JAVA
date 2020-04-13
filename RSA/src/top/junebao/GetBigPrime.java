package top.junebao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class GetBigPrime {

    private static Integer[] getPrimeTable(int end) {
        Integer [] result = {0};
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 3; i < end; i += 2) {
            list.add(i);
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if(list.get(j) % list.get(i) == 0){
                    list.remove(j);
                }
            }
        }


        return list.toArray(result);
    }

    /**
     * 获取一个随机的大奇数
     * @param len 奇数的长度
     * @return 一个大奇数
     */
    private static BigInteger getBigOdd(int len) {
        StringBuilder sb = new StringBuilder();
        int [] odds = {1, 3, 7, 9};
        Random random = new Random();
        sb.append(random.nextInt(9) + 1);
        for (int i = 1; i < len - 1; i++) {
            sb.append(random.nextInt(10));
        }
        sb.append(odds[random.nextInt(3)]);
        return new BigInteger(sb.toString());
    }

    /**
     * 通过大奇数获得一个伪素数
     * @return 返回一个伪素数
     */
    private static BigInteger getPseudoPrime(int len) {
        Integer [] primeTable = null;
        if(len > 4)
            primeTable = getPrimeTable(2000);
        else if(len == 3) primeTable = getPrimeTable(200);
        else primeTable = getPrimeTable(20);
        while(true) {
            BigInteger odd = getBigOdd(len);
            int flag = 0;
            for (Integer integer : primeTable) {
                flag ++;
                if (odd.mod(new BigInteger(integer.toString())).equals(BigInteger.ZERO)) {
                    break;
                }
            }
            if(flag == primeTable.length)
                return odd;
        }
    }

    /**
     * miller_rabin 素性检测
     * https://blog.csdn.net/qq_41021816/article/details/80055961
     * @param pseudoPrime 伪素数
     * @return 如果伪素数是素数，返回true, 否则返回false
     */
    private static boolean primalityTest(BigInteger pseudoPrime) {
        if (pseudoPrime.equals(BigInteger.valueOf(0)) || pseudoPrime.equals(BigInteger.valueOf(1)))
            return false;
        if (pseudoPrime.equals(BigInteger.valueOf(2)))
            return true;
        int s=10;
        BigInteger k=pseudoPrime.subtract(BigInteger.valueOf(1));
        int t=0;
        while (k.getLowestSetBit()!=0){
            t++;
            k=k.divide(BigInteger.valueOf(2));
        }
        Random ran = new Random();
        while (s-->0){
            BigInteger a=new BigInteger(100,ran).mod(
                    pseudoPrime.subtract(BigInteger.valueOf(2))).add(BigInteger.valueOf(2) );
            BigInteger[] x= new BigInteger[105];
            x[0]=a.modPow(k,pseudoPrime);
            for (int i=1;i<=t;i++){
                x[i]=x[i-1].modPow(BigInteger.valueOf(2),pseudoPrime);
                if (x[i].equals(BigInteger.valueOf(1)) && !x[i - 1].equals(BigInteger.valueOf(1)) &&
                        !x[i - 1].equals(pseudoPrime.subtract(BigInteger.valueOf(1))))
                    return false;
            }
            if (!x[t].equals(BigInteger.valueOf(1)))
                return false;
        }
        return true;
    }

    /**
     * 获取一个素数（基于概率）
     * @param len 素数长度
     * @return 返回一个BigInteger类型的素数
     */
    public static BigInteger getBigPrime(int len) {
        BigInteger pseudoPrime = getPseudoPrime(len);
        while(!primalityTest(pseudoPrime)){
            pseudoPrime = getPseudoPrime(len);
        }
        return pseudoPrime;
    }

    public static void main(String[] args) {
        System.out.println(getBigPrime(1));
    }

}
