# TC : O(n)
# SC : O(1)
class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        result = [0] * len(temperatures)
        mstack = []
        
        for i in range(len(temperatures)):
            while(len(mstack)!=0 and temperatures[mstack[-1]] < temperatures[i]):
                idx = i -  mstack[-1]                
                result[mstack[-1]] = idx
                mstack.pop()           
            mstack.append(i)
        return result
        
        
        