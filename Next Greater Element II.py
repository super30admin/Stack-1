# time complexity is o(n), where n is the size of the input
# space complexity is o(n), where n is the size of the input
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = [-1 for i in range(n)]
        stack = list()
        for i in range(2*n):
            if(i < n):
                while(len(stack) > 0 and nums[stack[-1]] < nums[i]):
                    res[stack[-1]] = nums[i]
                    stack.pop()
                stack.append(i)
            else:
                i = i % n
                while(len(stack) > 0 and nums[stack[-1]] < nums[i]):
                    res[stack[-1]] = nums[i]
                    stack.pop()
        return res
                
            
            