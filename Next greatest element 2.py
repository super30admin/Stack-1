#2nd and 3rd written by me
# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def nextGreaterElements(self, nums):
        if nums==None or len(nums)==0: return None
        n=len(nums)
        result=[-1]*n
        stack=[]
        for i in range(2*len(nums)):
            k=i%n
            # if incomming and top of stack elements are same we can stop the iterations
            if len(stack)!=0 and stack[len(stack)-1]==k:
                return result
            while len(stack)!=0 and nums[stack[len(stack)-1]]<nums[k]:
                cur=stack.pop()
                result[cur]=nums[k]
            if i<n:
                stack.append(i)
        return result

# class Solution(object):
#     def nextGreaterElements(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: List[int]
#         """
        
#         if nums==None or len(nums)==0: return None
#         i=0
#         nums=[nums[i] for i in range(len(nums)),nums[i] for i in range(len(nums))]
#         n=len(nums)
#         arr=[-1 for i in range(n)]
#         stack=[]
#         stack.append(0)
#         for i in range(1,n):
#             while(len(stack)!=0 and nums[i]>nums[stack[len(stack)-1]] ):
#                 k=stack.pop()
#                 arr[k]=nums[i]
#             stack.append(i)
#         return arr[:n/2]



# Time Complexity: O(n)
# Space Complexity: O(n)
# class Solution(object):
#     def nextGreaterElements(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: List[int]
#         """
        
#         if nums==None or len(nums)==0: return None
#         i=0
        
#         n=len(nums)
#         arr=[-1 for i in range(n)]
#         stack=[]
#         stack.append(0)
#         for i in range(1,n):
#             while(len(stack)!=0 and nums[i]>nums[stack[len(stack)-1]] ):
#                 k=stack.pop()
#                 arr[k]=nums[i]
#             stack.append(i)
#         for i in range(0,n):
#             while(len(stack)!=0 and nums[i]>nums[stack[len(stack)-1]] ):
#                 k=stack.pop()
#                 arr[k]=nums[i]
#             stack.append(i)
#         return arr