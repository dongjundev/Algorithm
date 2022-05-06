import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort1 {
    public static int[] solution(int[] array, int[][] commands) {
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<commands.length; i++){
            int start = commands[i][0]-1;
            int end = commands[i][1];
            int position = commands[i][2]-1;

            int[] newArray = Arrays.copyOfRange(array, start, end);
            Arrays.sort(newArray);

            int answerOne = newArray[position];
            list.add(i, answerOne);
        }
        int[] answer = new int[list.size()];
        int size=0;
        for(Integer in:list){
            answer[size++]=in;
        }

        return answer;
    }
}
