package data.structures.array;

import java.io.*;

/**
 * 稀疏数组案例，实现数组数据的压缩功能；
 * 案例：五子棋的棋盘存档
 */
public class SparseArray {

    public static void main(String[] args){

        //先创建一个原始的二维数组11*11
        int[][] chessArr = new int[11][11];

        chessArr[1][2] = 1;//1表示的是白棋子
        chessArr[2][3] = 2;//2表示的是黑棋子

        //遍历并输出二维数组
        System.out.println("------------原始数组-------------");
        for(int[] chessArr1 :chessArr){

            for (int chess : chessArr1){

                System.out.print(chess + " ");
            }

            System.out.println();
        }


        //原始数组转换成稀疏数组

        int sum = 0;
        for (int i = 0; i < chessArr.length; i++) {

            for (int j = 0; j < chessArr.length; j++) {

                if (chessArr[i][j] != 0){
                    sum++;

                }
            }
        }

        //创建原始稀疏数组
        int[][] sparseArr = new int[sum+1][3];

        sparseArr[0][0] = chessArr.length;
        sparseArr[0][1] = chessArr.length;
        sparseArr[0][2] = sum;

        //重置sum值作为稀疏数组的行索引
        sum = 1;
        for (int i = 0; i < chessArr.length; i++) {

            for (int j = 0; j < chessArr.length; j++) {

                if (chessArr[i][j] != 0){

                    sparseArr[sum][0] = i;
                    sparseArr[sum][1] = j;
                    sparseArr[sum][2] = chessArr[i][j];
                    sum++;

                }
            }
        }


        //遍历并打印稀疏数组
        System.out.println("------------稀疏数组-------------");
        for (int[] array :sparseArr){

            for (int data : array){

                System.out.print( data +" ");
            }
            System.out.println();

        }

        //将稀疏数组保存到文件当中去
        String path = System.getProperty("user.dir") + "\\sparseArray.data";
        File file = new File(path);
        try {
            FileWriter writer = new FileWriter(file);

            for (int[] array :sparseArr){

                for (int data : array){

                    writer.write(data + " ");
                }

                writer.write("\r\n");
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }



        //从文件中读取稀疏数组

        int[][] newArray = null;

        int val = 0 ;
        int row = 0;
        int col = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "";
            int rowIndex = 0;
            while ((line = reader.readLine()) != null){

                String[] temp = line.trim().split(" ");
                row = Integer.parseInt(temp[0]);
                col = Integer.parseInt(temp[1]);
                val = Integer.parseInt(temp[2]);
                if (rowIndex == 0){

                    newArray = new int[row][col];
                    rowIndex++ ;

                }else {
                    if (newArray ==null){
                        break;
                    }
                   newArray[row][col] = val;
                }
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        //遍历并输出二维数组
        System.out.println("=============恢复数组===========");

        if (newArray!= null){
            for(int[] chessArr1 :newArray){

                for (int chess : chessArr1){

                    System.out.print(chess + " ");
                }

                System.out.println();
            }
        }


    }
}
