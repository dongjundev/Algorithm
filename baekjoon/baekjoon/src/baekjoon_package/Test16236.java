package baekjoon_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test16236 {
    private static int[][] arr;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Queue<Shark> q = new LinkedList();
        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str);
            for (int j = 0; j < n; j++) {
                int k = Integer.parseInt(st.nextToken());
                arr[i][j] = k;

                if (k == 9) {
                    q.offer(new Shark(i, j, 2, 0));
                    arr[i][j] = 0;
                }
            }
        }

        while (true) {
            List<Fish> fishes = new ArrayList();
            int[][] dist = new int[n][n];
            int size = q.peek().size;
            int eat = q.peek().eat;

            while (!q.isEmpty()) {
                Shark pollShark = q.poll();
                int x = pollShark.x;
                int y = pollShark.y;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (0 > nx || nx >= n || 0 > ny || ny >= n || dist[nx][ny] != 0 || pollShark.size < arr[nx][ny]) continue;

                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new Shark(nx, ny, pollShark.size, pollShark.eat));

                    if (arr[nx][ny] > 0 && arr[nx][ny] < 7 && pollShark.size > arr[nx][ny])
                        fishes.add(new Fish(nx, ny, dist[nx][ny]));
                }
            }

            if (fishes.isEmpty()) {
                System.out.println(answer);
                return;
            }

//            fishes.sort((o1, o2) -> {
//                if (o1.dist == o2.dist) {
//                    return o1.x - o2.x;
//                } else if (o1.x == o2.x) {
//                    return o1.y - o2.y;
//                } else
//                    return o1.dist - o2.dist;
//            });

            Fish fish = fishes.get(0);
            for(int i = 1; i < fishes.size(); i++){
                if(fish.dist > fishes.get(i).dist) {
                    fish = fishes.get(i);
                }
                else if(fish.dist == fishes.get(i).dist) {
                    if(fish.x > fishes.get(i).x) fish = fishes.get(i);
                    else if(fish.x == fishes.get(i).x){
                        if(fish.y > fishes.get(i).y) fish = fishes.get(i);
                    }
                }
            }

//            Fish fish = fishes.get(0);
            answer += fish.dist;
            eat++;

            if (size == eat) {
                size++;
                eat = 0;
            }

            q.offer(new Shark(fish.x, fish.y, size, eat));
            arr[fish.x][fish.y] = 0;
        }
    }

    private static class Shark {
        int x;
        int y;
        int size;
        int eat;

        public Shark(int x, int y, int size, int eat) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.eat = eat;
        }
    }

    private static class Fish {
        int x;
        int y;
        int dist;

        public Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
