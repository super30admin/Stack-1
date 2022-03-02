class Solution:
    
    # Using Stack
    # TC: O(N) --> 4N
    # SC: O(N) --> size of stack --> N is len of nums array
    
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        
        n = len(nums)
        result = [-1 for i in range(n)]
        stack = []
        
        for i in range(2*n):
            while (len(stack) != 0 and nums[i%n] > nums[stack[-1]]):
                popped = stack.pop()
                if popped == i%n:
                    return
                result[popped] = nums[i%n]
            if (i < n):
                stack.append(i)
                
        return result