# Time complexity : O(n)
# Space complexity : O(n)
# Leetcode : Solved and submitted

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        # check for null or empty case
        if not nums or len(nums) == 0:
            return []
        
        # create an array of size n with -1
        n = len(nums)
        res = [-1] * n
        st = []
        i = 1
        # append 0 index to the stack
        st.append(0)
        
        # traversing over the array twice
        while i < 2*n:
            # if we have a smaller element then the top of stack, append it to the stack
            if st and nums[i%n] < nums[st[-1]]:
                st.append(i%n)
                i += 1
            else:
                # otherwise, remove all the smaller elements and make the current greater element at those indexes
                while st and nums[st[-1]] < nums[i%n]:
                    top = st.pop()
                    res[top] = nums[i%n]
                # append the greater element to the stack
                st.append(i%n)
                i += 1
        return res
