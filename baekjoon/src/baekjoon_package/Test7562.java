package baekjoon_package;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test7562 {

    private static int[][] arr;
    private static boolean[][] visited;
    private static int dx[] = {1,2,2,1,-1,-2,-2,-1};
    private static int dy[] = {-2,-1,1,2,-2,-1,1,2};
    private static int t,n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            arr = new int[n][n];
            visited = new boolean[n][n];
            int startX = sc.nextInt();
            int startY = sc.nextInt();
            Position startPosition = new Position(startX, startY);
            int endX = sc.nextInt();
            int endY = sc.nextInt();
            Position endPosition = new Position(endX, endY);

            bfs(startPosition, endPosition);
            System.out.println(arr[endPosition.X][endPosition.Y]);
        }
    }

    private static void bfs(Position startPosition, Position endPosition) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(startPosition);
        visited[startPosition.X][startPosition.Y] = true;
        arr[startPosition.X][startPosition.Y] = 0;

        while (!queue.isEmpty()) {
            Position poll = queue.poll();

            if (poll.X == endPosition.X && poll.Y == endPosition.Y) {
                break;
            }

            for (int i = 0; i < 8; i++) {
                int nextX = poll.X + dx[i];
                int nextY = poll.Y + dy[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && visited[nextX][nextY] == false) {
                    visited[nextX][nextY] = true;
                    arr[nextX][nextY] = arr[poll.X][poll.Y] + 1;
                    queue.offer(new Position(nextX, nextY));
                }
            }
        }


    }
}

class Position {
    int X;
    int Y;

    public Position(int x, int y) {
        X = x;
        Y = y;
    }
}
