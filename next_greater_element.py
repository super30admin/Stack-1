
class Solution:
   def nextGreaterElements(self, nums: List[int]) -> List[int]:
   # monotonic stack problem since if we find atleast 1 element greater then all the previous elements
   # which are lesser will also get updated
   # even though its a circular array we only need to repeat the array one more time only.


   # Need to think about the different scenarios and we will get the answer
   # 5,4,3,2,1    1,2,3,5,4 etc

       result = [-1 for i in range(len(nums))]
       stack = [] #will hold indices
       i = 0

       while i < 2*len(nums):
           while stack and nums[i%len(nums)] > nums[stack[-1]]:
               index = stack.pop()
               result[index] = nums[i%len(nums)]
          
           stack.append(i%len(nums))
           i += 1
      
       return result

