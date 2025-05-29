package pinterest.Topic3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class Topic3 {

    public String isBalanced(String s) {
        Map<Character, Character> symbols = Map.of(
                ')', '(',
                ']', '[',
                '}', '{'
        );
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (symbols.containsValue(c)) {
                stack.push(c);
            } else if (symbols.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != symbols.get(c)) {
                    return "NO";
                }
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }
}
