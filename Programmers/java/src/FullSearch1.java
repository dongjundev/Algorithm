import java.util.*;

public class FullSearch1 {
    public static int[] solution(int[] answers) {
        int[][] spzAnswer = {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };
        int[] score = {0, 0, 0};
        int[] copyScore = {};
        int max = 0;
        List<Integer> list = new ArrayList();

        for(int i=0; i<answers.length; i++){
            if(spzAnswer[0][i%5]==answers[i])
                score[0]++;
            if(spzAnswer[1][i%8]==answers[i])
                score[1]++;
            if(spzAnswer[2][i%10]==answers[i])
                score[2]++;
        }

        copyScore = score.clone();
        Arrays.sort(copyScore);

        max = copyScore[2];

        for(int i=0; i< score.length; i++){
            if(max == score[i])
                list.add(i+1);
        }

        int[] answer = new int[list.size()];

        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.printf(Arrays.toString(solution(new int[] {1,2,3,4,5})));
    }
}