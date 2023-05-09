class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        # Time O(3n)
        # Space O(1)
        result = [-1 for i in range(len(nums))]
        st = []
        # st.append([nums[0], 0])
        n = len(nums)
        for i in range(2 * n):
            if st and nums[i % n] > st[-1][0]:
                # print("here")
                while st and nums[i % n] > st[-1][0]:
                    num, idx = st.pop()
                    result[idx] = nums[i % n]
            if i < n:
                st.append([nums[i], i])
                # print(st)

        return result