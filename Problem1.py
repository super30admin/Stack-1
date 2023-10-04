'''
1. Store the index of the temperature in the stack.
2. If the temperature of the previous day is less than current, it means we found a future day.
3. Store in result the difference between the current index and the index of the temperature which is higher as it gives the number of days.

TC: O(n)
SC: O(n) - stack
'''

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        # Store the future day as 0 default for all days
        result = [0]*len(temperatures)
        # Traverse through the temperatures list
        for index,temp in enumerate(temperatures):

            # If the temperature of the previous day is less than current, it means we found a future day.  
            #   Update the temperatures  
            while(stack and temperatures[stack[-1]] < temp):
                # Pop the top element to calculate the 
                current = stack.pop()
                result[current] = index - current
            # Store the index of the temperature which is higher than the stack's top element 
            stack.append(index)
        return result

