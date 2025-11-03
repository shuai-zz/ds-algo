package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] array = new int[length];
        int[] preSum = new int[length];
        int p=0;
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
            p+=array[i];
            preSum[i]=p;
        }

        while(scanner.hasNext()){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int sum=0;
            if(a==0){
                sum=preSum[b];
            }else{
                sum=preSum[b]-preSum[a-1];
            }
            System.out.println(sum);
        }
        scanner.close();




    }
}
