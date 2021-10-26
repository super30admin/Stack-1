# // Time Complexity :O(2n) 
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach



class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        st=[]
        st.append(0)
        result=[0 for i in range(len(temperatures))]
    
        for i in range(len(temperatures)):
        
            while st and temperatures[st[-1]]<temperatures[i]:
                    top=st.pop()
                    result[top]=i-top
            st.append(i)
        return result