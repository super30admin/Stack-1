class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [-1]*n
        if not nums: return result
        st = []
        for i in range(0,2*n):
            while st and nums[i%n] > nums[st[-1]]:
                popped = st.pop()
                result[popped] = nums[i%n]
            if i < n:
                st.append(i)
        return result
