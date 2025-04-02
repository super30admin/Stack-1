#time complexity o(n)
#space complexity o(n)
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        st = []
        result = [-1] * n
        for i in range(2*n):
            while st and nums[i%n] > nums[st[-1]]:
                popped = st.pop()
                result[popped] = nums[i%n]
            if i < n:
                st.append(i)
        return result
        