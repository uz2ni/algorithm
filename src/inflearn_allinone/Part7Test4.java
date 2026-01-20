package inflearn_allinone;

import java.util.ArrayList;
import java.util.List;

/**
 * [트리] DFS (클래스 N진트리)
 */
public class Part7Test4 {

    public static void main(String[] args) {
        // tree 셋팅
        Node tree = new Node(0);
        tree.children.add(new Node(7));
        tree.children.add(new Node(3));
        tree.children.add(new Node(1));
        tree.children.get(0).children.add(new Node(6));
        tree.children.get(0).children.add(new Node(4));
        tree.children.get(2).children.add(new Node(5));
        tree.children.get(2).children.get(0).children.add(new Node(2));

        solution(tree);
    }

    public static class Node {
        int value;
        List<Node> children;

        public Node(int value) {
            this.value = value;
            children = new ArrayList<>();
        }
    }

    public static void solution(Node root) {
        dfs(root);
    }

    public static void dfs(Node cur) {
        if(cur == null) return;
        System.out.println(cur.value);
        for(Node child : cur.children) {
            dfs(child);
        }
    }
}
