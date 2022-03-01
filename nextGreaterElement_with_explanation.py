class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        '''
        https://www.youtube.com/watch?v=Du881K7Jtk8
        Algorithm:
        iterate over the nums from right ot left
        while the stop of the stack is lesser than the current element, 
        keep removing those from the stack
        when the top of the stack becomes greater than the current element, 
        update the curr index with the top of the stack and
        push the current element into the stack and 
        '''
        n = len(nums)
        result = [-1]*n
        if not nums: return result
        stack = []
        for i in range(2*n,-1,-1):
            while stack and stack[-1] <= nums[i%n]:
                stack.pop()
            if i < n:
                if stack:
                    result[i] = stack[-1]
                else:
                    result[i] = -1
            stack.append(nums[i%n])
        return result 
