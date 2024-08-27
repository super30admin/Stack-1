#// Time Complexity : O(n) 
# // Space Complexity : O(n)   
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        result = [0] * len(temperatures)
        stack = [0]
        for i in range(1,len(temperatures)):
            while stack and temperatures[i] > temperatures[stack[-1]]:
                popped = stack.pop()
                result[popped] = i - popped
            stack.append(i)    
            
        return result

# Approach:
# 1. Initialize a result list with the same length as the input list, filled with zeros. This
# list will store the number of days until a warmer temperature is seen for each day.
#     2. Initialize a stack with the index 0, which represents the first day.
# 3. Iterate over the input list starting from the second day (index 1).
# 4. For each day, check if the current temperature is greater than the temperature at the
# top of the stack. If it is, pop the top of the stack and update the result list
# 5. Push the current day's index onto the stack.
# 6. Return the result list.