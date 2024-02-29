#Time Complexity : O(2n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : No

from ast import List


class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        if not temperatures:
            return [0]

        stack = []
        result = [0] * len(temperatures)

        for i in range(len(temperatures)):
            while stack and temperatures[stack[-1]] < temperatures[i]:
                popped = stack.pop()
                result[popped] = i - popped
            
            stack.append(i)
        
        return result
