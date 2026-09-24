package leetcode;

import javax.swing.tree.TreeNode;
import java.util.Collections;
import java.util.PriorityQueue;

/** 230. Kth Smallest Element in a BST **/
// k번째 가장 작은 수 반환
public class Kth_Smallest_Element_in_a_BST_230 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2, node1, null);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3, node2, node4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5, node3, node6);
        // System.out.println(kthSmallest1(node5, 4));
        System.out.println(kthSmallest2(node5, 3));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static PriorityQueue<Integer> pq;

    /** 최대힙 방식 **/
    public static int kthSmallest1(TreeNode root, int k) {
        pq = new PriorityQueue<>(Collections.reverseOrder()); // 최대힙(내림차순)
        dfs1(root, k);
        return pq.poll();
    }

    public static void dfs1(TreeNode node, int k) {
        if(node == null) {
            return;
        }

        pq.offer(node.val);

        if(pq.size() > k) {
            pq.poll();
        }

        dfs1(node.left, k);
        dfs1(node.right, k);
    }

    /** 중위 순회 방식 **/
    public static int cnt = 0;
    public static int answer = -1;
    public static int kthSmallest2(TreeNode root, int k) {
        inorder(root, k);
        return answer;
    }

    public static void inorder(TreeNode node, int k) {
        if(node == null) {
            return;
        }
        if(cnt == k) {
            System.out.println("break cnt: " + cnt + ", val: " + node.val);
            return;
        }

        inorder(node.left, k);

        if(cnt == k) {
            System.out.println("break2 cnt: " + cnt + ", val: " + node.val);
            return;
        }

        answer = node.val;
        cnt++;
        System.out.println("answer: " + answer + ", cnt: " + cnt);

        inorder(node.right, k);
    }
}
