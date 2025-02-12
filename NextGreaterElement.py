#-------Time = O(2n)->outer for loop + O(n)-> for while loop = O(3n)
# Space = O(n) for stack
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        stack = []
        n = len(nums)
        result = [-1 for _ in range(n)]
        for i in range(2*n):
            while stack and nums[stack[-1]] < nums[i % n]:
                popped_idx = stack.pop()
                result[popped_idx] = nums[i % n]
            if i < n:
                stack.append(i)
        return result
        