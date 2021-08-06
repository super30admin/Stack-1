class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        #time: O(n)
        #space: O(n)
        if temperatures is None or len(temperatures) < 2:
            return []
        result = [0 for i in xrange(len(temperatures))]
        tempStack = []
        for i,t in enumerate(temperatures):
            while tempStack and temperatures[tempStack[-1]] < t:
                top = tempStack.pop()
                result[top] = i - top
            tempStack.append(i)
        
        return result
