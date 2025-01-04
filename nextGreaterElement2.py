# // Time Complexity :O(n); 2 pass
# // Space Complexity :O(n); worst case all items in stack
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach


class Solution:
    def nextGreaterElements(self, nums: list[int]) -> list[int]:
        n = len(nums)
        res = [-1] * n                                      # since 0 can also be a res elemnt     
        st = []

        for i in range(2*n):                                # 2 pass 

            while st and nums[i%n] > nums[st[-1]]:          # monotonically inc st pattrn
                popped = st.pop()
                res[popped] = nums[i%n]

            if i < n:                                       # only append index on 1st pass
                st.append(i%n)

        return res