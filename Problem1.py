#Time complexity: O(2n)
#Space complexity: O(n)
#Works on leetcode: yes
#Appraoch: We keep a stack to track all the indices while iterating through the temperatures. At each iteration, we check if
# stack is not empty and the element from T wrt index at top of stack is less than current element. We pop it from stack and
#set the ans with the i-last position. 

class Solution(object):
    def dailyTemperatures(self, T):
        """
        :type T: List[int]
        :rtype: List[int]
        """
        ans = [0]*len(T)
        stack = []
        for i, t in enumerate(T):
            
            while stack and T[stack[-1]]<t:
                
                last = stack.pop()
                ans[last] = i-last
            stack.append(i)
        return ans