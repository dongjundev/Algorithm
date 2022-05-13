import java.util.ArrayList;
import java.util.List;

public class 행렬테두리회전하기 {

    private static int[][] arr;
    private static List<Integer> answer = new ArrayList<>();

    public static List<Integer> solution(int rows, int columns, int[][] queries) {

        arr = new int[rows][columns];
        int cnt = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = ++cnt;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            cal(queries[i]);
        }

        System.out.println(answer.toString());
        return answer;
    }

    static private void cal(int[] one) {
        int ax = one[0] - 1;
        int ay = one[1] - 1;
        int bx = one[2] - 1;
        int by = one[3] - 1;
        int MIN = 10000;

        int tmp = arr[ax][by];

        for (int i = 0; i < by - ay; i++) {
            arr[ax][by - i] = arr[ax][by - i - 1];
            MIN = Math.min(MIN, arr[ax][by - i]);
        }

        for (int i = 0; i < bx - ax; i++) {
            arr[ax + i][ay] = arr[ax + i + 1][ay];
            MIN = Math.min(MIN, arr[ax + i][ay]);
        }

        for (int i = 0; i < by - ay; i++) {
            arr[bx][ay + i] = arr[bx][ay + i + 1];
            MIN = Math.min(MIN, arr[bx][ay + i]);
        }

        for (int i = 0; i < bx - ax; i++) {
            arr[bx - i][by] = arr[bx - i - 1][by];
            MIN = Math.min(MIN, arr[bx - i][by]);
        }

//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.print(arr[i][j] +" ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        arr[ax + 1][by] = tmp;
        MIN = Math.min(MIN, tmp);

        answer.add(MIN);
    }

    public static void main(String[] args) {
        solution(3, 3, new int[][]{{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2,2,3,3}});
    }
}
