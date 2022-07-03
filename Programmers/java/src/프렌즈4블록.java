import java.util.ArrayList;
import java.util.List;

public class 프렌즈4블록 {

    char[][] map;
    int answer = 0;

    public int solution(int m, int n, String[] board) {
        map = new char[m][n];

        for (int i = 0; i < m; i++) {
            String str = board[i];
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        while (update(m, n));

        return answer;
    }

    boolean update(int m, int n) {
        int cnt = 0;
        boolean c[][] = new boolean[m][n];

        //체크
        for (int i = 0; i < m-1; i++) {
            for (int j = 0; j < n-1; j++) {
                if (map[i][j] == '0') continue;

                if (check(i, j)) {
                    c[i][j] = true;
                    c[i][j+1] = true;
                    c[i+1][j] = true;
                    c[i+1][j+1] = true;
                }
            }
        }

        //갱신
        for (int j = 0; j < n; j++) {
            List<Character> tmpList = new ArrayList<>();

            //삭제될 블록을 제외하고 살 블록을 리스트에 담아준다. 첫 열, 마지막 행부터 시작.
            for (int i = m - 1; i >= 0; i--) {
                if (c[i][j] == true) {  //삭제될 블록
                    cnt++;
                    continue;
                }
                tmpList.add(map[i][j]); //살 블록
            }

            //살 블록이 담긴 리스트에서 블록을 깨네 하나씩 채워준다. 리스트가 빈 순간부터는 '0' 삽입.
            for (int i = m - 1, k = 0; i >= 0; i--, k++) {
                if (tmpList.size() > k) {
                    map[i][j] = tmpList.get(k);
                    continue;
                }

                map[i][j] = '0';
            }
        }

        answer += cnt;
        return cnt > 0 ? true : false;
    }

    boolean check(int x, int y) {
        char ch = map[x][y];

        if (ch == map[x][y + 1] && ch == map[x + 1][y] && ch == map[x + 1][y + 1]) {
            return true;
        }

        return false;
    }
}
