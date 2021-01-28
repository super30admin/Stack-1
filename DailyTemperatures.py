# TC: O(n)
# SC: O(n)
# LeetCode: Y(https://leetcode.com/problems/daily-temperatures/)
# Approach: Use a stack as it is a Last-In-First-Out DS
#           Iterate over the temeratures array and store all the indicies of days whose nearest hottest day is still not known
#           As soon as a temperature higher than temperature of top of the stock day, pop and update the result for that day
#           Continue this process till the stack is empty

class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        
        # Initialize result array
        days = [0 for _ in range(len(T))]
        
        # Initialize stack
        stack = []
        
        # Traverse the given temperature array
        for day, temperature in enumerate(T):
            # check if the temperature on current day is higher than the day on top of stack
            while(stack and temperature > T[stack[-1]]):
                # update the difference of days 
                days[stack.pop()] = day - stack[-1]
            
            # push the current day on the top of the stack
            stack.append(day)
        
        
        return days
