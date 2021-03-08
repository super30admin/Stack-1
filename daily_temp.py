'''
# Time complexity - O(N) : N is no.of temperatures  
# Space Complexity: O(N) : N is no.of temperatures
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this:None
# Approach : Traverse list from left to right,check for which index it is larger than stack and update it accordingly.
'''
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        result =  [0]*len(T)
        if T is None or len(T)==0:
            return result
        stack = []
        for i in range(len(T)):
            while(len(stack)>0 and T[i]>T[stack[-1]]):
                idx = stack.pop()
                result[idx] = i - idx
                
            stack.append(i)
        
        return result