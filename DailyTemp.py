'''
time complexity: O(n)
space complexit: O(n)
'''
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        if(len(temperatures) == 0): return [0]
        res = [0 for _ in range(len(temperatures))]
        st = []
        
        for i in range(len(temperatures)):
            while(len(st)!=0 and temperatures[st[-1]]<temperatures[i]):
                curr = st.pop()
                res[curr] = i - curr
            st.append(i)
            
        return res