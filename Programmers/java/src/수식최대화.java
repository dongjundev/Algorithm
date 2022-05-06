import java.util.ArrayList;

public class 수식최대화 {

    // 계산할 숫자를 저장하는 배열
    ArrayList<Long> nums = new ArrayList<>();
    // 계산할 연산자를 저장하는 배열
    ArrayList<Character> opers = new ArrayList<>();
    long answer = 0L;

    public long solution(String expression) {
        char[] operators = {'*', '+', '-'}; // 존재하는 모든 연산자
        char[] oper = new char[3]; // 조합할 우선순위 연산자
        boolean[] check = new boolean[3]; // 연산자가 중복되지 않도록 확인해주는 배열

        stringToArray(expression); // expression을 연산자와 숫자로 분리
        dfs(0, operators, oper, check); // 연산자 우선순위 조합을 모두 만들어 해당 연산자 우선순위로 계산

        return answer;
    }

    // expression을 연산자와 숫자로 분리
    public void stringToArray(String ex) {
        String num = "";
        for (int i = 0; i < ex.length(); i++) {
            // 숫자일 경우 num에 추가
            if (Character.isDigit(ex.charAt(i))) num += ex.charAt(i);
            // 현재 값이 연산자인 경우 이전 num을 숫자로 바꾸어 nums배열에 추가 후 연산자는 opers배열에 추가
            else {
                nums.add(Long.parseLong(num));
                opers.add(ex.charAt(i));
                num = "";
            }
        }
        nums.add(Long.parseLong(num)); // 마지막 num은 추가가 안됬음으로 nums에 추가
    }

    // 연산자 우선순위 조합을 모두 만들어 해당 연산자 우선순위로 계산
    public void dfs(int idx, char[] operators, char[] oper, boolean[] check) {
        // 3개의 연산자 우선순위를 모두 정한경우
        if (idx == 3) calcFormula(oper);
        else {
            for (int i = 0; i < 3; i++) {
                // 아직 지정하지 않은 위치의 연산자일 경우
                if (!check[i]) {
                    check[i] = true; // 현재 연산자를 사용으로 체크
                    oper[idx] = operators[i]; // 현재 연산자를 oper에 추가
                    dfs(idx + 1, operators, oper, check); // idx를 증가 후 dfs재귀
                    check[i] = false; // 이전 재귀가 끝나면 다음번 재귀를 위해 현재 값 false로 바꿈
                }
            }
        }
    }

    // 지정한 우선순위로 현재 식을 계산
    public void calcFormula(char[] oper) {
        // nums배열을 변경하며 사용하기위한 임시 nums생성
        ArrayList<Long> tmpNums = new ArrayList<>(nums);
        // opers배열을 변경하며 사용하기위한 임시 opers생성
        ArrayList<Character> tmpOpers = new ArrayList<>(opers);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < tmpOpers.size(); j++) {
                // 현재 연산자가 우선순위 연산자와 같은 경우
                if (tmpOpers.get(j) == oper[i]) {
                    // 해당 위치의 값을 계산
                    long result = calculate(tmpNums.remove(j), tmpNums.remove(j), tmpOpers.remove(j));
                    // 계산된 결과를 현재의 위치에 저장 후 지워진 항목을 처리하기 위해 j--
                    tmpNums.add(j--, result);
                }
            }
        }
        // 계산의 결과를 절대값처리 후 가장 큰 값으로 answer변경
        answer = Math.max(answer, Math.abs(tmpNums.get(0)));
    }

    // 두개의 숫자 지정된 연산자로 계산
    public long calculate(long n1, long n2, char c) {
        switch (c) {
            case '-':
                return n1 - n2;
            case '+':
                return n1 + n2;
            default:
                return n1 * n2;
        }
    }
}
