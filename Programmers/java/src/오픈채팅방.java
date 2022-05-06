import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 오픈채팅방 {

    static HashMap<String, String> map = new HashMap();
    static List<String> answerList = new ArrayList();
    static String[] answer;
    static StringBuilder sb = new StringBuilder();

    static public String[] solution(String[] record) {

        for (String str : record) {
//            System.out.println("str = " + str);
            String[] parsingStr = str.split(" ");
            if(parsingStr[0].equals("Leave"))
                continue;
            map.put(parsingStr[1], parsingStr[2]);
        }

        for (String str : record) {
            String[] parsingStr = str.split(" ");
            if (!parsingStr[0].equals("Change")) {
                if (parsingStr[0].equals("Enter"))
                    answerList.add(map.get(parsingStr[1]) + "님이" + " 들어왔습니다.");
                else if (parsingStr[0].equals("Leave"))
                    answerList.add(map.get(parsingStr[1]) + "님이" + " 나갔습니다.");
            }
        }

        answer = answerList.toArray(new String[answerList.size()]);

        return answer;
    }

    public static void main(String[] args) {
        String[] answer = solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
        System.out.println(Arrays.toString(answer));
    }
}
