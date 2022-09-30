"""
Time Complexity :
Space Complexity :
Did this code successfully run on Leetcode :
Any problem you faced while coding this :


Your code here along with comments explaining your approach
Problem2 Next Greater Element II (https://leetcode.com/problems/next-greater-element-ii/)

"""
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        """
        TC: O(N)
        SC: O(N)
        """
        n = len(nums)
        res = [-1 for i in range(n)]
        stack = []
        
        for i in range(2*n):
            while stack and nums[stack[-1]] < nums[i % n]:
                temp = stack.pop()
                res[temp] = nums[i %n]
            if i < n:
                stack.append(i)
            
        return res
                
        
        