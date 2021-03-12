# // Time Complexity : O(n) 
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# use stack as we want to find the next larger
# run for loop twice i.e till i == 2n
# put each index in stack if i<n
# compare with the i of loop with the stack.peek if it is greter then runf while loop until this condition is satisfied
# in while loop put the res array with current element of loop 


class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if nums == None or len(nums) == 0: return
        stack = []
        n = len(nums)
        res = [-1]*n
        
        for i in range(2*n):
            # check if we have elements in stack and we have found the next greatest 
            # while loop till this condition is true and keep updating the index inside the stack with the current in loop
            while stack and nums[i%n]>nums[stack[-1]]:
                x = stack.pop()
                res[x] = nums[i%n]
            if i<n:
                stack.append(i)
        return res
        
        