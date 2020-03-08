package ccf_csp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 这是一个数组排序的案例，
 * 这个数组
 */
public class ArraySort {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String buffer = "";
        Strudent[] strudents = new Strudent[N];
        int i = 0;
        while (!(buffer = scanner.nextLine()).equals("end"))
        {
            String[] data = buffer.trim().split(" ");
            Strudent strudent = new Strudent(data[0],Integer.parseInt(data[1]),Double.parseDouble(data[2]));
            strudents[i++] = strudent;
        }

        Arrays.sort(strudents);
        System.out.println(Arrays.toString(strudents));

    }

}

class Strudent implements Comparable<Strudent>{

    private String name;
    private int age;
    private double balance;

    public Strudent(String name, int age, double balance) {
        this.name = name;
        this.age = age;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Strudent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", balance=" + balance +
                '}'+"\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    @Override
    public int compareTo(Strudent o) {

        return (int) (balance-o.getBalance());

    }
}


