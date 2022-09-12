import java.util.HashSet;
import java.util.Set;

public class test {
    private boolean[] visited;
    private Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        int n = numbers.length();
        visited = new boolean[n];

        recur(0, numbers, "");

        System.out.println(set);
        return set.size();
    }

    private void recur(int depth, String numbers, String str) {
        if (depth == numbers.length()) {
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i] == false) {
                visited[i] = true;
                String number = str + numbers.charAt(i);

                if (check(Integer.parseInt(number))) {
                    set.add(Integer.parseInt(number));
                }

                recur(depth + 1, numbers, number);
                visited[i] = false;
            }
        }
    }

    private boolean check(int n) {
        if (n <= 1) return false;

        for (int i = 2; i < n; i++) {
            if (n % i ==0) {
                return false;
            }
        }

        return true;
    }
}