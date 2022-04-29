package practice;

import java.util.Stack;

public class N_20 {
    public boolean isValid(String s) {
        Stack<Character> charStack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{' )
                charStack.push(ch);
            else {
                if (charStack.empty()
                        || ch == ')' && charStack.peek() != '('
                        || ch == ']' && charStack.peek() != '['
                        || ch == '}' && charStack.peek() != '{')
                    return false;
                else charStack.pop();
            }
        }
        if(charStack.empty()) return true;
        else return false;
    }
}
