#Time Complexity:O(n)
#Space Complexity:O(n)
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        if len(T)==0:
            return []
        result=[0 for i in range(len(T))]                   #for create a resultant output array
        st=[]                                               #create a arry to implement stack
        for i in range(len(T)):
            while st and T[i]>T[st[-1]]:                    #parse through the temp array and compare current element to top of stack
                pos=st.pop()                                #if current element larger than top of stack add diff to resultant array at current position
                result[pos]=i-pos
            st.append(i)                                    #push the i th index to the stack for further processing
        return result