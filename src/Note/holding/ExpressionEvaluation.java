package Note.holding;

import junbao.tool.Stack;

public class ExpressionEvaluation {
    private String expression;

    ExpressionEvaluation(String expression){
        this.expression = expression;
    }

    public String evaluation(){
        Stack stack = new Stack();
        char [] chars = expression.toCharArray();
        for(int i = 0; i< expression.length(); i++){
            if(chars[i] == '+'){
                stack.push(chars[i + 1]);
            }
            if(chars[i] == '-'){
                System.out.print(stack.pop());
            }
        }
        return "";
    }

    public static void main(String[] args) {
        ExpressionEvaluation expressionEvaluation = new ExpressionEvaluation(
                "+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s---");
        expressionEvaluation.evaluation();
    }
}
