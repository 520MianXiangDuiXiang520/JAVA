package Note.holding;

import junbao.tool.Stack;


public class StackTest<T> {
    public static void main(String[] args) {
        Stack stack = new Stack();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack.pop());

    }
}
