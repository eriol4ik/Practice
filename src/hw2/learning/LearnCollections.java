package hw2.learning;

import java.util.*;

/**
 * Created by eriol4ik on 12/01/2017.
 */
public class LearnCollections {
    public static void main(String[] args) {
//        addElems();

        Queue<Integer> queue = new PriorityQueue<>(10);
        queue.add(17);
        queue.add(775);
        queue.add(103);
        queue.add(123);
        queue.add(3235);
        queue.add(253);
        queue.add(65);
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        System.out.println(queue);
    }

    private static void addElems() {
        Set<Integer> set = new TreeSet<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            set.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        List<Integer> list = new LinkedList<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);

        List<Integer> alist = new ArrayList<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            alist.add(i);
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);

        Queue<Integer> queue = new PriorityQueue<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            queue.add(i);
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}