import java.util.HashMap;
import java.util.Map;

public class Hash3 {
    public class Solution {

        public int solution(String[][] clothes) {

            HashMap<String, Integer> map = new HashMap<String, Integer>();

            for (int i = 0; i < clothes.length; i++) {

                // 종류
                String key = clothes[i][1];

                // 종류별 요소 갯수
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            int answer = 1;

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                answer *= entry.getValue() + 1;
            }
            return answer - 1;
        }
    }
}
