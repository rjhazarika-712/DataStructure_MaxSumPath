package com.datastructure;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class MaxNode{
    int data;
    MaxNode left;
    MaxNode right;
    public MaxNode(int data){
        this.data=data;
        left=null;
        right=null;
    }
}
public class MaxPathSumBottomToTop {
    MaxNode root;
    public static void main(String[] args) {
        MaxPathSumBottomToTop tree=new MaxPathSumBottomToTop();
        tree.root = new MaxNode(1);
        tree.root.left = new MaxNode(8);
        tree.root.right = new MaxNode(9);
        tree.root.left.left = new MaxNode(1);
        tree.root.left.left.left = new MaxNode(2);
        tree.root.left.left.left.left = new MaxNode(3);
        tree.root.left.left.right = new MaxNode(5);
        tree.root.left.right = new MaxNode(5);
        tree.root.left.right.left = new MaxNode(2);
        tree.root.left.right.right = new MaxNode(6);
        int sum=tree.findmaxSum(tree.root);
        System.out.println("Max sum is "+sum);
        System.out.println("Print path is: ");
        List<Integer> list = new ArrayList<>();
        printPath(tree.root,sum,list);

    }
    private static boolean printPath(MaxNode node, int sum, List<Integer> list) {
        if(sum==0){
            return true;
        }
        if(node==null)
            return false;
        boolean left=printPath(node.left,sum-node.data, list);
        boolean right=printPath(node.right,sum-node.data, list);
        if(left||right){
            System.out.print(node.data+" ");
        }
        return left||right;

    }
    private int findmaxSum(MaxNode node) {
        if(node==null)
            return 0;
        if(node.data %2 ==0 && node.left != null && node.right!=null ){
            if(node.left.data %2 ==0 && node.right.data %2 ==0)
                return 0;
        }
        if(node.data %2 !=0 && node.left != null && node.right!=null ){
            if(node.left.data %2 !=0 && node.right.data %2 !=0)
                return 0;
        }
        int left=findmaxSum(node.left);
        int right=findmaxSum(node.right);

        if(node.data %2 ==0 && node.left != null && node.right!=null)
            if(node.left.data %2!=0 && node.right.data%2 !=0)
            return (left>right?left:right)+node.data;

        else if(node.data %2 !=0 && node.left != null && node.right!=null)
            if(node.left.data %2==0 && node.right.data%2==0)
            return (left>right?left:right)+node.data;
        if(node.data %2 ==0 && node.left != null && node.right!=null)
            if(node.left.data %2==0 && node.right.data%2 !=0)
            return right+node.data;

        else if(node.data %2 ==0 && node.left != null && node.right!=null)
            if(node.left.data %2!=0 && node.right.data%2 ==0)
            return left+node.data;

        else if(node.data %2 !=0 && node.left != null && node.right!=null)
            if(node.left.data %2==0 && node.right.data%2 !=0)
            return left+node.data;

        else if(node.data %2 !=0 && node.left != null && node.right!=null)
            if(node.left.data %2!=0 && node.right.data%2 ==0)
            return right+node.data;

        return  (left>right?left:right)+node.data;

    }

}
