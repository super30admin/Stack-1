# Problem 1 - Daily Temperatures
## Time Complexity :
O(n)

## Space Complexity :
O(n)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No.

## Your code here along with comments explaining your approach
### Solution:
      class Solution:
          def dailyTemperatures(self, T: List[int]) -> List[int]:
              stack=[]
              result=[0]*len(T)
              stack.append(0)
              for index in range(len(T)):
                  while len(stack)!=0 and T[index]>T[stack[-1]]:
                      priorIndex=stack.pop()
                      result[priorIndex]=index-priorIndex
                  stack.append(index)
              return result


  # Problem 2 - Next Greater Element II
## Time Complexity :
O(n)

## Space Complexity :
O(n)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No.

## Your code here along with comments explaining your approach
### Solution:    
      class Solution:
          def nextGreaterElements(self, nums: List[int]) -> List[int]:
              stack=[]
              stack.append(0)
              n=len(nums)
              result=[-1]*len(nums)
              for i in range(1,2*n):
                  while len(stack)!=0 and nums[i%n]>nums[stack[-1]]:
                      index=stack.pop()
                      result[index]=nums[i%n]
                  stack.append(i%n)
              return result 
