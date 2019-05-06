package com.datastructure;

import java.util.Stack;


public class MaxSumPathTopToBottom {
    MaxNode root;
    public static void main(String[] args) {
    	MaxSumPathTopToBottom tree=new MaxSumPathTopToBottom();
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
        Stack<Integer> stack = new Stack<>();
        pushDataToStack(tree.root,sum,stack);

    }
    private static boolean printPath(MaxNode node, int sum) {
        if(sum==0){
            return true;
        }
        if(node==null)
            return false;
        boolean left=printPath(node.left,sum-node.data);
        boolean right=printPath(node.right,sum-node.data);
        if(left||right){
            System.out.print(node.data+" ");
        }
        return left||right;

    }

    public static void pushDataToStack(MaxNode node, int sum, Stack<Integer> stack){

        if(sum!=0){
            stack.push(node.data);
        }
        sum=sum - node.data;
        if(sum==0){
            Stack<Integer> reverse = new Stack<>();
            while(!stack.empty()){
                reverse.push(stack.pop());
            }
            while(!reverse.empty()){
                System.out.print(reverse.pop()+" ");
            }

        }
        
        if(node!=null && node.left !=null){
            pushDataToStack(node.left,sum,stack);
        }
        if(node!=null && node.right!=null){
            pushDataToStack(node.right,sum,stack);
        }
        if(!stack.isEmpty()){
            stack.pop();
        }


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
