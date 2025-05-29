package pinterest.Topic1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Topic1Test {

    Topic1 topic1 = new Topic1();

    @Test
    public void veryBigSumTestValid() {
        List<Long> ar = new ArrayList<>(Arrays.asList(1000000001L, 1000000002L, 1000000003L, 1000000004L, 1000000005L));
        Assertions.assertEquals(5000000015L, topic1.veryBigSum(ar));
    }

    // Primitive type is 0 - Java used autoboxing to convert zero int => to long 0L
    @Test
    public void validatedAutoBoxingOfValueExpected() {
        List<Long> ar = new ArrayList<>();
        Assertions.assertEquals(0, topic1.veryBigSum(ar));
    }

    @Test
    public void validatingALongResult() {
        List<Long> ar = new ArrayList<>();
        Assertions.assertEquals(0L, topic1.veryBigSum(ar));
    }

    @Test
    public void shouldValidateResultWhenIsDone() {
        List<Integer> h = new ArrayList<>(Arrays.asList(1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7));
        Assertions.assertEquals(28, topic1.designerPdfViewerOptimized(h, "zaba"));
    }

    @Test
    public void shouldOkWhenPassOtherWordAndList() {
        List<Integer> h = new ArrayList<>(Arrays.asList(1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5));
        Assertions.assertEquals(9, topic1.designerPdfViewerOptimized(h, "abc"));
    }

    @Test
    public void shouldValidateRotLEftWhenIsOk() {
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int d = 4;
        Assertions.assertEquals(new ArrayList<>(Arrays.asList(5, 1, 2, 3, 4)), topic1.rotLeft(a, d));
    }


}