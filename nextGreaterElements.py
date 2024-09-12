# Time Complexity: O(n)
# Space Complexity: O(n)
# Approach: Initialize a result array with -1s.
#			Use a monotonic stack.
#			Iterate the array.
#				While the value of the top of the stack is lesser than the value at i, pop the stack and update the resut array at popped value index with warmer temperature.
#				Add value to stack
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if len(nums) == 0:
            return []
        stack = [0]
        result = [-1]*len(nums)
        for idx in range(1,2*len(nums)+1):
            while len(stack) > 0 and  nums[idx % len(nums)] > nums[stack[-1]]:
                val = stack.pop()
                print(val)
                if  val != idx :
                    result[val] = nums[idx % len(nums)]
            stack.append(idx % len(nums))
            
        return result