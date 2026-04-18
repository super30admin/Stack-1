# problem 2 

# https://leetcode.com/problems/next-greater-element-ii/

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        my_stack = []
        final_arr = [-1]*n
        for i in range(2*n):
            while my_stack and nums[i%n] > nums[my_stack[-1]]:
                popped_idx = my_stack.pop()
                final_arr[popped_idx] = nums[i%n] 
            if i < n:
                my_stack.append(i)
            elif my_stack and my_stack[-1] == i%n:
                break 
        return final_arr