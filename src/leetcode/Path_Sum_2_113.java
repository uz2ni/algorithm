package leetcode;

import java.util.ArrayList;
import java.util.List;

/** 113. Path Sum II **/
public class Path_Sum_2_113 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2, node1, null);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3, node2, node4);
        TreeNode node1_1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6,null, node1_1);
        TreeNode node5 = new TreeNode(5, node3, node6);

        pathSum2(node5, 12);
        System.out.println(answers.toString());
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

    public static List<List<Integer>> answers;

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        answers = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(root != null) {
            list.add(root.val);
            dfs(root, targetSum, root.val, list);
        }
        return answers;
    }

    /** 성공-내풀이 (자식 노드 넣기, sum 변수에 합산) **/
    public static void dfs(TreeNode node, int targetSum, int sum, List<Integer> list) {

        if(node.left == null && node.right == null) {
          if(targetSum == sum) {
              answers.add(new ArrayList<>(list));
          }
          return;
        }

        if(node.left != null) {
            list.add(node.left.val);
            dfs(node.left, targetSum, sum+node.left.val, list);
            list.remove(list.size() - 1);
        }

        if(node.right != null) {
            list.add(node.right.val);
            dfs(node.right, targetSum, sum+node.right.val, list);
            list.remove(list.size()-1);
        }
    }

    /** 성공-개선 (현재 노드 기준으로 처리, targetSum 차감) **/
    public static List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        answers = new ArrayList<>();
        dfs2(root, targetSum, new ArrayList<>());
        return answers;
    }

    public static void dfs2(TreeNode node, int targetSum, List<Integer> list) {
        if(node == null) return;

        list.add(node.val);
        targetSum-=node.val;

        if(node.left == null && node.right == null && targetSum == 0) {
            answers.add(new ArrayList<>(list));
        }

        dfs2(node.left, targetSum, list);
        dfs2(node.right, targetSum, list);

        list.remove(list.size()-1);
    }
}
