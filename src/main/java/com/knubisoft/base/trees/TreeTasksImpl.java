package com.knubisoft.base.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class TreeTasksImpl implements TreeTasks {

    @Override
    public boolean isSameTree(TreeNode node1, TreeNode node2) {
        return node1.equals(node2);
    }

    @Override
    public List<Integer> inorderTraversal(TreeNode node) {
        List<Integer> inorder = new ArrayList<>();
        if (node != null) {
            if (node.left != null) {
                inorder.addAll(inorderTraversal(node.left));
            }
            inorder.add(node.val);
            if (node.right != null) {
                inorder.addAll(inorderTraversal(node.right));
            }
        }
        return inorder;
    }

    @Override
    public boolean isSymmetric(TreeNode node) {
        if (node != null) {

        }
        return false;
    }

    @Override
    public int maxDepth(TreeNode node) {
        if (node != null) {
            if (node.left == null && node.right == null) return 1;
            int leftDepth = 0, rightDepth = 0;
            if (node.left != null) leftDepth = maxDepth(node.left) + 1;
            if (node.right != null) rightDepth = maxDepth(node.right) + 1;
            return Math.max(leftDepth, rightDepth);
        }
        return 0;
    }

    @Override
    public boolean hasPathSum(TreeNode node, int targetSum) {
        boolean leftPath = false, rightPath = false, curNode = false;
        if (node != null) {
            if (node.right == null && node.left == null)
                curNode = targetSum == node.val;
            if (node.left != null)
                leftPath = hasPathSum(node.left, targetSum - node.val);
            if (node.right != null)
                rightPath = hasPathSum(node.right, targetSum - node.val);
        }
        return curNode || leftPath || rightPath;
    }

    @Override
    public TreeNode invertTree(TreeNode node) {
        if(node != null){
            if(node.left != null && node.right != null){
                node.right = invertTree(node.left);
                node.left = invertTree(node.right);
            }
            return node;
        }
        return null;
    }

    @Override
    public int sumOfLeftLeaves(TreeNode node) {
        int a = 0, b = 0;
        if (node != null) {
            if (node.left != null)
                a = node.left.left == null && node.left.right == null ? node.left.val : sumOfLeftLeaves(node.left);
            if (node.right != null)
                b = sumOfLeftLeaves(node.right);
        }
        return a + b;
    }

    @Override
    public TreeNode mergeTrees(TreeNode node1, TreeNode node2) {
        if (node2 != null) {
            if (node1 != null) {
                node1.val += node2.val;
                node1.left = mergeTrees(node1.left, node2.left);
                node1.right = mergeTrees(node1.right, node2.right);
            } else node1 = node2;
        }
        return node1;
    }
}
