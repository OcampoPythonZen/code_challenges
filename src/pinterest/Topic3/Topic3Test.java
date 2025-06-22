package pinterest.Topic3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Topic3Test {

    private MyQueueWithTwoStacks queue;
    Topic3 topic3;
    String s = "AnitaLavaLaTina";
    String noPalindrome = "AnaNoLavaNada";
    String noDigitsAndLetters = "@·$%";

    @BeforeEach
    void setUp() {
        queue = new MyQueueWithTwoStacks();
        topic3 = new Topic3();
    }


    @Test
    public void shouldReturnYesWhenIsBalanced() {
        Assertions.assertEquals("YES", topic3.isBalanced("{}"));
    }

    @Test
    public void shouldWhenIsNotBalancedWhenIsJustSymbolOpened() {
        Assertions.assertEquals("NO", topic3.isBalanced(")"));
    }

    @Test
    public void shouldStackEmptyWhenOrStackPop() {
        Assertions.assertEquals("NO", topic3.isBalanced("{]"));
    }

    @Test
    public void shouldReturnNoWhenStartsWithClosingSymbol() {
        Assertions.assertEquals("NO", topic3.isBalanced("]{}"));
    }

    @Test
    public void shouldIgnoreNonBracketCharacters() {
        Assertions.assertEquals("YES", topic3.isBalanced("{a[b(c)d]e}"));
    }

    @Test
    public void shouldPushAnElementWhenIsAdded() {
        queue.enqueue(100);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        Assertions.assertEquals(4, queue.stackIn.size());
        Assertions.assertEquals(100, queue.peek());
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        Assertions.assertEquals(0, queue.stackIn.size());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        Assertions.assertEquals(3, queue.stackIn.size());
        Assertions.assertEquals(1, queue.peek());
    }

    @Test
    public void shouldReturnTrueWhenIsDequeDataType() {
        Assertions.assertEquals(true, topic3.isPalindromeWithADeque(s));
    }

    @Test
    public void shouldReturnTrueWhenIsStream() {
        Assertions.assertEquals(true, topic3.isPalindromeWithAStream(s));
    }

    @Test
    public void shouldReturnTrueWhenIsStringBuilder() {
        Assertions.assertEquals(true, topic3.isPalindromeWithStringBuilder(s));
    }

    @Test
    public void shouldReturnFalseWhenIsDequeDataType() {
        Assertions.assertEquals(false, topic3.isPalindromeWithADeque(noPalindrome));
    }

    @Test
    public void shouldReturnFalseWhenIsStream() {
        Assertions.assertEquals(false, topic3.isPalindromeWithAStream(noPalindrome));
    }

    @Test
    public void shouldReturnFalseWhenIsStringBuilder() {
        Assertions.assertEquals(false, topic3.isPalindromeWithStringBuilder(noPalindrome));
    }

    @Test
    public void shouldReturnFalseWhenIsNotLettersAndDigits() {
        Assertions.assertEquals(false, topic3.isPalindromeWithStringBuilder(noDigitsAndLetters));
    }


}
