import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Hash1 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        int i=0;
        String tmp = "";

        while(i < completion.length){
            if(!participant[i].equals(completion[i])){
                tmp = participant[i];
                break;
            }
            else{
                i++;
            }
        }

        if(!tmp.equals("")){
            answer = tmp;
        }else
            answer = participant[participant.length-1];

        return answer;
    }



    public static String solution2(String[] participant, String[] completion) {

        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        // participant 배열의 모든 값을 해시 맵에 넣어줌
        for (String part : participant) {

            // key = 문자열, value = 현재 맵에 저장된 문자열 갯수에 + 1
            map.put(part, map.getOrDefault(part, 0) + 1);
        }

        // completion 배열의 모든 값을 해시 맵에 넣어줌
        for (String comp : completion) {

            // 같은 문자열을 찾아 value의 값을 -1해줌
            map.put(comp, map.get(comp) - 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                answer = entry.getKey();
                break;
            }
        }
        return answer;
    }
}
