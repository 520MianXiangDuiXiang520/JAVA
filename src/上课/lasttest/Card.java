package 上课.lasttest;

/**
 * 定义一个名为 Card 的扑克牌类，该类有两个 private 访问权限的字符串变量 face 和 suit ：
 * 分别描述一张牌的牌面值（如： A 、 K 、 Q 、 J 、 10 、 9 、 … 、 3 、 2 等）
 * 和花色（如：“黑桃”、“红桃”、“梅花”和“方块”）。
 * 定义 Card 类中的 public 访问权限的构造方法，为类中的变量赋值；
 * 定义 protected 访问权限的方法 getFace() ，得到扑克牌的牌面值 ;
 * 定义 protected 访问权限的方法 getSuit() ，得到扑克牌的花色 ;
 * 定义方法 toString() ，返回表示扑克牌的花色和牌面值字符串（如“红桃 A ”、“梅花 10 ” 等）。
 */

public class Card {
    private String face;
    private String suit;

    public Card(String face, String suit) {
        this.face = face;
        this.suit = suit;
    }

    protected String getFace() {
        return this.face;
    }

    protected String getSuit() {
        return this.suit;
    }

    public String toString() {
        return this.suit + this.face;
    }

    public static void main(String[] args) {
        Card r1 = new Card("1", "红桃");
        System.out.println(r1);
        System.out.println(r1.getFace());
        System.out.println(r1.getSuit());
    }
}
