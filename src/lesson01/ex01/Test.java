package lesson01.ex01;

/**
 * Created by eriol4ik on 17/12/2016.
 */

public class Test {
    public static void main(String[] args) {
//        ConsoleReader test = new ConsoleReader();
//        System.out.println(test.equals(test)); // переопределяем для сравнения объектов по содержимому
//        System.out.println(test.hashCode()); // числовое представление содержимого объекта в определенный моммент времени
//        System.out.println("sss".hashCode());

        User user1 = new User("test1", "test1", 2016);
        User user2 = new User("test1", "test1", 2016);
        User user3 = new User("test2", "test2", 2015);
        User user4 = new User("test2", "test2", 2016);

//        System.out.println(user1.equals(user2));
//        System.out.println(user2.equals(user1));
//        System.out.println(user1.equals(user3));
//        System.out.println(user1.equals(user4));
//        System.out.println(user4.equals(user1));
//        System.out.println(user1.equals(user1));

        System.out.println(user1.equals(user4));
        System.out.println(user3.hashCode());
        System.out.println(user4.hashCode());
        System.out.println(user3.hashCode() == user4.hashCode());
    }
}