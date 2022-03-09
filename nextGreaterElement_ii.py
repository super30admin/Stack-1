class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        stack = []
        n = len(nums)
        result = [-1 for x in nums]
        if len(nums) == 0:
            return result
        
        for i in range( 2 * len((nums))):
            while (len(stack) != 0 and nums[i%n] > nums[stack[len(stack) - 1]]):
                popped = stack.pop()
                result[popped] = nums[i % n]
            if i < n:
                stack.append(i)
        return result