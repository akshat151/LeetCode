import java.util.Collections;
import java.util.Stack;

public class checkValidString {

    public static boolean checkValidString(String s) {
        int count = 0;
        Stack<Character> characters = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                characters.push(s.charAt(i));
            } else if(s.charAt(i)=='*' && !characters.isEmpty()){
                characters.push(s.charAt(i));
                count++;
            } else if(!characters.isEmpty()){
                if((characters.peek()=='(' && s.charAt(i)==')') || (characters.peek()=='*' && s.charAt(i)==')')){
                    characters.pop();
                }
            } else if(s.charAt(i) == ')'){
                return false;
            }
        }
        if(characters.contains('*')){
            count--;
        }
        return count == characters.size() || characters.size() == 0;
    }
    public static void main(String[] args) {
        System.out.println(checkValidString("(((((*)))**"));
    }
}
