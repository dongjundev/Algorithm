public class 키패드누르기 {
    public String solution(int[] numbers, String hand) {

        String spelHand = hand.toUpperCase().substring(0, 1);
        StringBuilder sb = new StringBuilder();
        int[][] arr = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};
        int[] leftLoc = {3, 0};
        int[] rightLoc = {3, 2};
        int[] nextLoc = {};

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                leftLoc = arr[numbers[i]];
                sb.append("L");
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                rightLoc = arr[numbers[i]];
                sb.append("R");
            } else {
                nextLoc = arr[numbers[i]];
                int leftDif = Math.abs(nextLoc[0] - leftLoc[0]) + Math.abs(nextLoc[1] - leftLoc[1]);
                int rightDif = Math.abs(nextLoc[0] - rightLoc[0]) + Math.abs(nextLoc[1] - rightLoc[1]);

                if (leftDif > rightDif) {
                    sb.append("R");
                    rightLoc = nextLoc;
                } else if (leftDif < rightDif) {
                    sb.append("L");
                    leftLoc = nextLoc;
                } else {
                    sb.append(spelHand);
                    if (spelHand.equals("R"))
                        rightLoc = nextLoc;
                    else
                        leftLoc = nextLoc;
                }
            }
        }

        return sb.toString();
    }
}
