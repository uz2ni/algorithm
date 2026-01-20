package inflearn_allinone;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * [트리] BFS (클래스 2진트리)
 */
public class Part7Test1 {

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

    // static 참고
    // 1. static 사용했을 때 차이
    // - 1개 인스턴스만 갖는다는 의미는 아님. 바깥 클래스(Part7Test1)의 인스턴스가 없어도 독립적으로 존재할 수 있는 클래스가 됨.
    // - 따라서, static class는 인스턴스가 여러개일 수 있다.
    // 2. static 붙여야하는 이유
    // - static void main() 정적 메서드에서 클래스 사용하려면 static class 여야 한다.
    // - 정적 메서드는 바깥 클래스 인스턴스 생성 없이 쓸수있어야하기 때문에 내부에서도 인스턴스 사용 못함.

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
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

            if(cur.left != null) q.offer(cur.left);
            if(cur.right != null) q.offer(cur.right);
        }
    }
}
