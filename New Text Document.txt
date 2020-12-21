#timecomplexity  O(2N)= O(n)
#space complecxity o(n) stack size
# in for looping chking if the curr value is greater then the top index value of stack 
# it means we find out the next greater temp and storing the diff  the respective index https://leetcode.com/problems/daily-temperatures/
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        if T==[] or len(T)==0: return  [0]
        result=[0 for _ in range(len(T))]
        st=[]
        for i in range(len(T)):
            while(st!=[] and T[i]>T[st[len(st)-1]]):
                id=st.pop()
                #print(id)
                result[id]=i-id
            st.append(i)
        return result