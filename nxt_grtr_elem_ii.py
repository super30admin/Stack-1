# Time Complexity : O(n)
# Space Complexity : O(n)

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if not nums: return []
        
        n = len(nums)
        result = [-1] * n
        stack = []          # All indices go in stack
        next_pass = 0
        
        for i in range(2 * n):      # 2-pass as non-empty stack
            while stack and nums[i % n] > nums[stack[-1]]:
                idx = stack.pop()
                result[idx] = nums[i % n]
            
            # Only if first pass, push.(Dont push twice.)
            if i < n:
                stack.append(i)
            
        return result