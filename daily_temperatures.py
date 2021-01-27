
class Solution(object):
    def dailyTemperatures(self, T):
        """
        :type T: List[int]
        :rtype: List[int]
        """
        #O(n)
        #O(n)
        ans=[0]*len(T)
        if not T:
            return []
        stack = []
        for num in range(len(T)):
            #stack stores the index which doesnt have answer yet
            #when found larger element thatn top element of stack>got the answer
            while stack and T[stack[-1]] < T[num]:
                topindex = stack.pop()
                ans[topindex] = num-topindex
            stack.append(num)
        return ans