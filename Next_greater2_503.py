# Time - O(2n)
# Space -O(n)

Algo - 
We use a stack to go through the elements in the given nums
We calculate the stack top element and add the respective element to our output array
We keep on adding elements and pop them once they find their respective greater element
(While to cover the greater elements at farther distance)
Looping twice as the elemnts are present in the circular array

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if not nums:
            return []
        ans = [-1 for i in range(len(nums))]
        stck = []
        for i in range(2 *len(nums)):
            # i = i%len(nums)
            while stck and nums[i%len(nums)] > nums[stck[-1]]:
                temp = stck.pop(-1)
                ans[temp] = nums[i%len(nums)]     
            
            stck.append(i%len(nums))
        return ans
            
            
            
        
        
#         if not nums:
#             return []
#         stck = []
#         ans = [-1 for _ in range(len(nums))]            
            
# #         going from left to right
#         for i in range(len(nums)):
#             while stck and nums[i] > nums[stck[-1]]:
#                 temp = stck.pop(-1)
#                 ans[temp] = nums[i]
#             stck.append(i)
# #             going from right to left
#         for i in range(len(nums)-1,-1,-1):
#             while stck and nums[i] > nums[stck[-1]]:
#                 temp = stck.pop(-1)
#                 ans[temp] = nums[i]
#             stck.append(i) 
        
#         return ans
            
        
    # def helper(nums):
    #     stck = []
    #     ans = [-1 for _ in range(len(nums))]
    #     for i in range(len(nums)):
    #         while stck and nums[i] > nums[stck[-1]]:
    #             temp = stck.pop(-1)
    #             ans[temp] = nums[i]
    #         stck.append(i)
    #     return ans
            
            
            
            
        
        