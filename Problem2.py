"""
503. Next Greater Element II
Time Complexity - O(4*n) worst case
Space Complexity - O(n)
From our observation I can conclude that if we move in this array twice I will be able to get the proper next greater element for a given index.
So if last visited index value is less than the new index value then this means that current element is the next greater element for the past indexes just put the values for those indexes as current value index and for the highest element value is -1"""
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if nums == None or len(nums) == 0:
            return nums
        output = [-1]*len(nums)
        stack = []
        for i in range(0,(2*len(nums))):
            index = i % len(nums)
            while len(stack) != 0 and nums[stack[-1]] < nums[index]:
                popped = stack.pop()
                output[popped] = nums[index]
            if output[index] == -1: 
                stack.append(index)
        return output