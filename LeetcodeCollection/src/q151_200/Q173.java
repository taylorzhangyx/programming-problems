package q151_200;

import java.util.Stack;

import dataStructure.TreeNode;


public class Q173 {
	//post order iterator
	public class BSTIterator {
	    Stack<TreeNode> s;
	    public BSTIterator(TreeNode root) {
	        s = new Stack<>();
	        while(root != null){
	            s.push(root);
	            if(root.left != null) root = root.left;
	            else root = root.right;
	        }
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return !s.isEmpty();
	    }

	    /** @return the next smallest number */
	    public int next() {
	        TreeNode node = s.pop();
	        if(!s.isEmpty() && s.peek().right != null && node != s.peek().right){
	            TreeNode add = s.peek().right;
	            while(add != null){
	                s.push(add);
	                if(add.left != null) add = add.left;
	                else add = add.right;
	            }
	        }
	        return node.val;
	    }
	}
}
