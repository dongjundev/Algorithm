import java.io.*;

public class Hanoi {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        hanoi(N, 1, 3, 2);  // 3개의 원판을 1번타워에서 3번 타워로 옮기고 2번 타워는 서브

        bw.flush();
        bw.close();
    }

    private static void hanoi(int N, int start, int end, int sub) throws IOException {
        if(N==1) {
            bw.write(start + " -> " + end+"\n");
            return;
        }

        hanoi(N-1, start, sub, end);    // N-1 개를 목표 지점이 아닌 타워에다가 옮겨 놔야 가장 큰 원판을 옮길 수 있음
        hanoi(1, start, end, sub);      // 위에 move 메소드가 끝나면, sub에 나머지 원판이 쌓여있고, 3번 타워에는 비워있게 되어서 바로 큰 원판을 옮기면 됨.
        hanoi(N-1, sub, end, start);    // sub -> end 타워로 옮기는 호출
    }
}


