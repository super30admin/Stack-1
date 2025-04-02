#time complexity o(n)
#space complexity o(n)
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        st = []
        n = len(temperatures)
        result = [0] * n
        for i in range(n):
            curr = temperatures[i]
            while st and curr > temperatures[st[-1]]:
                popped = st.pop()
                result[popped] = i - popped
            st.append(i)

        return result
        