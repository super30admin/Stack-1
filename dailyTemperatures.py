"""
Time complexity O(2N) 
Space complexity O(N) - stack 

The stack will have indexes and index of the temperature is pushed onto stack if it less than the top ele of the stack. 

"""


class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        if not T:
            return [0]
        res=[0]*len(T)
        st=[] #you push indexes
        for i in range(len(T)):
            #with same i , trying to resolve element in the top of stack to see if there is warmer day
            while (len(st)!=0 and T[i]>T[st[-1]]):  
                idx=st.pop()
                res[idx]=i-idx
            st.append(i)
        return res
                
        
        