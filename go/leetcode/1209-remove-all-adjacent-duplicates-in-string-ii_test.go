// BEGIN: 5f8d7e7f5b5c
package leetcode

import "testing"

func TestRemoveDuplicates(t *testing.T) {
	tests := []struct {
		name     string
		s        string
		k        int
		expected string
	}{
		{
			name:     "no duplicates",
			s:        "abcd",
			k:        2,
			expected: "abcd",
		},
		{
			name:     "single removal",
			s:        "deeedbbcccbdaa",
			k:        3,
			expected: "aa",
		},
		{
			name:     "multiple removals",
			s:        "pbbcggttciiippooaais",
			k:        2,
			expected: "ps",
		},
	}

	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			actual := removeDuplicates(tt.s, tt.k)
			if actual != tt.expected {
				t.Errorf("removeDuplicates(%q, %d): expected %q, but got %q", tt.s, tt.k, tt.expected, actual)
			}
		})
	}
}
// END: 5f8d7e7f5b5c
