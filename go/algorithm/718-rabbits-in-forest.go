package algorithm

import (
	"fmt"
	"math"
	"sort"
)

/*
There is a forest with an unknown number of rabbits. We asked n rabbits "How many rabbits have the same color as you?" and collected the answers in an integer array answers where answers[i] is the answer of the ith rabbit.
Given the array answers, return the minimum number of rabbits that could be in the forest.

Example 1:

Input: answers = [1,1,2]
Output: 5
Explanation:
The two rabbits that answered "1" could both be the same color, say red.
The rabbit that answered "2" can't be red or the answers would be inconsistent.
Say the rabbit that answered "2" was blue.
Then there should be 2 other blue rabbits in the forest that didn't answer into the array.
The smallest possible number of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn't.

Example 2:

Input: answers = [10,10,10]
Output: 11

Constraints:

1 <= answers.length <= 1000
0 <= answers[i] < 1000
*/

/*
Thought process:
1. if the rabbits in the same color AND in the answers array, they should answer the same value otherwise they are inconsistent with each other.
2. if the rabbits in different colors, the answers could be the same or not.
3. if the rabbits in different colors AND have the same value AND in the answers array, the number of rabbits would be bigger than the value itself.

So we can
1. find the rabbits with the same value. Group them together.
2. for each group, find a minimum matched number of colors then calculate the total number.
3. sum the  number together.
*/

func numRabbits(answers []int) int {
	// handle null and zero cases
	if answers == nil || len(answers) == 0 {
		return 0
	}
	// sort the answers in order
	fmt.Println("before sort", answers)
	sort.Ints(answers)
	fmt.Println("after sort", answers)

	// init the final sum
	rcount := 0
	// iterate the answers, find group the values by the same value
	lv := answers[0]
	li := 0
	for i := 1; i < len(answers); i++ {
		cur := answers[i]
		// 	compare the current value and the left value
		if cur != lv {
			//  the current value is a new one, which means the li-th to i-1-th values are the same and need to be processed
			//	add new calculated answer to result count
			rcount += calRabbits(lv, i-li)
			// 	update left value and left index to be current one
			lv = cur
			li = i
		}
	}
	// process the last chunk of value
	rcount += calRabbits(lv, len(answers)-li)
	// return the final value
	return rcount
}

func calRabbits(sameVal int, nSameAnswer int) int {
	// given the number of same color answers and the number of answers
	nGroup := math.Ceil(float64(nSameAnswer) / float64(sameVal+1))

	return int(nGroup) * (sameVal + 1)
}
