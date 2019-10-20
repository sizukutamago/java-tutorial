package app;

import app.sub.*;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws Exception {
        Point point1 = new Point(3, 2);
        Point point2 = new Point(3, 2);

        System.out.println(point1);
        System.out.println(point2);

        System.out.println(point1.hashCode());
        System.out.println(point2.hashCode());

        System.out.println(point1.equals(point2));

        System.out.println("--------");

        Task task = new Task(TaskType.PRIVATE, "buy milk");
        TaskType type = task.getType();

        System.out.println(TaskType.PRIVATE.equals(type));

        switch (type) {
            case PRIVATE:
                System.out.println("Task[type = " + type + "]");
                break;

            case WORK:
                System.out.println("Task[type = " + type + "]");
                break;
        }

        System.out.println("--------");

        HttpStatus hs = HttpStatus.OK;
        System.out.println("HttpStatus = " + hs + "[" + hs.getValue() + "]");

        System.out.println("--------");

        List<String> list = new ArrayList<>();
        list.add("Java");
        // list.add(true);
        String element = list.get(0);
        System.out.println(element);

        System.out.println("--------");

        GenericStack<String> genStack = new GenericStack<>();

        genStack.push("Scala");
        genStack.push("Groovy");
        genStack.push("Java");

        String genElement = genStack.pop();

        if (genElement != null) {
            System.out.println(genElement);
        }

        GenericStack<Integer> genStack2 = new GenericStack<>();

        genStack2.push(100);
        genStack2.push(200);

        Integer genElement2 = genStack2.pop();

        if (genElement2 != null) {
            System.out.println(genElement2);
        }

        System.out.println("--------");

        System.out.println(fibonacci(10));

        System.out.println("--------");

        Student[] students = {
                new Student("Ken", 100),
                new Student("Shin", 60),
                new Student("Takuya", 80)
        };

        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o2.getScore(), o1.getScore());
            }
        };

        Arrays.sort(students, comparator);

        for (Student student : students) {
            System.out.println(student.getName() + " : " + student.getScore());
        }

        System.out.println("--------");

        Comparator<Student> nameComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        Arrays.sort(students, nameComparator);

        for (Student student : students) {
            System.out.println(student.getName() + " : " + student.getScore());
        }

        System.out.println("--------");

        Arrays.sort(students);
        for (Student student : students) {
            System.out.println(student.getName() + " : " + student.getScore());
        }

        System.out.println("--------");

        int[] array = {1, 1, 4, 5, 7, 8, 11, 12,17, 21, 24};
        int found = Arrays.binarySearch(array, 5);
        System.out.println(found);

        int notFound = Arrays.binarySearch(array, 6);
        System.out.println(notFound);

        System.out.println("--------");

        List<Student> studentArray = new ArrayList<>();
        studentArray.add(new Student("Ken", 100));
        studentArray.add(new Student("Shin", 60));
        studentArray.add(new Student("Takuya", 80));

        System.out.println(studentArray);

        studentArray.stream()
                .filter(student -> student.getScore() >= 70)
                .forEach(student -> System.out.println(student.getName()));

        Collections.sort(studentArray, (student1, student2) ->
                Integer.compare(student1.getScore(), student2.getScore())
        );

        System.out.println(studentArray);

        System.out.println("--------");

        List<String> stringList = Arrays.asList("Xxx", "Yyy", "Zzz");
        stringList.forEach(System.out::println);

        System.out.println("--------");

        /*for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }*/

        IntStream.range(0, 5).forEach(System.out::println);

        System.out.println("--------");

        Stream<Integer> stream = studentArray.stream()
                .map(Student::getScore);
        stream.forEach(System.out::println);

        System.out.println("--------");

        OptionalStack<String> optionalStack = new OptionalStack<>();
        Optional<String> optional = optionalStack.pop();
        String optElement = optional.orElse("empty");

        System.out.println(optElement);

        optionalStack.push("Scala");
        optionalStack.push("Groovy");
        optionalStack.push("Java");

        optional = optionalStack.pop();

        if (optional.isPresent()) {
            System.out.println(optional.get());
        }

        optional = optionalStack.pop();

        optional.ifPresent(System.out::println);

    }

    private static int fibonacci(int value) {
        if (value == 0 || value == 1) {
            return value;
        }

        return fibonacci(value - 1) + fibonacci(value - 2);
    }
}