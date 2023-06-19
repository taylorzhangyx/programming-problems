package leetcode

import (
	"fmt"
)

/**
Given the root of a binary tree, each node in the tree has a distinct value.
After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
Return the roots of the trees in the remaining forest. You may return the result in any order.

Constraints:

The number of nodes in the given tree is at most 1000.
Each node has a distinct value between 1 and 1000.
to_delete.length <= 1000
to_delete contains distinct values between 1 and 1000.
*/
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func delNodes(root *TreeNode, toDelete []int) []*TreeNode {
	// the tree is empty, return empty result
	if root == nil {
		return []*TreeNode{}
	}

	// make a delete map to save search logic
	delMap := make(map[int]bool)
	for _, d := range toDelete {
		delMap[d] = true
	}

	newForest := make([]*TreeNode, 0, 0)
	if !delMap[root.Val] {
		// 	check if the root need to be deleted
		newForest = append(newForest, root)
	}
	if len(toDelete) == 0 {
		// no node to be deleted, add root to the result
		return newForest
	}

	forest := delNodesWithForest(root, delMap, newForest)
	return forest
}

func delNodesWithForest(root *TreeNode, toDelete map[int]bool, newForest []*TreeNode) []*TreeNode {
	if root == nil {
		return newForest
	}
	left := root.Left
	right := root.Right
	if toDelete[root.Val] {
		// if the root need to be deleted
		// check the left and right node
		if root.Left != nil && !toDelete[root.Left.Val] {
			fmt.Printf("finding target %v, adding root left: %v\n", root.Val, root.Left.Val)
			newForest = append(newForest, root.Left)
		}
		if root.Right != nil && !toDelete[root.Right.Val] {
			fmt.Printf("finding target %v, adding root right: %v\n", root.Val, root.Right.Val)
			newForest = append(newForest, root.Right)
		}
		// since the current root is deleted, the children need to be unlinked
		root.Left = nil
		root.Right = nil
	}
	// 	otherwise continue
	newForest = delNodesWithForest(left, toDelete, newForest)
	newForest = delNodesWithForest(right, toDelete, newForest)
	// check if the child is deleted then unlink them
	if root.Left != nil && toDelete[left.Val] {
		root.Left = nil
	}
	if root.Right != nil && toDelete[right.Val] {
		root.Right = nil
	}
	return newForest
}
