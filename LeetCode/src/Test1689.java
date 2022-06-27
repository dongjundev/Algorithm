public class Test1689 {
    public int minPartitions(String n) {
        int MAX = -1;

        for (int i = 0; i < n.length(); i++) {
            MAX = Math.max(MAX, n.charAt(i) - '0');
        }

        return MAX;
    }
}
