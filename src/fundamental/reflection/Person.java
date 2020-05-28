package fundamental.reflection;

public class Person {

    private int age;
    private double height;
    private String name;

    public Person() {

    }

    public Person(int age, double height, String name) {
        this.age = age;
        this.height = height;
        this.name = name;
    }

    public void run(){
        System.out.println(name + age + height + "is running");
    }

    public void eat(){
        System.out.println(name + age + height + "is  eating");
    }
}
