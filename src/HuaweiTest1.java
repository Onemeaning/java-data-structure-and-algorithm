import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 华为笔试第一题：
 * 现在有很多整数数组，需要将它合并为一个整数组数。合并规则：从每个数组中按顺序取出固定长度的内容合并
 * 到新的数组中，取完的内容会删除掉，如果该行不足固定长度或者为空，则直接取出剩余部分的内容放置到新的数组中，
 * 继续下一行。如样例1：获得长度3，先遍历第一行，获得2,5,6；再遍历第二行，获得1,7,4；再循环到第一行，获得
 * 7,9,5；再遍历第二行获得3,4；再回到第一行得到7；按顺序拼接成最终结果。
 *
 * 输入描述：
 * 第一行是每次读取的固定长度，长度 > 0;
 * 第2-n行是需要合并的数组，不同的数组用回车换行符分隔，数组内部用逗号分隔,(本次采用输入行内容为空作为结束输入的标志)
 *
 * 输出描述：
 * 输出一个新的数组用逗号分隔
 *
 * 样例1：
 * 输入
 * 3
 * 2,5,6,7,9,5,7
 * 1,7,4,3,4
 *
 * 输出：
 * 2,5,6,1,7,4,7,9,5,4,5,7
 *
 */

public class HuaweiTest1 {

    public static void main(String[] args)
    {

        Scanner scan= new Scanner(System.in);
        int length =  Integer.parseInt(scan.nextLine());
//        System.out.println(length);
        List<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        String s = null;
        while(!(s = scan.nextLine()).equals(""))
        {
            String[] ss = s.split(",");
//            System.out.println(Arrays.toString(ss));
            ArrayList<String> ll = new ArrayList<>();
            for(int i = 0;i< ss.length;i++)
            {
                ll.add(ss[i]);
            }
            list.add(ll);

        }

        StringBuilder builder = new StringBuilder();
        int myLength = length;


        while (list.size()>0)
        {
            int i = 0;
            if(list.get(i).size()<length)
            {
                myLength = list.get(i).size();
            }
            else
            {
                myLength =length;
            }

            for(int j = 0;j<myLength;j++)
            {
                builder.append(list.get(i).get(0)+",");
                list.get(i).remove(0);
            }

            if(list.get(i).size()==0)
            {
                list.remove(i);
            }
//--------------------------------------------------------------------
            if(i+1<list.size())
            {
                if(list.get(i+1).size()<length)
                {
                    myLength = list.get(i+1).size();
                }
                else
                {
                    myLength =length;
                }

                for(int j = 0;j<myLength;j++)
                {
                    builder.append(list.get(i+1).get(0)+",");
                    list.get(i+1).remove(0);
                }

                if(list.get(i+1).size()==0)
                {
                    list.remove(i+1);
                }


            }

        }
        builder.deleteCharAt(builder.length()-1);
        System.out.println(builder.toString());
    }

}
