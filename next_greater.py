# Time Complexity :
# O (N)

# Space Complexity :
# O(1)

# Did this code successfully run on Leetcode :

#We store a monotonically increasing stack. 
#we go through each element twice by doing 2 forward passes on the nums array
#Every time we come across an element greater than the top element of the stack, then we keep popping the elements until a greater element is found and at the popper index, we can new element that is greater than current element
# After the above process, we add the current element to the stack if that position has not already been processed
#Yes

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        stack = collections.deque()

        result = [-1] * len(nums)
        n = len(nums)

        for i in range(2 *len(nums)):
            while len(stack) != 0 and nums[i%n] > nums[stack[-1]%n] :
                old_index = stack.pop()
                result[old_index%n] = nums[i%n]

            if result[i%n] != -1 :
                continue 
            stack.append(i)

        return result
