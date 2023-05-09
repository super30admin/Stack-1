class Solution:
    # create a stack and keep on adding elem indices into it.Whenever the current element is greater than elem in the stack, store the diff of indices in result and pop from stack
    #TC-O(2n),SC-O(n)
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        st = []
        res = [0 for i in range(len(temperatures))]
        for i in range(len(temperatures)):
            while(len(st)!=0 and temperatures[st[-1]]<temperatures[i]):
                u = st.pop(-1)
                res[u]=i-u
            st.append(i)
        return res
            

