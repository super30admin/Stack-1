// Time Complexity : O(2n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
create a stack
loop over temperatures
while stack is not empty and current temprature is greater than elements with index in stack
pop from stack and set the popped index value as current-ind(no of days)
after while append i to stack

return res
*/
package main

import "fmt"

func dailyTemperatures(T []int) []int {
	res := make([]int, len(T))
	if len(T) == 0 {
		return res
	}
	// put index in stacks, if warmer then check for all unresolved in stack
	// if colder then just push
	st := []int{}
	for i := 0; i < len(T); i++ {
		for len(st) > 0 && T[i] > T[st[len(st)-1]] {
			ind := st[len(st)-1]
			st = st[:len(st)-1]
			res[ind] = i - ind
		}
		st = append(st, i)
	}
	return res
}

func MainDailyTemp() {
	fmt.Println(dailyTemperatures([]int{73, 74, 75, 71, 69, 72, 76, 73})) //expected [1, 1, 4, 2, 1, 1, 0, 0]
}
