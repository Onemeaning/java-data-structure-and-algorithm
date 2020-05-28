package byteDance;

import java.util.*;

public class T1 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Stack<Node> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        int size = 0,len = 0,index = 0,opt = 0;
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] line = scanner.nextLine().trim().split(" ");
            int op = Integer.parseInt(line[0]);

            switch (op){
                case 1:
                    builder.append(line[1]);
                    stack.push(new Node(2,line[1].length()+""));
                    break;

                case 2:
                    size = Integer.parseInt(line[1]);
                    len = builder.length();
                    stack.push(new Node(1,builder.toString().substring(len-size,len)));
                    builder.delete(len-size,len);
                    break;

                case 3:
                    index = Integer.parseInt(line[1]);
                    list.add(builder.toString().charAt(index-1));
                    break;
                case 4:
                    Node temp = stack.pop();
                    opt = temp.getOpt();
                    switch (opt){
                        case 1:
                            builder.append(temp.getVal());
                            break;
                        case 2:
                            size = Integer.parseInt(temp.getVal());
                            len = builder.length();
                            builder.delete(len-size,len);
                            break;
                    }
                    break;

            }

         }

        for (Character ch : list){
            System.out.println(ch);
        }


    }
}

class Node{

    int opt;
    String val;

    public Node(int opt, String val) {
        this.opt = opt;
        this.val = val;
    }

    public int getOpt() {
        return opt;
    }

    public void setOpt(int opt) {
        this.opt = opt;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}