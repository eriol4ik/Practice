package lesson02.ex01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by eriol4ik on 18/12/2016.
 */
public class LinkedListVsArrayList {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        List<Integer> linked = new LinkedList<>();


        System.out.println("Добавление элементов в конец");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            array.add((int) (Math.random() * 10_000));
        }
        long end = System.currentTimeMillis();
        long arrayTime = end - start;

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            linked.add((int) (Math.random() * 10_000));
        }
        end = System.currentTimeMillis();
        long linkedTime = end - start;

        System.out.println(arrayTime > linkedTime ? "Linked WIN" : "Array WIN"); // Elvis
        System.out.println(arrayTime);
        System.out.println(linkedTime); // LinkedList проигрывает, потому что для каждого элемента еще нужно создать объект-оболочку

        System.out.println("Добавление элементов в произвольное место");
        start = System.currentTimeMillis();
        for (int  i = 0; i < 1000; i++) {
            array.add((int)(Math.random() * 999_999), 10_000);
        }
        end = System.currentTimeMillis();
        arrayTime = end - start;

        start = System.currentTimeMillis();
        for (int  i = 0; i < 1000; i++) {
            linked.add((int)(Math.random() * 999_999), 10_000);
        }
        end = System.currentTimeMillis();
        linkedTime = end - start;

        System.out.println(arrayTime > linkedTime ? "Linked WIN" : "Array WIN"); // Elvis
        System.out.println(arrayTime);
        System.out.println(linkedTime);

        System.out.println("Удаление элементов");
        start = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++) {
            array.remove(i);
        }
//        array.remove(500_000);
        end = System.currentTimeMillis();
        arrayTime = end - start;

        start = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++) {
            linked.remove(i);
        }
//        linked.remove(500_000);
        end = System.currentTimeMillis();
        linkedTime = end - start;

        System.out.println(arrayTime > linkedTime ? "Linked WIN" : "Array WIN"); // Elvis
        System.out.println(arrayTime);
        System.out.println(linkedTime);

    }
}
