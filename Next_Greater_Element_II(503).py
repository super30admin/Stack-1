class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if((nums is None) or (len(nums)==0)):
            return nums
        # T.C. = O(n)
        # S.C. = O(n)
        # here we use the concept of a monotonic stack
        # we keep on popping the stack until we encounter a elem that is greater than the current
        # so as to ensure that the stack is in descending order from bottom to top
        size = len(nums)
        stack = list()
        stack.append(0)
        idx = 1
        ans = [-1 for _ in range(size)]

        while idx<(size*2):
            # we go on popping the top element until the current element is greater than the top
            # element of the stack
            while len(stack)!=0 and nums[idx%size]>nums[stack[-1]]:
                ans[stack[-1]] = nums[idx%size]
                stack.pop()
            # We only push into the stack if it is out first iteration
            # Since we have already solved that during the first iteration
            if idx < size:
                stack.append(idx%size)
            idx+=1

        return ans