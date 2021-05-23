class Solution:
        
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if not nums:
            return []
        n = len(nums)
        result= [-1] *len(nums)
        stack = []
        
        for _ in range(2):
            for i,num in enumerate(nums):                
                while stack and num > nums[stack[-1]]:            
                    result[stack.pop()] = num                
                stack.append(i)
        return result        


#         for i in range(n * 2) :
#             temp = i %  n
#             while stack and nums[temp] > nums[stack[-1]]:
#                 idx = stack.pop()
#                 result[idx] =  nums[temp]
                
#             stack.append(temp)
        
#         return result
        
