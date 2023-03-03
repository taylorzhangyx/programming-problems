package algorithm

import (
	"reflect"
	"testing"
)

var node1 = TreeNode{Val: 1}
var node2 = TreeNode{Val: 2}
var node3 = TreeNode{Val: 3}
var node4 = TreeNode{Val: 4}
var node5 = TreeNode{Val: 5}
var node6 = TreeNode{Val: 6}
var node7 = TreeNode{Val: 7}
var node8 = TreeNode{Val: 8}
var node9 = TreeNode{Val: 9}
var node10 = TreeNode{Val: 10}

func Test_delNodes(t *testing.T) {

	type args struct {
		root     func() *TreeNode
		toDelete []int
	}
	tests := []struct {
		name string
		args args
		want []*TreeNode
	}{
		{
			"success case 1",
			args{
				root:     genRoot1,
				toDelete: []int{2, 5},
			},
			[]*TreeNode{&node1, &node4, &node10},
		},
		{
			"success case 2",
			args{
				root:     genRoot1,
				toDelete: []int{1, 3},
			},
			[]*TreeNode{&node2, &node6, &node7},
		},
		{
			"success case 3",
			args{
				root:     genRoot1,
				toDelete: []int{3, 4},
			},
			[]*TreeNode{&node1, &node8, &node9, &node6, &node7},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {

			if got := delNodes(tt.args.root(), tt.args.toDelete); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("delNodes() = %v, want %v", got, tt.want)
			}
		})
	}
}

func genRoot1() *TreeNode {
	node1.Left = &node2
	node1.Right = &node3
	node2.Left = &node4
	node2.Right = &node5
	node3.Left = &node6
	node3.Right = &node7
	node4.Left = &node8
	node4.Right = &node9
	node5.Left = &node10
	return &node1
}
