#Approach
# maintain a stack and if incoming element in greater than stack.peek() resolve the stack or else append to the stack.


#Complexities
#Time: O(n)
#Space: O(n)


from typing import List


class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        result = [-1] * len(nums)
        stack = []
        for i in range(len(nums)):
            while stack and nums[i] > stack[-1][0]:
                num, index = stack.pop()
                result[index] = nums[i]
            stack.append((nums[i], i))

        for i in range(len(nums)):
            while stack and nums[i] > stack[-1][0]:
                num, index = stack.pop()
                result[index] = nums[i]
            if len(stack) == 1:
                break

        return result


s= Solution()
s.nextGreaterElements([1,2,1])