"""
TC: O(N) {Each element is pushed and popped from the stack at most once in both traversal passes (the original array and the circular wrap-around check). 
          Hence, the total time complexity remains linear with respect to the number of elements.}
SC: O(N) {We use an auxiliary stack to store elements and their indices, and a result list of size N.}

Approach:
We aim to find the next greater element for each element in a circular array. To achieve this, we use a monotonic decreasing stack.
Initially, we iterate through the list `nums` from left to right. For each element, we compare it with the top of the stack:
    - If the current element is greater than the element stored at the top of the stack, we pop from the stack and update the result for that index with the current element.
    - Otherwise, we push the current element and its index onto the stack.
After the first pass, some elements may still have no greater element found due to the circular nature of the problem.
Hence, we make a second traversal through the array (using a variable `j`), treating the array as circular, to check if any earlier elements 
can serve as the next greater element for those remaining in the stack.
If during this pass, the current element is greater than the top of the stack, we again pop and update the result.

Finally, any elements still remaining in the stack have no next greater element, so their corresponding positions remain -1.

This problem ran successfully on Leetcode.
"""

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        res = [-1]*len(nums)
        stack = []

        for i in range(len(nums)):
            curr = nums[i]

            while stack and stack[-1][0] < curr:
                val, idx = stack.pop()
                res[idx] = curr
            
            stack.append((curr, i))

        j = 0
        while stack and j <= stack[-1][1]:
            curr = nums[j]

            while stack and stack[-1][0] < curr:
                val, idx = stack.pop()
                res[idx] = curr
            
            j += 1
        return res