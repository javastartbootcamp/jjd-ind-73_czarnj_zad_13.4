package pl.javastart.task;

public class Main {

    public static void main(String[] args) {

        // tutaj możesz przeprowadzać manualne testy listy

        // lista powinna być parametryzowana (analogicznie jak java.util.ArrayList czy java.util.LinkedList)
        CustomList<String> customListOfStrings = new CustomList<>();
        CustomList<Integer> customListOfIntegers = new CustomList<>();

        customListOfStrings.add("a");
        customListOfStrings.add("b");
        customListOfStrings.add("c");
        System.out.println(customListOfStrings);
        System.out.println(customListOfStrings.get(2));
        System.out.println(customListOfStrings.size());
        customListOfStrings.add(1, "abc");
        System.out.println(customListOfStrings);
        customListOfStrings.remove(2);
        System.out.println(customListOfStrings);

        customListOfIntegers.add(1);
        customListOfIntegers.add(2);
        customListOfIntegers.add(3);
        customListOfIntegers.add(4);
        customListOfIntegers.add(5);
        System.out.println(customListOfIntegers);
        System.out.println(customListOfIntegers.get(0));
        System.out.println(customListOfIntegers.size());
        customListOfIntegers.add(5, 20);
        System.out.println(customListOfIntegers);
        customListOfIntegers.remove(0);
        System.out.println(customListOfIntegers);
    }
}
