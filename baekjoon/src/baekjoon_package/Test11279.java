package baekjoon_package;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Test11279 {
    public static void main(String[] args) {
        PriorityQueue que = new PriorityQueue(Collections.reverseOrder());
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (a == 0) {
                if (que.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(que.poll());
                }
                continue;
            }
            que.offer(a);
        }
    }
}
