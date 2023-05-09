class Solution:
    # Time O(2N)
    # Space O(N)
    def dailyTemperatures(self, temps: List[int]) -> List[int]:
        st = []
        # st.append([temps[0], 0])
        for i in range(len(temps)):
            if st and temps[i] > st[-1][0]:
                while st and temps[i] > st[-1][0]:
                    temp, idx = st.pop()
                    temps[idx] = i - idx

            st.append([temps[i], i])
        while st:
            temp, idx = st.pop()
            temps[idx] = 0
        return temps






