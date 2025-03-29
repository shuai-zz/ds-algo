package org.example.algo.recursion;

public class PascalTriangle {
    private static int element(int i, int j) {
        if (j == 0 || i == j) return 1;
        return element(i - 1, j - 1) + element(i - 1, j);
    }

    public static void print(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", element(i, j));
            }
            System.out.println();
        }
    }


    /**
     * 二维数组记忆法优化
     * @param n
     */
    public static void printV2(int n) {
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", elementV2(triangle, i, j));
            }
            System.out.println();
        }
    }
    private static int elementV2(int[][] triangle, int i, int j) {
        if(triangle[i][j]>0){return triangle[i][j];}
        if (j == 0 || i == j) {
            triangle[i][j] = 1;
            return 1;
        }
        triangle[i][j] = elementV2(triangle, i - 1, j - 1) + elementV2(triangle, i - 1, j);
        return triangle[i][j];
    }


    /**
     * 一维数组记忆法优化
     * @param n
     */
    public static void printV3(int n) {
        int[] row=new int[n];
        for (int i = 0; i < n; i++) {
            createRow(row,i);
            for(int j=0;j<=i;j++){
                System.out.printf("%-4d",row[j]);
            }
            System.out.println();
        }
    }
    private static void createRow(int[] row , int i){
        if(i==0){
            row[0] = 1;
            return;
        }
        for(int j=i;j>0;j--){
            row[j]=row[j-1]+row[j];
        }
    }

}
