package lesson02.ex03;

import lesson02.ex02.TreeMap;

/**
 * Created by eriol4ik on 20/12/2016.
 */
public class Test2 {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        long start = System.currentTimeMillis();
        int number = 100_000;
        for (int i = 0; i < number; i++) {
            treeMap.add((int)(Math.random() * number), Integer.toString((int)(Math.random() * 1_000_000)));
//            treeMap.add(i, Integer.toString((int)(Math.random() * 1_000_000)));
        }
        long end = System.currentTimeMillis();
        long treeMapTime = end - start;
        System.out.println(treeMapTime);
    }
}
