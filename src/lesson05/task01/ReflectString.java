package lesson05.task01;

import lesson05.task02.ReflectObject;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * Created by eriol4ik on 14/01/2017.
 */
public class ReflectString {
    public static void main(String[] args) {
        Class stringClass = String.class;
        Method[] methods = stringClass.getDeclaredMethods();

        ReflectObject.printInfo(stringClass);
    }

}