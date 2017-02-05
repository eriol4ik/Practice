package lesson09.ex01;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * Created by eriol4ik on 28/01/2017.
 */
public class SyncThreadEx {
    private static Queue<Integer> queue;
    public static void main(String[] args) {
        queue = new PriorityQueue<>();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                Random random = new Random();
                try {
                    Thread.currentThread().sleep(random.nextInt(5000));
                    queue.add(random.nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
        thread.start();
    }
        static Thread thread = new Thread(() -> {
            if (!queue.isEmpty()) {
                System.out.println("Get element: " + queue.poll());
                try {
                    Thread.currentThread().sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


}
