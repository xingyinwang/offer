package com.wxy.leetCode;

/**
 * Created by Cser_W on 2018/5/30.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class 前序和后序造树 {
    public static void main(String[] args){
        int[] pre = new int[]{1,2};
        int[] in = new int[]{1,2};
     TreeNode root = new 前序和后序造树().buildTree(pre, in);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    private TreeNode buildTree(int[] preorder, int preStart, int preEnd
            , int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) {
            return root;
        }
        //找中序的分割点
        int index = 0;
        for (int i = inStart; i <= inEnd; ++i) {
            if (preorder[preStart] == inorder[i]) {
                index = i;
                break;
            }
        }
        index = index - inStart;
        root.left = buildTree(preorder, preStart + 1, preStart + index
                , inorder, inStart, inStart + index - 1);
        root.right = buildTree(preorder,preStart + index + 1, preEnd
                , inorder,inStart + index + 1, inEnd);
        return root;
    }
}
