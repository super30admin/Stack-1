#Time complexity: O(n)
#Space complexity: O(n)
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = [-1 for _ in range(n)]
        st = []

        for i in range(2*n):
            while st and nums[i%n] > nums[st[-1]]:
                res[st[-1]] = nums[i%n]
                st.pop()
            if i < n:
                st.append(i)
        return res
