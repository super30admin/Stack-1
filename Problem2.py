class Solution:
    
    """
        
        Name : Shahreen Shahjahan Psyche
        Time : O(N)
        Space: O(N) [Stack as Auxiliary Space]
        
        Passed All Test Cases : Yes
        
        Approach : # First, I have found the maximum value. In an array of numbers, there should always be a maximum value.[I am finding maximum value as I will 
                     start iterating from the neext place of the peak value and when I again come to the peak that means I cannot any eelement greater than that.
                     So, I can stop my iteration.]
                   # Then, I start iterating from the next position of the max value. If the stack is empty then I push the current value with its index in the 
                     Stack. Otherwise, I check whether my peak value is less than the current value and if yes I pop the value and go to its index in the result 
                     array and replace the value with the current value. Doing this step until the peak value is less than the current value.
                   # Finally, if the stack is not empty, then I am popping all the values and if any of them is less than the max valuee, I am assigning the corr-
                     sponding index's value to max value.
    
    """
    
    
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        # edge case
        if not nums:
            return []
        
        # initilizing output array and stack 
        res = [-1 for _ in range(len(nums))]
        stack = []
        i = 0
        max_val = (float('-inf'), -1)
        
        # finding the max value and its index to get the ending point
        for i in range(len(nums)):
            if nums[i] > max_val[0]:
                max_val = (nums[i], i)
        
        end = max_val[1]
        # boundary check
        if end + 1 >= len(nums):
            start = 0
        else:
            start = end + 1
        
        # start iterating the array
        while start != end:
            if len(stack) == 0:
                stack.append((nums[start], start))
            else:
                # while stack is not empty and the peek value is smaller than thee curr value
                while len(stack) != 0 and stack[-1][0] < nums[start]:
                    curr = stack.pop()
                    res[curr[1]] = nums[start]
                stack.append((nums[start], start))
            if start + 1 >= len(nums):
                start = 0
            else:
                start += 1
        
        # if any remaining value is left in stack which is smaller than the max value, that should get assigned with the max value
        while len(stack) != 0:
            curr = stack.pop()
            if curr[0] < max_val[0]:
                res[curr[1]] = max_val[0]
        
        return res
                    
        
        
        
        
        
        
