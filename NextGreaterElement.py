Next Greater Element II
Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

Example 1:

Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number; 
The second 1's next greater number needs to search circularly, which is also 2.


Time  complexity O(n) | Space complexity O(n)

class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
 
        stack = []
        n = len(nums)
        result = [-1]*n
        #Monotonic stack we are comapring with the elements in the array with the stack element since we are asked to do circularly
        # we are multipying with 2 for two pass
        for index in range(n*2):
         # if its less than the stack element we are poping it,we use module to iterate circularly
            while stack and nums[index%n] > nums[stack[-1]]:
                priorIndex = stack.pop()
                 #calculating the index value
                result[priorIndex] = nums[index%n]
                
            #if the stack is empty keep adding,this condition index < n is we are stopping the elements to add for the next pass
            #in order to reduce time even though the complexity wont change
            if index < n:
                stack.append(index%n)
        return result
                                                           
                                                           
  
	
