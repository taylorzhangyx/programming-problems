package main

import (
	"encoding/json"
	"fmt"
)

func main() {
	print("starting code...\n")

	// Set up the test list
	ll := []*Obj{
		{Val: 1},
		{Val: 2},
		{Val: 3},
	}

	// call the loop with bug
	resWithBug := LoopWithBug(ll)

	// print out the result
	fmt.Println(resWithBug)
}

func LoopWithBug(list []*Obj) ObjList {
	newList := make([]*Obj, 0, len(list))
	for _, o := range list {
		fmt.Printf("Before append o=%v, o_pointer=%p, newList=%v\n", o, &o, newList)
		newList = append(newList, o)
		fmt.Printf("After append newList=%v\n", newList)
	}
	return ObjList{
		Objs: newList,
	}
}

// 测试用数据结构
type Obj struct {
	Val int
}

func (o *Obj) String() string {
	b, _ := json.Marshal(o)
	return string(b)
}

type ObjList struct {
	Objs []*Obj
}

func (ol *ObjList) String() string {
	b, _ := json.Marshal(ol)
	return string(b)
}
