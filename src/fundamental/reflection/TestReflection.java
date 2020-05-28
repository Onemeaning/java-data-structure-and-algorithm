package fundamental.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflection {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {

        Person person = new Student(22,165,"wangminglin");
        //获取一个类：

        Class clazz = person.getClass();
        Class clazz1 = Person.class;
        Class clazz2 = Class.forName("fundamental.reflection.Person");

        Person person1 = (Person) clazz1.newInstance();

        Constructor c = clazz1.getDeclaredConstructor(int.class, double.class, String.class);
        Person person2 = (Person) c.newInstance(22, 166, "wangjun");



        Field[] fields = clazz1.getDeclaredFields();
        for (Field field : fields){

            System.out.println(field.toString());

        }


        Method[] methods = clazz1.getDeclaredMethods();

        for(Method method:methods){

            System.out.println(method.toString());
            method.invoke(person2);
        }


        person2.eat();
        person2.run();


    }

}
