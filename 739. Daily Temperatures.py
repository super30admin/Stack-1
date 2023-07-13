#Time Complexity:O(n)
#Space Complexity:O(n)

class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        if len(temperatures)==0:
            return []
        stack=[]
        result=[0 for i in range(len(temperatures))]
        for i in range(len(temperatures)):
            if len(stack)==0 or temperatures[i]<=temperatures[stack[-1]]:
                stack.append(i)
            else:
                while  len(stack)!=0 and temperatures[i]>temperatures[stack[-1]] :
                    x=stack.pop()
                    result[x]=i-x
                stack.append(i)
        return result

