# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nope


# Your code here along with comments explaining your approach

class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        res = [0 for i in range(len(T))]
        
        if not T:
            return res
        stack = []
        
        for i in range(len(T)):
            while stack and T[i] > T[stack[-1]]:
                idx = stack.pop()
                res[idx] = i - idx
            stack.append(i)
        
        return res
#BRUTE FORCE     
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        #brute force n^2
        res = []
        if not T:
            return res
        
        for i in range(len(T)):
            count = 0
            for j in range(i+1, len(T)):
                count += 1
               
                if T[i] < T[j]:
                    res.append(count)
                    break
                if j == len(T)-1:
                    res.append(0)
            
            if i == len(T)-1:
                res.append(0)
        return res