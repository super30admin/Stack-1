# Time Complexity : O(n)
# Space Complexity : O(n);
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
class Solution:
    def nextGreaterElements(self, nums: list[int]) -> list[int]:
        result = [-1]*len(nums)
        stack = []
        for i in range(2*len(nums)):
            i = i%len(nums)
            while len(stack) != 0 and nums[i] > nums[stack[-1]]:
                result[stack.pop()] = nums[i]
            if i < len(nums):
                stack.append(i)
        return result


print(Solution().nextGreaterElements([1, 2, 3, 4, 3]))

# class Solution:
#     def nextGreaterElements(self, nums: list[int]) -> list[int]:
#         result = [-1]*len(nums)
#         stack = []
#         count = 0
#         for i in range(len(nums)):
#             if i == 0 and result[i] == -1:
#                 stack.append(i)
#                 continue
#             elif nums[stack[-1]] < nums[i]:
#                 while len(stack) != 0 and nums[stack[-1]] < nums[i]:
#                     result[stack.pop()] = nums[i]
#                     count += 1
#             stack.append(i)
#         if count != len(nums):
#             for i in range(len(nums)):
#                 if i == stack[-1]:
#                     return result
#                 if nums[stack[-1]] < nums[i]:
#                     while len(stack) != 0 and nums[stack[-1]] < nums[i]:
#                         result[stack.pop()] = nums[i]
#         return result
#
#
# print(Solution().nextGreaterElements([1, 2, 3, 4, 3]))
