class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:

        n = len(nums)
        res = [-1]*n
        stack = [0]

        for i in range(1, 2*n):

            while stack and nums[stack[-1]] < nums[i % n]:
                idx = stack.pop() 
                res[idx] = nums[i % n]
            
            if i<n:
                stack.append(i % n)
            #print(res, i, i % n, stack)
        
        return res
