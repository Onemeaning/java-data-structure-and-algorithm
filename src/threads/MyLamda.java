package threads;

public class MyLamda {

    public static void main(String[] args){

        new Thread(() -> {System.out.println("i am a lambda expression");
        System.out.println("ok ");}).run();
    }
}
