"""
We will be looping through the elements and add the elements to a stack if its value is more than the next incoming element
Once a greater element is found, we pop the index from the stack and put the greater element at that index

In the first iteration, we may miss out on some elements because of the circular nature of the array.
These elements will already be in the stack after the first pass.
HEnce We will have to loop through the array again to find the grater elements of the ones which are left. We dont have to add the previosly resolved elements again to the stack in the second pass

TC = O(n)
SC = O(n)

"""

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        stack = []
        n = len(nums)
        result = [-1]*n
        
        for i in range(2*n):
            while stack and nums[stack[-1]]<nums[i%n]:
                result[stack.pop()]= nums[i%n]
            if i<n:
                stack.append(i)
                
        return result
        

