import java.util.HashMap;
import java.util.regex.Pattern;

public class 뉴스클러스터링 {

    private static float totalCnt = 0;

    public int solution(String str1, String str2) {

        int answer = 0;
        float interCnt = 0, unionCnt = 0;
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        combi(str1, map1);
        combi(str2, map2);

        for (String key : map1.keySet()) {
            if (map2.get(key) == null) continue;
            interCnt += Math.min(map1.get(key), map2.get(key));
        }

        unionCnt = totalCnt - interCnt;

        if (unionCnt == 0) {
            return 65536;
        }

        answer = (int) (interCnt / unionCnt * 65536);

        return answer;
    }

    public void combi(String str, HashMap<String, Integer> map) {
        String a = "";

        for (int i = 0; i < str.length() - 1; i++) {
            a = str.substring(i, i + 2);
            if (Pattern.matches("^[a-zA-Z]*$", a)) {
                map.put(a, map.getOrDefault(a, 0) + 1);
                totalCnt++;
            }
        }
    }
}
