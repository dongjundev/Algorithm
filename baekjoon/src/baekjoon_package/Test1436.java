package baekjoon_package;

import java.util.Scanner;

public class Test1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 1;
        int title = 666;

        while(count != N){
            title++;
            if(String.valueOf(title).contains("666"))
                count++;
        }

        System.out.println(title);
    }
}
