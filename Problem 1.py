# Time: O(n)
# Space: O(1)
class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        ans = [0]*len(temperatures)
        stack = []
        i = 0
        while i < len(temperatures):
            if len(stack) == 0 or temperatures[stack[-1]] >= temperatures[i]:
                stack.append(i)
            else:
                while len(stack)!= 0 and temperatures[stack[-1]] < temperatures[i]:
                    curr = stack.pop()
                    ans[curr] = i-curr
                stack.append(i)
                    
            
            i += 1
        return ans
                
        
