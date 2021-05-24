package baekjoon_package;
import java.util.*;

public class Test2667 {
	private static int dx[] = {0,0,1,-1};		// 상하좌우
    private static int dy[] = {1,-1,0,0};			
    private static int[] aparts = new int[25*25];		
    private static int n;		// 지도의 크기
    private static int apartNum = 0; //아파트 단지 번호의 수
    private static boolean[][] visited = new boolean[25][25]; //방문여부
    private static int[][] map = new int[25][25]; //지도

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        map = new int[n][n];
        visited = new boolean[n][n];

        //전체 사각형 입력 받기
        for(int i=0; i<n; i++){
            String input = sc.next();
            for(int j=0; j<n; j++){
            	
//            	문자'3'을 숫자 3로 바꾸는 방법은 문자'3'에서 문자'0'을
//            	빼주는 것이다. 알파벳이나 숫자는 문자코드가 연속적으로 할당되었기 때문에 이런 방법
//            	이 가능하다.

                map[i][j] = input.charAt(j)-'0';	
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    apartNum++;		//단지수 올리기
                    dfs(i,j);
                }
            }
        }

        Arrays.sort(aparts);	//오름차순
        System.out.println(apartNum);

        for(int i=0; i<aparts.length; i++){
            if(aparts[i] == 0){
            }else{               
                System.out.println(aparts[i]);
            }
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        aparts[apartNum]++;

        for(int i=0; i<4; i++){		// 상하좌우 체크
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >=0 && ny >=0 && nx < n && ny < n){		// 맵의 범위를 벗어나는지 체크
                if(map[nx][ny] == 1 && !visited[nx][ny]){		// 왼, 오, 아, 위 중에서 노방문 찾으면 dfs재귀
                    dfs(nx,ny);
                }
            }
        }
    }

}
