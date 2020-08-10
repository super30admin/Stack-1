# time complexity - O(3n) -- O(2n) to loop over each element twice, O(n) to pop elements out of stack.
# space complexity - O(2n) -- O(n) for stack (there will be maximum n elements in the stack at once.) and O(n) for the results array
# STEPS:
# traverse the elements of nums array 
# add the elements into a stack
# if the incoming element is greater than the top of the stack, keep popping the top out. Update the result at the index of the top to the incoming value.
# Traverse nums again to find greater element to the value in nums than the value at the current index.
# Did this code run on leetcode? - yes
from collections import deque
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        # length of numbers
        n = len(nums)
        s = deque()
        result = [-1] * n
        
        for i in range(2*n):
            # compare with the topmost element in the stack.
            while s and nums[s[-1]] < nums[i%n]:
                idx = s.pop()                    # pop the element
                result[idx] = nums[i%n]          # update the result
            
            if i<n:
                s.append(i)
            # print(s)
        
        return result
    

# Brute force solution
# for every elem in nums. traverse from the next position until the position of the current element (circular manner).
# update the current index of result with the value in nums.
# Time complexity - O(n^2)
# Space complexity - O(n)
# Did this code run on leetcode? - yes
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [-1] * n
        for i in range(n):
            num=nums[i]
            j=0
            while j<n:
                if nums[(j+i)%n] > nums[i]:
                    result[i] = nums[(j+i)%n]
                    break
                j+=1
                
        return result
    