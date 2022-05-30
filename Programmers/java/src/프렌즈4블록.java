public class 프렌즈4블록 {

    static int N, M;
    static char[][] map;

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        N = m;
        M = n;
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = board[i].toCharArray();
        }

        while (true) {
            boolean[][] check = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    // 빈 공간이 아닐 때 2*2 형태로 같은 블록이 붙어있는지 확인
                    if (map[i][j] != '*') {
                        checkBlock(check, i, j);
                    }
                }
            }

            // 지워진 블록 개수 확인 + 빈 공간으로 블록 떨어트리기
            int newBlock = dropBlock(check);

            // 더 이상 지워지는 블록 없으면 반복문 탈출
            if (newBlock == 0)
                break;

            answer += newBlock;
        }

        return answer;
    }

    void checkBlock(boolean[][] check, int x, int y) {
        int[] dx = {0, 0, 1, 1}, dy = {0, 1, 0, 1};
        boolean flag = true;

        // 2*2칸이 모두 같은 값인지 확인
        for (int i = 1; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 새로운 좌표가 범위 밖이고
            // 기준 값이랑 다르면
            if (!isIn(nx, ny) || map[nx][ny] != map[x][y]) {
                flag = false;
                break;
            }
        }

        // 지워질 수 없음
        if (!flag)
            return;

        // 조건 만족하면 지워지는 블록이라고 표시
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            check[nx][ny] = true;
        }
    }

    int dropBlock(boolean[][] check) {
        int cnt = 0;

        // 열 기준
        for (int y = 0; y < M; y++) {
            // 위에서부터 내려야하는 빈 공간 있는지 확인
            for (int x = 0; x < N; x++) {
                if (check[x][y] != true)
                    continue;

                // 블록이 지워져서 빈 부분 있으면 아래로 한칸씩 내림 : 빈 공간 채움
                cnt++;
                for (int i = x; i >= 0; i--) {
                    // 마지막 맨 위칸은 빈 공간으로 초기화
                    if (i == 0) {
                        map[i][y] = '*';
                    } else {
                        // 빈 공간부터 위에 있는 블록 아래로 내려서 채움
                        map[i][y] = map[i - 1][y];
                    }
                }
            }
        }

        return cnt;
    }

    boolean isIn(int x, int y) {
        if (0 <= x && x < N && 0 <= y && y < M)
            return true;
        return false;
    }

}
