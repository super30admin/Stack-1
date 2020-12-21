"""
Time Complexity : O(2n) 
Space Complexity : O(n) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
We use a stack here as while traversing through the array, the earlier values might not have been 
resolved and we can put them in stack. I am starting from the last element. Whenever I find a temp which is 
greater than the one on top of stack, I keep on popping unless I find a greater value, otherwise just put
in result array the difference of indices.
"""


class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        l = len(T)
        res = [0]*l
        stack = []
        for i in range(l-1, -1, -1):
            while(stack and T[i] >= T[stack[-1]]):
                stack.pop()
            if stack:
                res[i] = stack[-1]-i
            stack.append(i)
        return(res)


"""
This below code is to see which would be the warmer day on left side of the array, 
rather than right side, as we did in the question. I wrote ths code to solve that Amazon question 
where we have been given an array of heights of buildings and we have to give the number of buildings 
that we can see below our line of sight if we are standing on top of each building.
"""
# class Solution:
#     def dailyTemperatures(self, T: List[int]) -> List[int]:
#         if not T:
#             return T
#         l=len(T)
#         arr=[i for i in range(l)]
#         stack=[]
#         for i in range(l):
#             while stack and T[i]>T[stack[-1]]:
#                 stack.pop()
#             if stack:
#                 arr[i]=i-stack[-1]-1
#             stack.append(i)
#         print(arr)
