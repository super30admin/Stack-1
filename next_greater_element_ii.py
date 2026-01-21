# https://leetcode.com/problems/next-greater-element-ii/

# Time Complexity- O(n) Space Complexity- O(n)

class Solution:
    def nextGreaterElements(self, nums: list[int]) -> list[int]:
        n = len(nums)
        # initialise a result set
        result = [-1] * n
        # initialise a stack
        st = []

        # iterate through the nums array twice as it's a cicular array
        for i in range(2 * n):
            # compare the current num with the last value in the stack till the stack is not becomes empty
            while st and nums[i % n] > nums[st[-1]]:
                # pop the element
                popped = st.pop()
                # add the result array with the popped element
                result[popped] = nums[i % n]
            # check the condition if the element is resolved in the stack
            if i < n:    
                # push into the stack only if it resovled
                st.append(i)
        
        return result

solution = Solution()
print(solution.nextGreaterElements([1,2,1]))