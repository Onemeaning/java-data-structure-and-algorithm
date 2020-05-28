package data.structures.recursion;

/**
 * 迷宫回溯问题，(给定一个二维数组代表的迷宫，目标是找到一个合适的路径达到目的地)
 *
 */
public class MazeBack {

    public static void main(String[] args){

        //创建一个十行十列的迷宫，
        int[][] maze = new int[10][10];


        /**
         * 为迷宫设置相应的障碍，1：表示一堵墙
         */
        for (int i = 0; i < 10; i++) {

            maze[0][i] = 1;
            maze[9][i] = 1;
        }

        for (int i = 0; i < 10; i++) {

            maze[i][0] = 1;
            maze[i][9] = 1;
        }

        maze[5][1] = 1;
        maze[5][2] = 1;
        maze[5][3] = 1;
        maze[5][4] = 1;
        maze[4][4] = 1;
        maze[3][4] = 1;

        System.out.println("初始情况下的地图");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(maze[i][j] +" ");
            }
            System.out.println();
        }


        setWay(maze,1,1);


        System.out.println("回溯后的地图");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(maze[i][j] +" ");
            }
            System.out.println();
        }


    }


    /**
     * 寻准一个条到达目的地的路线；
     * 地图中的一些约定：
     * 0：表示还未走过的路径；
     * 1：表示阻挡物体，也就是墙；
     * 2：表示寻找到的路径；
     * 3：表示一条死路；
     * @param maze 地图
     * @param i 行坐标
     * @param j 列坐标
     * @return
     */
    public static boolean setWay(int[][] maze, int i, int j){

        if (maze[8][8] == 2){//找打目的地直接返回了；
            return true;
        }

        if (maze[i][j] == 0){

            maze[i][j] = 2;//假定该路径是我们的寻求路径；

            //按照 下 -> 右 -> 上 -> 左的顺序进行探测；
            if (setWay(maze,i+1,j)){
                return true;
            }
            else if (setWay(maze,i,j+1)){
                return true;
            }
            else if (setWay(maze,i-1,j)){
                return true;
            }
            else if (setWay(maze,i,j-1)){
                return true;
            }
            else{
                //往四个方向都没能找到合适的路径，说明这是一条死路；
                maze[i][j] = 3;
                return false;
            }
        }
        else { // maze[i][j] 可能取值为，1,2,3，无论是哪一种情况都不会再找下去了；
            return  false;
        }

    }


}
