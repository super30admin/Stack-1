"""
Approach: Using stack

This approach makes use of a stack. This stack stores the indices of the appropriate elements from numsnums array. The top of the stack refers to the index of the Next Greater Element found so far. We store the indices instead of the elements since there could be duplicates in the numsnums array. The description of the method will make the above statement clearer.

We start traversing the numsnums array from right towards the left. For an element nums[i] encountered, we pop all the elements stack[top] from the stack such that nums[stack[top]] ≤ nums[i]. We continue the popping till we encounter a stack[top] satisfying nums [stack[top]] > nums[i] nums[stack[top]]>nums[i]. Now, it is obvious that the current stack[top]stack[top] only can act as the Next Greater Element for nums[i]nums[i](right now, considering only the elements lying to the right of nums[i]nums[i]).

If no element remains on the top of the stack, it means no larger element than nums[i]nums[i] exists to its right. Along with this, we also push the index of the element just encountered(nums[i]nums[i]), i.e. ii over the top of the stack, so that nums[i]nums[i](or stack[topstack[top) now acts as the Next Greater Element for the elements lying to its left.

We go through two such passes over the complete numsnums array. This is done so as to complete a circular traversal over the numsnums array. The first pass could make some wrong entries in the resres array since it considers only the elements lying to the right of nums[i]nums[i], without a circular traversal. But, these entries are corrected in the second pass.

Further, to ensure the correctness of the method, let's look at the following cases.

Assume that nums[j]nums[j] is the correct Next Greater Element for nums[i]nums[i], such that i < j ≤ stack[top]. Now, whenever we encounter nums[j]nums[j], if nums[j] > nums\big[stack[top]\big]nums[j]>nums[stack[top]], it would have already popped the previous stack[top]stack[top] and jj would have become the topmost element. On the other hand, if nums[j] < nums\big[stack[top]\big]nums[j]<nums[stack[top]], it would have become the topmost element by being pushed above the previous stack[top]stack[top]. In both the cases, if nums[j] > nums[i]nums[j]>nums[i], it will be correctly determined to be the Next Greater Element.

TC: O(n)
SC:  O(n)
"""

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if nums == None or len(nums) == 0:
            return []
        n = len(nums)
        ans = [-1 for i in range(n)]
        stack = []

        for i in range(2 * n):
            while len(stack) and nums[i % n] > nums[stack[-1]]:
                idx = stack.pop()
                ans[idx] = nums[i % n]        
            if i < n:
                stack.append(i)
        
        return ans
            
            
        