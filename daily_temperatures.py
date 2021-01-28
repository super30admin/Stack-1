class Solution(object):
    def dailyTemperatures(self, T):
        """
        :type T: List[int]
        :rtype: List[int]
        """
        """"
        #solve that Amazon question 
where we have been given an array of heights of buildings and we have to give the number of buildings 
that we can see below our line of sight if we are standing on top of each building.""""
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
            print(stack)
        return ans