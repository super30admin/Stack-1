'''
739 - Daily Temperature - https://leetcode.com/problems/daily-temperatures/
time complexity - O(N)
Approach - We are using stack to store the index of the elements, if we find next greater temp then we pop it out from the stack and append it to the resultant array.

'''
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        stack=[0]
        res=[0  for i in range(len(T))]
        for i in range(len(T)):
            while stack and T[i]>T[stack[-1]]:
                index=stack.pop()
                res[index]=i-index
            stack.append(i)
        return res
        
