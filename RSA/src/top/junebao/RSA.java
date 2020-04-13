package top.junebao;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class RSA {
    private static final BigInteger E = new BigInteger("3");
    private static BigInteger N = null;
    private static BigInteger D = null;
//    private static BigInteger p1 = new BigInteger("53");
//    private static BigInteger p2 = new BigInteger("59");

    private static BigInteger p1 = null;
    private static BigInteger p2 = null;

    private static BigInteger getP1(int len) {
        if(p1 == null)
            p1 = GetBigPrime.getBigPrime(len);
        return p1;
    }

    private static BigInteger getP2(int len) {
        if(p2 == null)
            p2 =  GetBigPrime.getBigPrime(len);
        return p2;
    }

    private static BigInteger getN(int len) {
        return getP1(len).multiply(getP2(len));
    }

    private static int getK(BigInteger fn) {
        BigInteger bk;
        for (int k = 1;; k++) {
            bk = new BigInteger(k + "");
            if((((fn.multiply(bk)).add(BigInteger.ONE)).remainder(E)).equals(BigInteger.ZERO)) {
                return k;
            }
            if(k >= 1000)
                return -1;
        }
    }

    private static BigInteger getD(BigInteger fn, BigInteger bk) {
        return ((bk.multiply(fn)).add(BigInteger.ONE)).divide(E);
    }

    /**
     * 获取随机的公钥和私钥
     * @param len p1, p2 的长度
     */
    public static void getKey(int len) {
        BigInteger fn = (getP1(len).subtract(BigInteger.ONE)).multiply(getP2(len).subtract(BigInteger.ONE));
        int k;
        while((k = getK(fn)) == -1) {
            p1 = null;
            p2 = null;
            fn = (getP1(len).subtract(BigInteger.ONE)).multiply(getP2(len).subtract(BigInteger.ONE));
        }
        BigInteger bk = new BigInteger(k + "");
        BigInteger d = getD(fn, bk);
        BigInteger n = getN(len);
        D = d;
        N = n;
        System.out.println("公钥：（ e = " + E + ", n = " + N + "）");
        System.out.println("私钥：（ d = " + D + ", n = " + N + "）");
    }

    @SuppressWarnings("all")
    public static String encode(String text, String pkE, String pkN) {
        BigInteger bpkN = new BigInteger(pkN);
        BigInteger bpkE = new BigInteger(pkE);
        List<BigInteger> bigIntegersTexts = StrBit.stringToBigInt(text);
//        System.out.println(bigIntegersTexts);
        List<BigInteger> result = new LinkedList<>();
        for (BigInteger bigIntegersText : bigIntegersTexts) {
            result.add((bigIntegersText.pow(bpkE.intValue())).mod(bpkN));
        }
//        System.out.println("加密后的：" + result);
        return StrBit.bigIntToString(result);
    }

    @SuppressWarnings("all")
    public static String decode(String cipherText, String pkD, String pkN) {
        BigInteger bpkN = new BigInteger(pkN);
        BigInteger bpkD = new BigInteger(pkD);
        List<BigInteger> cipherTexts = StrBit.stringToBigInt(cipherText);
//        System.out.println("解密前：" + cipherTexts);
        List<BigInteger> result = new LinkedList<>();
        for (BigInteger text : cipherTexts) {
            BigInteger mod = (text.pow(bpkD.intValue())).mod(bpkN);
            result.add(mod);
        }
//        System.out.println("解密出的bigInteger: " + result);
        return StrBit.bigIntToString(result);
    }

    public static void main(String[] args) {

//        getKey(2);

        String e = "3";
        String n = "1081";
        String d = "675";
        System.out.println("加密后的结果： " + encode("junebao.top", e, n));
        System.out.println("解密后的结果： " + decode("̓ʌġl˒ĵ¦.ϵ¦˅", d, n));
    }
}
