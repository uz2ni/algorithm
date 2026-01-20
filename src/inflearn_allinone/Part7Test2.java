package inflearn_allinone;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * [트리] BFS (클래스 N진트리)
 */
public class Part7Test2 {

    public static void main(String[] args) {
        // tree 셋팅
        Node tree = new Node(0);
        tree.children.add(new Node(3));
        tree.children.add(new Node(7));
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
        bfs(root);
    }

    public static void bfs(Node root) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()) {
            Node cur = q.poll();
            System.out.println(cur.value);

            for(Node child : cur.children) {
                q.offer(child);
            }
        }
    }
}
