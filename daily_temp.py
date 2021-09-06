#Time complexity : O(N)
#Space complexity : O(N) 

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        result = [0]*n
        stack = []
        stack.append(0)
        for index in range(1,n):
            item = temperatures[index]
            while(stack and item>temperatures[stack[-1]]):
                ind = stack.pop()
                result[ind] = index-ind
            stack.append(index)
            
        return result
            
        