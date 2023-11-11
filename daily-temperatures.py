class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        if len(temperatures) == 0:
            return [0]
        st = []
        result = [0 for i in range(len(temperatures))]

        for i in range(0,len(temperatures)):
            if i == 0: 
                st.append(i)
            while(len(st) != 0 and temperatures[st[len(st)-1]] < temperatures[i]):
                popped = st.pop()
                result[popped] = i-popped
            st.append(i)
        return result

        