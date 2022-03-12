
"""
time: O(N)
space: O(N)

"""

class Solution:

    def dailyTemperatures(self, temp: List[int]) -> List[int]:
        res = [0] * len(temp)
        stack = [0]
        
        for idx in range(len(temp)):
            
            while stack and temp[idx] > temp[stack[-1]]:
                poppedIdx = stack.pop()
                res[poppedIdx] = idx - poppedIdx
                
            stack.append(idx)
        
        return res