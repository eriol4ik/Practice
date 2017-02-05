package lesson05.task02;

import lesson05.ex01.User;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.*;

/**
 * Created by eriol4ik on 14/01/2017.
 */
public class ReflectObject {
    public static void main(String[] args) {
        User user = new User("login", "pass");
        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList();
        Set hashSet = new HashSet();
//        printInfo(arrayDeque);
        printCommon(linkedList, arrayList);
        printCommon(arrayList, hashSet);
    }

    public static void printInfo(Object object) {
        Class aClass = object.getClass();
        String name = aClass.getName();
        Class superClass = aClass.getSuperclass();
        Class[] interfaces = aClass.getInterfaces();
        StringBuilder sb = new StringBuilder();
        sb.append(getModifiers(aClass.getModifiers()));
        sb.append(name).append(" ");
        if (superClass != null) {
            sb.append("extends ").append(superClass.getName());
        }

        if (superClass.getSuperclass() != null) {
            sb.append(" [");
            while ((superClass = superClass.getSuperclass()) != null) {
                sb.append(" extends ").append(superClass.getName()).append(" ");
            }
            sb.append("] ");
        }

        if (interfaces.length != 0) {
            sb.append(" implements ");
            for (Class anInterface : interfaces) {
                sb.append(anInterface.getName()).append(", ");
            }
            sb.deleteCharAt(sb.length() - 2);
        }
        sb.append("{\n");
        sb.append(getFields(aClass));
        sb.append(getMethods(aClass));

        System.out.println(sb);
    }
    private static String getFields(Class aClass) {
        StringBuilder sb = new StringBuilder();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            sb.append(getModifiers(field.getModifiers()));
            sb.append(field.getType().getName());
            sb.append(" ");
            sb.append(field.getName());
            sb.append(";\n");
        }
        return sb.toString();
    }
    private static String getMethods(Class aClass) {
        Method[] methods = aClass.getDeclaredMethods();
        StringBuilder sb = new StringBuilder();
        for (Method method : methods) {
            sb.append(getModifiers(method.getModifiers()));
            sb.append(method.getReturnType().getName());
            sb.append(" ");
            sb.append(method.getName());
            sb.append("(");
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                sb.append(parameter.getType().getName());
                sb.append(" ");
                sb.append(parameter.getName());
                sb.append(", ");
            }
            if (parameters.length != 0) {
                sb.deleteCharAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(") {...};\n");
        }

        return sb.toString();
    }
    private static String getModifiers(int modifiers) {
        StringBuilder sb = new StringBuilder();
        if (Modifier.isPublic(modifiers)) {
            sb.append("public ");
        }
        if (Modifier.isPrivate(modifiers)) {
            sb.append("private ");
        }
        if (Modifier.isProtected(modifiers)) {
            sb.append("protected ");
        }
        if (Modifier.isStatic(modifiers)) {
            sb.append("static ");
        }
        if (Modifier.isFinal(modifiers)) {
            sb.append("final ");
        }
        if (Modifier.isSynchronized(modifiers)) {
            sb.append("synchronized ");
        }
        if (Modifier.isVolatile(modifiers)) {
            sb.append("volatile ");
        }
        if (Modifier.isTransient(modifiers)) {
            sb.append("transient ");
        }
        if (Modifier.isNative(modifiers)) {
            sb.append("native ");
        }
        if (Modifier.isAbstract(modifiers)) {
            sb.append("abstract ");
        }
        if (Modifier.isStrict(modifiers)) {
            sb.append("strictfp ");
        }
        return sb.toString();
    }

    private static void printCommon(Object obj1, Object obj2) {
        StringBuilder sb = new StringBuilder();

        Class class1 = obj1.getClass();
        Class class2 = obj2.getClass();

        List<Class> superClasses1 = new ArrayList<>();
        List<Class> superClasses2 = new ArrayList<>();

        Class superClass1 = class1.getSuperclass();
        Class superClass2 = class2.getSuperclass();

        while ((superClass1 = superClass1.getSuperclass()) != null) {
            superClasses1.add(superClass1);
        }
        while ((superClass2 = superClass2.getSuperclass()) != null) {
            superClasses2.add(superClass2);
        }


        sb.append("Common superclasses: ");
        for (Class aClass2 : superClasses2) {
            for (Class aClass1 : superClasses1) {
                if (aClass1.equals(aClass2)) {
                    sb.append(aClass1.getName()).append(", ");
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("\n");


        Class[] interfaces1 = class1.getInterfaces();
        Class[] interfaces2 = class2.getInterfaces();

        sb.append("Common interfaces: ");
        for (Class aClass2 : interfaces2) {
            for (Class aClass1 : interfaces1) {
                if (aClass1.equals(aClass2)) {
                    sb.append(aClass1.getName()).append(", ");
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("\n");
        System.out.println(sb);
    }
}
