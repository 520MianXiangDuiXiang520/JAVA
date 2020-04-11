package 上课.lasttest;

/**
 * 设计一个表示用户的User类，
 * 类中的变量有用户名、口令和记录用户个数的变量（静态的），
 * 定义类的3个构造方法（没有参数、有一个参数的给用户名赋值、有两个参数的给用户名和口令赋值）、
 * 获取和设置口令的方法、返回字符串表示的类信息的方法（包含用户名、口令）。编写main测试User类
 */

public class User {
    private String username;
    private String password;
    private static int count = 0;

    public User() {
        count ++;
    }

    public User(String username) {
        this.username = username;
        count ++;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        count ++;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static int getCount() {
        // 只有静态方法才能操纵静态属性
        return count;
    }

    public String toString() {
        return this.username + ": " + this.password;
    }

    public static void main(String[] args) {
        User user = new User();
        User user1 = new User("zhangSan");
        User user2 = new User("liSi", "admin");
        user.setUsername("wangWu");
        user.setPassword("admin");
        System.out.println(user);
        System.out.println(user1.username);
        System.out.println(user2.password);
        // 静态方法直接使用
        System.out.println(getCount());
    }
}
