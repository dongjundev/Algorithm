import java.util.ArrayList;
import java.util.List;

public class Leet94 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        recur(root, answer);
        return answer;
    }

    private void recur(TreeNode node, List<Integer> answer) {
        if (node == null) {
            return;
        }

        recur(node.left, answer);
        answer.add(node.val);
        recur(node.right, answer);
    }
}
