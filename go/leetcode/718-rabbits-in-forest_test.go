package leetcode

import "testing"

func Test_numRabbits(t *testing.T) {
	type args struct {
		answers []int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{
			"5 rabbits",
			args{
				answers: []int{1, 1, 2},
			},
			5,
		},
		{
			"11 rabbits",
			args{
				answers: []int{10, 10, 10},
			},
			11,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := numRabbits(tt.args.answers); got != tt.want {
				t.Errorf("numRabbits() = %v, want %v", got, tt.want)
			}
		})
	}
}

func Test_calRabbits(t *testing.T) {
	type args struct {
		sameVal     int
		nSameAnswer int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{
			"1 vs 1",
			args{
				sameVal:     1,
				nSameAnswer: 1,
			},
			2,
		},
		{
			"0 vs 1",
			args{
				sameVal:     0,
				nSameAnswer: 1,
			},
			1,
		},
		{
			"2 vs 10",
			args{
				sameVal:     2,
				nSameAnswer: 10,
			},
			12,
		},
		{
			"100 vs 1",
			args{
				sameVal:     100,
				nSameAnswer: 1,
			},
			101,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := calRabbits(tt.args.sameVal, tt.args.nSameAnswer); got != tt.want {
				t.Errorf("calRabbits() = %v, want %v", got, tt.want)
			}
		})
	}
}
