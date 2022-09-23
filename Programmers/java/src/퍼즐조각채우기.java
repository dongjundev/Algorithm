import java.util.*;

public class 퍼즐조각채우기 {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int solution(int[][] game_board, int[][] table) {
        int answer = -1;

        boolean[][] visitedTable = new boolean[table.length][table.length];
        boolean[][] visitedBoard = new boolean[game_board.length][game_board.length];
        List<List<Point>> boardList = new ArrayList<>();
        List<List<Point>> tableList = new ArrayList<>();

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {

                if (table[i][j] == 1 && !visitedTable[i][j]) {
                    bfs(i, j, visitedTable, table, 1, tableList);
                }

                if (game_board[i][j] == 0 && !visitedBoard[i][j]) {
                    bfs(i, j, visitedBoard, game_board, 0, boardList);
                }
            }
        }

        answer = findBlock(boardList, tableList);

        return answer;
    }

    public int findBlock(List<List<Point>> board, List<List<Point>> table) {
        int size = 0;
        int tableLen = table.size();
        int boardLen = board.size();
        boolean[] visitedBoard = new boolean[boardLen];

        for (int i = 0; i < tableLen; i++) {
            List<Point> tablePoints = table.get(i);

            for (int j = 0; j < boardLen; j++) {
                List<Point> boardPoints = board.get(j);

                if (tablePoints.size() == boardPoints.size() && !visitedBoard[j]) { //좌표 개수 같을때
                    if (isRotate(boardPoints, tablePoints)) { //회전해서 맞는지 확인
                        size += tablePoints.size();
                        visitedBoard[j] = true;
                        break;
                    }
                }
            }

        }

        return size;
    }

    public boolean isRotate(List<Point> board, List<Point> table) {
        boolean isCollect = false;

        board.sort((o1, o2) -> {
            return o1.x > o2.x ? 1 : o1.x < o2.x ? -1 : Integer.compare(o1.y, o2.y);
        });

        for (int i = 0; i < 4; i++) { //table퍼즐 0, 90, 180, 270도 회전

            table.sort((o1, o2) -> {
                return o1.x > o2.x ? 1 : o1.x < o2.x ? -1 : Integer.compare(o1.y, o2.y);
            });
            int nearZeroX = table.get(0).x;
            int nearZeroY = table.get(0).y;

            // 회전시키면서 좌표가 달라지기 때문에 다시 (0, 0)을 기준으로 블록 좌표를 변경
            for (int j = 0; j < table.size(); j++) {
                table.get(j).x -= nearZeroX;
                table.get(j).y -= nearZeroY;
            }

            boolean isCollectPoint = true;

            for (int j = 0; j < board.size(); j++) { //좌표 비교
                Point boardPoint = board.get(j);
                Point tablePoint = table.get(j);

                // 블록 좌표가 빈 공간의 좌표와 하나라도 다르면 중단
                if (boardPoint.x != tablePoint.x || boardPoint.y != tablePoint.y) {
                    isCollectPoint = false;
                    break;
                }
            }

            if (isCollectPoint) {
                isCollect = true;
                break;
            } else { //90도 회전 : x,y -> y, -x
                for (int j = 0; j < table.size(); j++) {
                    int temp = table.get(j).x;
                    table.get(j).x = table.get(j).y;
                    table.get(j).y = -temp;
                }
            }
        }
        return isCollect;

    }


    public void bfs(int currentX, int currentY, boolean[][] visited, int[][] graph,
                    int blockOrEmpty, List<List<Point>> list) {

        Queue<Point> q = new LinkedList<>();
        visited[currentX][currentY] = true;
        q.add(new Point(currentX, currentY));
        List<Point> subList = new ArrayList<>();
        subList.add(new Point(0, 0));

        while (!q.isEmpty()) {
            Point poll = q.poll();
            int x = poll.x;
            int y = poll.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= graph.length || ny < 0 || ny >= graph.length) {
                    continue;
                }
                if (!visited[nx][ny] && graph[nx][ny] == blockOrEmpty) {

                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny));

                    // 기준이 (0, 0)이기 때문에 (nx - x, ny - y)를 리스트에 넣음
                    subList.add(new Point(nx - x, ny - y));
                }
            }
        }
        list.add(subList);
    }

    private class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
