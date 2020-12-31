// Time Complexity : O(3n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
create res array and set all to -1
create a stack
loop over array 2 times the length
while stack is not empty and [i%len of array] is greater than elements with index in stack
pop from stack and set the popped index value as nums[i%len of array]

after while append i to stack only if i < len(nums) //valid element not circular recheck

return res
*/
package main

import "fmt"

func nextGreaterElements(nums []int) []int {
	res := make([]int, len(nums))
	if len(nums) == 0 {
		return res
	}
	for i := 0; i < len(nums); i++ {
		res[i] = -1
	}
	st := []int{}
	for i := 0; i < 2*len(nums); i++ {
		for len(st) > 0 && nums[i%len(nums)] > nums[st[len(st)-1]] {
			ind := st[len(st)-1]
			st = st[:len(st)-1]
			res[ind] = nums[i%len(nums)]
		}
		if i < len(nums) {
			st = append(st, i)
		}
	}
	return res
}

func MainNextGreaterElement() {
	fmt.Println(nextGreaterElements([]int{1, 2, 1})) //expected 2,-1,2
}
