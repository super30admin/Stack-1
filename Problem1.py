# Problem 1: Daily Temperatures
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        st = [(temperatures[0],0)]
        result = [0 for _ in range(n)]
        i = 1

        for i in range(1,n):
            while len(st) > 0 and temperatures[i] > st[-1][0]:
                popped = st.pop()
                result[popped[1]] = i - popped[1]

            st.append((temperatures[i],i))

        return result

        
        