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

    public static String isBalancedInverse(String s) {
        Map<Character, Character> symbols = Map.of(
                '(', ')',
                '[', ']',
                '{', '}'
        );
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (symbols.containsKey(c)) {
                stack.push(c);
            } else if (symbols.containsValue(c)) {
                if (stack.isEmpty()) return "NO";
                char lastOpened = stack.pop();
                if (symbols.get(lastOpened) != c) return "NO";
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

    public boolean isPalindromeWithADeque(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                deque.addLast(Character.toLowerCase(c));
            }
        }
        System.out.println(deque);
        while (deque.size() > 1) {
            Character first = deque.removeFirst();
            Character last = deque.removeLast();
            System.out.println("Removing first: " + first);
            System.out.println("Removing last: " + last);
            if (!first.equals(last)) {
                return false;
            }
        }
        System.out.println("Deque content: " + deque);
        return true;
    }

    public boolean isPalindromeWithAStream(String s) {
        String filtered = s.chars()
                .filter(Character::isLetterOrDigit)
                .mapToObj(c -> Character.toLowerCase((char) c))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        String reversed = new StringBuilder(filtered).reverse().toString();
        return filtered.equals(reversed);
    }

    public boolean isPalindromeWithStringBuilder(String s) {
        StringBuilder cleaned = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }
        if (cleaned.length() == 0) return false;
        String forward = cleaned.toString();
        String reversed = cleaned.reverse().toString();
        return forward.equals(reversed);
    }

}
