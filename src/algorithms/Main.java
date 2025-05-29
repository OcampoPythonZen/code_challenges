package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static HackerRank hackerRank = new HackerRank();


    public static void main(String[] args) {
        executeMergeLinkedLists();
    }

    public static void executeMergeLinkedLists() {
        LinkedListNode head1 = new LinkedListNode(10);
        head1.next = new LinkedListNode(30);
        head1.next.next = new LinkedListNode(50);

        LinkedListNode head2 = new LinkedListNode(20);
        head2.next = new LinkedListNode(40);
        head2.next.next = new LinkedListNode(60);

        LinkedListNode merged = hackerRank.mergeLists(head1, head2);
        printList(merged);
    }

    static void printList(LinkedListNode head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) System.out.print(" -→ ");
            head = head.next;
        }
        System.out.println();
    }

    public static void executeMinimumBribes() {
        List<Integer> q = new ArrayList<>();
        q.add(2);
        q.add(1);
        q.add(5);
        q.add(3);
        q.add(4);
        hackerRank.minimumBribes(q);
    }

    public static void executeGridChallenge() {
        List<String> grid = new ArrayList<>();
        grid.add("ebacd");
        grid.add("fghij");
        grid.add("olmkn");
        grid.add("trpqs");
        grid.add("xywuv");
        System.out.println(hackerRank.gridChallenge(grid));
    }

    public static void executesuperDigit() {
        String s = "9875";
        int k = 4;
        System.out.println(hackerRank.superDigit(s, k));
    }

    public static void executeCaesarCipher() {
        String s = "middle-Outz";
        int k = 2;
        System.out.println(hackerRank.caesarCipher(s, k));
    }

    public static void executeCountingSort() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(63, 25, 73, 1, 98, 73, 56, 84, 86, 57, 16, 83, 8, 25, 81, 56,
                9, 53, 98, 67, 99, 12, 83, 89, 80, 91, 39, 86, 76, 85, 74, 39, 25, 90, 59, 10, 94, 32, 44, 3, 89, 30,
                27, 79, 46, 96, 27, 32, 18, 21, 92, 69, 81, 40, 40, 34, 68, 78, 24, 87, 42, 69, 23, 41, 78, 22, 6, 90,
                99, 89, 50, 30, 20, 1, 43, 3, 70, 95, 33, 46, 44, 9, 69, 48, 33, 60, 65, 16, 82, 67, 61, 32, 21, 79,
                75, 75, 13, 87, 70, 33));
        System.out.println(hackerRank.countingSort(arr));
    }

    public static void executeFlippingMatrix() {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(112, 42, 83, 119));
        matrix.add(Arrays.asList(56, 125, 56, 49));
        matrix.add(Arrays.asList(15, 78, 101, 43));
        matrix.add(Arrays.asList(62, 98, 114, 108));

        System.out.println(hackerRank.flippingTheMatrixOptimized(matrix));
    }

}