package pinterest.Topic1;

import java.util.List;

public class Topic1 {

    public Long veryBigSum(List<Long> ar) {
        Long sum = 0L;
        for (Long element : ar) {
            sum += element;
        }
        return sum;
    }

    public int designerPdfViewerOptimized(List<Integer> h, String word) {
        int maxHeight = 0;
        for (char c : word.toCharArray()) {
            int height = h.get(c - 'a');
            if (height > maxHeight) {
                maxHeight = height;
            }
        }
        return word.length() * maxHeight;
    }

    public List<Integer> rotateLeft(List<Integer> a, int d) {
        for (int i = 0; i < d; i++) {
            int first = a.remove(0);
            a.add(first);
        }
        return a;
    }

}
