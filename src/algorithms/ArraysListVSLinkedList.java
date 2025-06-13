package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public class ArraysListVSLinkedList {

    static ArrayList<Integer> arrayList = new ArrayList<>();
    static LinkedList<Integer> linkedList = new LinkedList<>();


    public static void useOfArrayList() {
        arrayList.add(1);
        arrayList.add(3);
        Collection<Integer> collection = Arrays.asList(4, 5, 6, 7);
        arrayList.addAll(collection);
        System.out.println("First -> Optional: " + arrayList.stream().findFirst().get());
        System.out.println(arrayList);
        System.out.println("Last -> n-1: " + arrayList.get(arrayList.size() - 1));
    }


    public static void useOfLinkedList() {
        linkedList.add(1);
        linkedList.add(3);
        linkedList.addFirst(0);
        linkedList.addLast(10);
        System.out.println(linkedList);
        System.out.println("getFirst: " + linkedList.getFirst());
        System.out.println("getLast: " + linkedList.getLast());
    }

    public static void main(String[] args) {
        useOfLinkedList();
    }

}
