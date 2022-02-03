package pl.jaczewski.livecoding.generics;

import java.util.ArrayList;
import java.util.List;

/*
Task: Generify this

1)
List list = new ArrayList();
list.add("hello");
String s = (String) list.get(0);

2)
class Box {
    private Object object;

    void set(Object object) { this.object = object; }
    Object get() { return object; }
}

3)
class Pair {
    private Object first;
    private Object second;

    void set(Object o1, Object o2) {
        this.first = o1;
        this.second = o2;
    }

    Object getFirst() { return first; }
    Object getSecond() { return second; }
}
 */

class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        String s = list.get(0);
        System.out.println(s);

        var stringBox = new Box<String>();
        stringBox.set("New Box");
        System.out.println("stringBox.get() = " + stringBox.get());

        var integerBox = new Box<>();
        integerBox.set(16);
        System.out.println("integerBox.get() = " + integerBox.get());

        var stringIntegerPair = new Pair<String, Integer>();
        stringIntegerPair.set("nine", 9);
        System.out.println("stringIntegerPair.getFirst() = " + stringIntegerPair.getFirst());
        System.out.println("stringIntegerPair.getSecond() = " + stringIntegerPair.getSecond());

        var stringDoublePair = new Pair<>();
        stringDoublePair.set("price", 12.99);
        System.out.println("stringDoublePair.getFirst() = " + stringDoublePair.getFirst());
        System.out.println("stringDoublePair.getSecond() = " + stringDoublePair.getSecond());
    }
}
