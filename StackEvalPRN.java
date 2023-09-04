import java.util.Objects;
import java.util.Stack;

public class StackEvalPRN {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String token : tokens) {
            if (!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) {
                st.push(Integer.parseInt(token));
            } else {
                int post = st.pop();
                int pre = st.pop();
                int result = switch (token) {
                    case "+" -> pre + post;
                    case "-" -> pre - post;
                    case "*" -> pre * post;
                    default -> pre / post;
                };
                st.push(result);
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
