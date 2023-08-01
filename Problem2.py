
'''
Problem: Next Greater Element II
Time Complexity: O(n), where n is given elements
Space Complexity: O(n)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        Maintained a monotonic decreasing stack
        as bigger element encountered we pop element
        we are only appending to stack when we are doing first pass 
'''
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [-1] * n
        stack = []

        for i in range(2 * n):
            while stack and nums[stack[-1]] < nums[i%n]:
                idx = stack.pop()
                result[idx] = nums[i%n]

            if i<n:
                stack.append(i)
        
        return result