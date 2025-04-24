import java.util.Stack;

public class Test {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String msg = tokens[i];
            if (msg.equals("+")  || msg.equals("-") || msg.equals("*") || msg.equals("/")) {
                int ret2 = stack.pop();
                int ret1 = stack.pop();
                switch(msg) {
                    case "+":
                        stack.push(ret1 + ret2);
                        break;
                    case "-":
                        stack.push(ret1 - ret2);
                        break;
                    case "*":
                        stack.push(ret1 * ret2);
                        break;
                    case "/":
                        stack.push(ret1 / ret2);
                        break;
                    default:
                        break;
                }
            }else {
                stack.push(Integer.parseInt(msg));
            }
        }
        return stack.pop();
    }
    public static boolean IsPopOrder (int[] pushV, int[] popV) {
    Stack<Integer> stack = new Stack<>();
    int j = 0;
    for (int i = 0; i < pushV.length; i++) {
        int ret = pushV[i];
        stack.push(ret);
        while (!stack.empty() && j < popV.length && stack.peek() == popV[j]) {
            stack.pop();
            j++;
        }
    }
    if(!stack.empty()) {
        return false;
    }
    return true;
}
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length();i++) {
            char ch = s.charAt(i);
            if (ch == '{' || ch == '[' || ch =='(') {
                stack.push(ch);
            }else {
                if (stack.empty()) {
                    return false;
                }
                char ch2 = stack.peek();
                if (ch2 == '{' && ch == '}'|| ch2 == '[' && ch == ']' || ch2 == '(' && ch == ')') {
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int [] pushV = {2,1,0};
        int [] popV = {1,2,0};
        System.out.println(IsPopOrder(pushV, popV));
    }
}
