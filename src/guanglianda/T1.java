package guanglianda;


public class T1 {
    public static void main(String[] args){

        int[] b = new int[]{1,3,9,5,4,7,6,8,2,10};
        int length = b.length;
        sort(b,length);

        for (int i = 0; i < length; i++) {
            System.out.print(b[i] + " " );
        }


    }

    public static void sort(int[] a, int length) {

        int i, j, temp;
        for (i = 0; i <= length - 1; i++) {

            for (j = 0; j <= length - 1 - i; j++) {


                if (a[j] < a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }

            }

        }
    }

}
