package com.dataStructure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
    }

    class Command {
        boolean flag;
        TreeNode node;
        Command(boolean flag, TreeNode node){
            this.flag = flag;
            this.node = node;
        }
    }

    List preOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<Command> stack = new Stack<>();
        stack.push(new Command(false, root));
        while (!stack.isEmpty()){
            Command command = stack.pop();
            
            if (command.flag)
                result.add(command.node.val);
            else {
                if (command.node.right != null)
                    stack.push(new Command(false, command.node.right));
                if (command.node.left != null)
                    stack.push(new Command(false, command.node.left));
                stack.push(new Command(true, command.node));
            }
        }
        return result;
    }
}
