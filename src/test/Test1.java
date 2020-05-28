package test;


/**
 *  对于 基本数据类型int来说,会在方法区的运行时常量，
 */
public class Test1 {

    public static void main(String[] args){

        int a = 5;
        int b = 5;
        System.out.println("a == b ?"+ (a == b)); // true

        Integer a1 = 5;
        Integer b1 = 5;

        System.out.println("a1 == b1" +(a1 == b1)); // true

        Integer a2 = new Integer(5);
        Integer b2 = new Integer(5);

        System.out.println("a2 == b2" +(a2 == b2)); // false

    }

}
