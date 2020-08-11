"""
// Time Complexity :o(n)
// Space Complexity : o(n), stack size
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        res = [0] * len(T)
        st = []
        
        for i in range(len(T)):
            if not st: #add first element to stack
                st.append(i)
            
            else:
                while st and T[i] > T[st[-1]]: #pop and process all the elements in the stack that are lesser than the current temperature
                    idx = st.pop()
                    res[idx] = i - idx #difference of the index will givw the number of days
                    
                st.append(i) #add current value to stack to process in the following steps, for days which will be unprocessed in the end the value will 0 in res
                
        return res
                