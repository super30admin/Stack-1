// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
In this problem also we use the monotonic stack logic.we compare the current element with the top element in the stack.If it is greater then we pop the top element from the stack and use the popped index to place the our current element in a new array.As we are doing on a circular array we run it for twice the length of the size of the array and we use modulus operator to make sure it doesnot go out of bounds.


# Time complexity --> o(n)
# space complexity --> o(n)
class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        stack=[]
        stack.append(0)
        n=len(nums)
        result=[-1 for i in range(len(nums))]
        #we do it for twice the lenth as it is a circular array
        for i in range(1,2*n):
            while len(stack)!=0 and nums[i%n]>nums[stack[-1]]:
                index=stack.pop()
                result[index]=nums[i%n]
            stack.append(i%n)
        return result