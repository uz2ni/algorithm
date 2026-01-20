package inflearn_allinone;

/**
 * [트리] DFS (클래스 2진트리)
 */
public class Part7Test3 {

    public static void main(String[] args) {
        // tree 셋팅
        Node tree = new Node(0);
        tree.left = new Node(3);
        tree.right = new Node(1);
        tree.left.left = new Node(6);
        tree.left.right = new Node(4);
        tree.right.right = new Node(5);
        tree.right.right.right = new Node(2);

        solution(tree);
    }

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void solution(Node cur) {
        dfs(cur);
    }

    public static void dfs(Node cur) {
        if(cur == null) return;
        System.out.println(cur.value); // 전위 순회 지점

        dfs(cur.left);
        // 중위 순회 지점
        dfs(cur.right);

        // 후위 순회 지점
    }
}
