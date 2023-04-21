 # Time Complexity : O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :No
#
#
# // Your code here along with comments explaining your approach

 class Solution:
     def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
         stack = []
         result = [0] * len(temperatures)
         # print(result)
         for i in range(len(temperatures)):
             while stack and temperatures[i] > temperatures[stack[-1]]:
                 index = stack.pop()
                 result[index] = i - index
             stack.append(i)

         return result