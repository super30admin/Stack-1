"""
Time Complexity - O(n)
Space Complexity - O(n)
"""


class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        nums += nums
        print(nums)
        out = [-1 for _ in range(len(nums))]
        st = []
        st.append(nums[-1])
        for i in range(len(nums)-2, -1, -1):
            while st and nums[i] >= st[-1]:
                st.pop()
            out[i] = st[-1] if st else -1
            st.append(nums[i])

        return out[:len(nums)//2]
