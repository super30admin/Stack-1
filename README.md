# Stack-1

## Problem1 Daily Temperatures (https://leetcode.com/problems/daily-temperatures/)

# Initialize a result array of length of the temperatures array and an empty stack
# Iterate over the temperatures and append the temperatures inside the stack
# While the stack is not empty and the current temperature is greater than the popped temperature pop 
# out all the temperatures and update the result array with current index and popped element index as it
# represents the number of days
# Return the result array

## Problem2 Next Greater Element II (https://leetcode.com/problems/next-greater-element-ii/)

# Initialize an empty stack and an result array of '-1' of length of the nums array
# Iterate over the range of elements and continue until the array differences stop increasing or 
# decreasing
# When stack is not empty or current element is greater than top element in the stack update the 
# result array with the nums array element
# Return the result array with the greater elements from its neighbors