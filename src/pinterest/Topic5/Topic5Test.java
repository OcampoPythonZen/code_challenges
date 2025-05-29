package pinterest.Topic5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Topic5Test {

    Topic5 topic5 = new Topic5();

    @Test
    public void shouldExecuteInsert() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 4, 3, 5, 6, 2));
        int n = 6;
        topic5.insertionSort(n, arr);
    }

    @Test
    public void shouldSortWhenIsCalled() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(5, 8, 1, 3, 7, 9, 2));
        topic5.quickSort(arr);
    }


}
