import java.util.HashSet;

public class test {

    public static HashSet<Integer> numbersSet = new HashSet<>();

    public static void recursive(String comb, String others) {

        // 1. 현재 조합을 set에 추가한다.
        if (!comb.equals(""))
            numbersSet.add(Integer.valueOf(comb));

        // 2. 남은 숫자 중 한 개를 더해 새로운 조합을 만든다.
        for (int i = 0; i < others.length(); i++) {
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
            System.out.println("others.substring(0, i): "+others.substring(0, i));
            System.out.println("others.substring(i + 1): "+others.substring(i + 1));
        }
    }
}