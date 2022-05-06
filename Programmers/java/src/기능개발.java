import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 기능개발 {
    public static int[] solution(int[] progresses, int[] speeds) {

        int[] dayArr = new int[100];
        int day = 0;
        List<Integer> tempList = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            while (progresses[i] + speeds[i] * day < 100) {
                day++;
            }
            dayArr[day]++;
        }

        for (int temp : dayArr) {
            if (temp != 0) tempList.add(temp);
        }

        int[] answer = Arrays.stream(dayArr).filter(i -> i != 0).toArray();
//        int[] answer = new int[tempList.size()];
//
//        for (int temp : tempList) {
//            answer[cnt++] = temp;
//        }

//        System.out.println("answer[0] = " + answer[0]);

        return answer;
    }

    public static void main(String[] args) {
        solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
    }
}
