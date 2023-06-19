package leetcode

// You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

// We repeatedly make k duplicate removals on s until we no longer can.

// Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

// Example 1:

// Input: s = "abcd", k = 2
// Output: "abcd"
// Explanation: There's nothing to delete.
// Example 2:

// Input: s = "deeedbbcccbdaa", k = 3
// Output: "aa"
// Explanation:
// First delete "eee" and "ccc", get "ddbbbdaa"
// Then delete "bbb", get "dddaa"
// Finally delete "ddd", get "aa"
// Example 3:

// Input: s = "pbbcggttciiippooaais", k = 2
// Output: "ps"

// Constraints:

// 1 <= s.length <= 105
// 2 <= k <= 104
// s only contains lowercase English letters.

func removeDuplicates_ver1_time_limit_exceeeded(s string, k int) string {

	i, has := hasDup(s, k)
	for has {
		s = removeDup(s, k, i)
		i, has = hasDup(s, k)
	}

	return s
}

// hasDup returns the index of the first duplicate and a bool indicating if there is a matched duplicate
func hasDup(s string, k int) (int, bool) {
	// convert string to a char list
	dupCount := 1
	lastChar := ""
	for i, c := range s {
		cstr := string(c)
		if lastChar == cstr {
			// if equal to the last one, add count and see if match dup condition
			dupCount++
			if dupCount == k {
				// match the condition, return true and start remove
				return i, true
			}
		} else {
			// reset the count
			dupCount = 1
		}
		// before entering next loop, save the last char
		lastChar = cstr
	}
	return 0, false
}

// removeDup removes the substring between i-k and i from s return a new string
func removeDup(s string, k int, i int) string {

	// validation check
	if i >= len(s) || i-k+1 < 0 {
		return ""
	}
	ns := ""

	// take the first substring starting 0 to i-k+1, to exclude the char at i-k+1
	if i-k >= 0 {
		ns = s[:i-k+1]
	}
	// take the second substring starting i+1 to the end of the string, to exclude the char at i
	if i <= len(s)-1 {
		ns = ns + s[i+1:]
	}
	return ns
}
