class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        '''
        Time Complexity: O(n)
        Space Complexity: O(n)
        '''
        o = [0 for i in range(0,len(T))]
        st = [0]
        for i in range(1,len(T)):
            if(len(st)==0 or T[st[-1]]>=T[i]):
                st.append(i)
            else:
                while(len(st)>0 and T[st[-1]]<T[i]):
                    ind = st.pop()
                    o[ind] = i-ind
                
                st.append(i)
        
        return o
