'''
1. We traverse the array twice to find the next greater element.
2. For each element check if the stack is empty or not. If it is empty then push the index of the element in the stack.
3. Now if the top of the stack is less than the current element then pop the element and update the result array at the index of the popped element with the current element.
4. If we dont find any element greater in the next run, we have -1 as the value in the result array.

TC: O(n)
SC: O(n) - stack
'''

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        stack = []
        n = len(nums)

        res = [-1]*n

        for i in range(2*n):
            idx = i%n

            while stack and nums[stack[-1]]<nums[idx]:
                res[stack.pop()] = nums[idx]
            
            stack.append(idx)
        return res