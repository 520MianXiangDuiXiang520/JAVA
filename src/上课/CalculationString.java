package 上课;
import java.util.Scanner;
import java.util.Stack;

public class CalculationString {
    public static void main(String[] args) {
        String str = "(2+1)%3*6";
        double result1 = compute(str);
        System.out.println((int) result1);
    }

    public static int priority(char s) {
        switch (s) {
            case '(':
            case ')':
                return 0;
            case '-':
            case '+':
                return 1;
            case '*':
            case '%':
            case '/':
                return 2;
            default:
                return -1;

        }
    }

    public static double compute(double num1, double num2, char s) {
        switch (s) {
            case '(':
            case ')':
                return 0;
            case '-':
                return num1 - num2;
            case '+':
                return num1 + num2;
            case '%':
                return num1 % num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                return 0;

        }
    }

    public static double compute(String str) {
        double num[] = new double[20];
        int flag = 0, begin = 0, end = 0, now;
        now = -1;
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);
            if (s == ' ') {

            } else if (s == '+' || s == '-' || s == '*' || s == '/' || s == '(' || s == ')' || s == '%') {
                if (flag == 1) {
                    now += 1;
                    if (end < begin) {
                        num[now] = Integer.valueOf(str.substring(begin, begin + 1));
                    } else {
                        num[now] = Integer.valueOf(str.substring(begin, end + 1));
                    }
                    // System.out.println(num[now]);
                    flag = 0;
                }
                if (s == '-') {
                    if (i == 0) {
                        flag = 1;
                        begin = 0;
                    } else if (str.charAt(i - 1) == '(' || str.charAt(i - 1) == '*'
                            || str.charAt(i - 1) == '/') {
                        flag = 1;
                        begin = i;
                    }
                    else {
                        if (st.empty()) {
                            st.push(s);
                        } else if (s == ')') {
                            num[now - 1] = compute(num[now - 1], num[now], st.pop());
                            now -= 1;
                            st.pop();
                        } else if (s == '(') {
                            st.push(s);
                        } else if (priority(s) <= priority(st.peek())) {
                            num[now - 1] = compute(num[now - 1], num[now], st.pop());
                            now -= 1;
                            st.push(s);
                        } else {
                            st.push(s);
                        }
                    }
                } else if (st.empty()) {
                    st.push(s);
                } else if (s == ')') {
                    num[now - 1] = compute(num[now - 1], num[now], st.pop());
                    now -= 1;
                    st.pop();
                } else if (s == '(') {
                    st.push(s);
                } else if (priority(s) <= priority(st.peek())) {
                    num[now - 1] = compute(num[now - 1], num[now], st.pop());
                    now -= 1;
                    st.push(s);
                } else {
                    st.push(s);
                }

            } else if (flag == 0) {
                flag = 1;
                begin = i;
            } else {
                end = i;
            }

        }
        if (flag == 1) {
            now += 1;
            if (end < begin) {
                num[now] = Integer.valueOf(str.substring(begin, begin + 1));
            } else {
                num[now] = Integer.valueOf(str.substring(begin, end + 1));
            }
            // System.out.println(num[now]);
        }
        while (now > 0) {
            num[now - 1] = compute(num[now - 1], num[now], st.pop());
            now -= 1;
        }
        return num[0];
    }

}





