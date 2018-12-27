package cn.cy.data_struct.stack.postfix;

import java.util.Stack;

public class FixExpression {

    /**
     * 中缀表达式转后缀表达式
     * @param infix
     * @return
     */
    public static String toPostfix(String infix) throws Exception {

        char[] chars = infix.toCharArray();

        StringBuffer sb = new StringBuffer();
        Stack<Character> stack = new Stack<>();

        Character tmp;
        for(char c : chars){
            switch (c) {
                case '+' :
                case '-' :
                    // +- 优先级最低,非(则全部出栈
                    while(!stack.isEmpty()){
                        tmp = stack.pop();
                         if(tmp.equals('(')){
                             stack.push(tmp);
                             break;
                         }
                        sb.append(tmp);
                    }
                    stack.push(c);
                    break;

                case '*' :
                case '/' :
                    // 如果栈顶为 * 或 / 则先出栈
                    while(!stack.isEmpty()){
                        tmp = stack.pop();
                        if(tmp.equals('+') || tmp.equals('-') || tmp.equals('(')){
                            stack.push(tmp);
                            break;
                        }

                        sb.append(tmp);
                    }
                    // 入栈
                    stack.push(c);
                    break;

                case '(' :
                    // 括号优先级最高 压入
                    stack.push(c);
                    break;

                case ')' :
                    // 右括号 找到对应的左括号
                    while(!stack.isEmpty()){
                        tmp = stack.pop();
                        if(tmp.equals('(')){
                            break;
                        }
                        sb.append(tmp);
                    }
                    break;

                default:
                    // 数字直接输出
                    sb.append(c);
                    break;
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }


    public static Float calc(String postFix){

        char[] chars = postFix.toCharArray();
        Stack<String> stack = new Stack<>();

        Float a,b,tmp;
        for(char c : chars){
            switch (c) {
                case '+' :
                    tmp = Float.valueOf(stack.pop())+Float.valueOf(stack.pop());
                    stack.push(tmp.toString());
                    break;
                case '-' :
                    a = Float.valueOf(stack.pop());
                    b = Float.valueOf(stack.pop());
                    tmp = b - a;
                    stack.push(tmp.toString());
                    break;
                case '*' :
                    tmp = Float.valueOf(stack.pop())*Float.valueOf(stack.pop());
                    stack.push(tmp.toString());
                    break;
                case '/' :
                    a = Float.valueOf(stack.pop());
                    b = Float.valueOf(stack.pop());
                    tmp = b/a;
                    stack.push(tmp.toString());
                    break;
                default:
                    // 数字压入栈中
                    stack.push(String.valueOf(c));
                    break;
            }
        }

        return Float.valueOf(stack.pop());
    }


    public static void main(String[] args) throws Exception {
        System.out.println(toPostfix("(A+B*C)/D"));
        System.out.println(toPostfix("6*(7+8)/5"));
        System.out.println(toPostfix("6*(7+8*5/1)/5"));
        System.out.println(calc(toPostfix("6*(7+8-5/1)/5")));
    }
}
