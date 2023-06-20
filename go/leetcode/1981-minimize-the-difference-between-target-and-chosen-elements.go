package leetcode

import "golang.org/x/exp/slices"

func minimizeTheDifference(mat [][]int, target int) int {
	for i, _ := range mat {
		mat[i] = slices.Sort(mat[i])
	}
	print(mat)
}
