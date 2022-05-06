public class 숫자문자열과영단어 {
    static public int solution(String s) {
        String tempStr = s;
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        tempStr = s.replace(arr[0] ,"0");
        tempStr = tempStr.replace(arr[1] ,"1");
        tempStr = tempStr.replace(arr[2] ,"2");
        tempStr = tempStr.replace(arr[3] ,"3");
        tempStr = tempStr.replace(arr[4] ,"4");
        tempStr = tempStr.replace(arr[5] ,"5");
        tempStr = tempStr.replace(arr[6] ,"6");
        tempStr = tempStr.replace(arr[7] ,"7");
        tempStr = tempStr.replace(arr[8] ,"8");
        tempStr = tempStr.replace(arr[9] ,"9");

        int answer = Integer.parseInt(tempStr);
        return answer;
    }
}
