import java.util.*;

public class 메뉴리뉴얼 {

    static HashMap<String, Integer> map;

    public static void combi(String str, StringBuilder sb, int idx, int cnt, int n) {

        if (cnt == n) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for (int i = idx; i < str.length(); i++) {
            sb.append(str.charAt(i));
            combi(str, sb, i + 1, cnt + 1, n);
            sb.delete(cnt, cnt + 1);
        }
    }

    public List<String> solution(String[] orders, int[] course) {

        List<String> answer = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            char[] toCharArray = orders[i].toCharArray();
            Arrays.sort(toCharArray);
            orders[i] = String.valueOf(toCharArray);
        }

        for (int i = 0; i < course.length; i++) {
            map = new HashMap<>();
            int max = Integer.MIN_VALUE;

            for (int j = 0; j < orders.length; j++) {
                StringBuilder sb = new StringBuilder();
                if (orders[j].length() >= course[i]) {
                    combi(orders[j], sb, 0, 0, course[i]);
                }
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                max = Math.max(entry.getValue(), max);
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (max >= 2 && entry.getValue() == max) {
                    answer.add(entry.getKey());
                }
            }
        }

        Collections.sort(answer);

        return answer;
    }
}
