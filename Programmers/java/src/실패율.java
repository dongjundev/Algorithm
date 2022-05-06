import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 실패율 {
    public static int[] solution(int N, int[] stages) {

        int[] answer = new int[N];
        double[] stageCheck = new double[N + 1];
        List<Double> fail = new ArrayList<>(N);

        for (int stage : stages) {

            //마지막 클래스를 클리어한 것은 제외
            if (stage == N + 1)
                continue;

            stageCheck[stage]++;
        }

        double num = stages.length;    //사람 수

        for (int i = 1; i < stageCheck.length; i++) {

            if (num == 0) {
                fail.add(0.0);
                continue;
            }

            fail.add(stageCheck[i] / num);
            num -= stageCheck[i];
        }

        List<Double> tempFail = new ArrayList<>(fail);
        Collections.sort(tempFail, Collections.reverseOrder());
//        System.out.println(tempFail.toString());
//        System.out.println(fail.toString());

        for (int i = 0; i < tempFail.size(); i++) {
            int index = fail.indexOf(tempFail.get(i));
            answer[i] = index +1;
            fail.set(index, -1.0);
        }

        return answer;
    }

//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
//    }
}
