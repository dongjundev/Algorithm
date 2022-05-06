package baekjoon_package;
import java.util.*;

public class Test1012 {
	private static int dx[] = {0,0,1,-1};		// 상하좌우
    private static int dy[] = {1,-1,0,0};			
    private static int M,N,K;
    private static int map[][];
    private static boolean visit[][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-->0) {
			int count=0;
			
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			
			map = new int[M][N];
			visit = new boolean[M][N];
			
			for(int i=0; i<K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				map[x][y] = 1;
			}
			
			for(int j=0; j<M; j++) {
				for( int k=0; k<N; k++) {
					if(map[j][k] == 1 && !visit[j][k]) {
						count++;
						dfs(j,k);
					}
				}
			}
			System.out.println(count);
		}
	}
	
	private static void dfs(int x, int y) {
		visit[x][y] = true;
		
		for(int i=0; i<4; i++){		// 상하좌우 체크
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >=0 && ny >=0 && nx < M && ny < N){		// 맵의 범위를 벗어나는지 체크
                if(map[nx][ny] == 1 && !visit[nx][ny]){		// 왼, 오, 아, 위 중에서 노방문 찾으면 dfs재귀
                    dfs(nx,ny);
                }
            }
		}
	}

}
