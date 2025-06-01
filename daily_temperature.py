class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        n=len(temperatures)
        stack = []
        count_days = [0]*n

        for i in range(n): 
            while stack and temperatures[i]>temperatures[stack[-1]]:
                index = stack.pop()
                count_days[index] = i - index
            
            stack.append(i)

        return count_days
