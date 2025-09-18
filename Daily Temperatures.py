#  Time Complexity : O(n) 
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : This code solves the Daily Temperatures problem efficiently by scanning from right to left. It keeps track of the hottest temperature seen so far; if the current temperature is less than that, it jumps ahead using previously computed results (result[i + days]) to skip unnecessary checks until it finds a warmer day. The result array stores how many days one must wait for a warmer temperature at each index, with 0 meaning no warmer day exists.

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]: 
        n = len(temperatures)
        result = [0] * n
        hottest = 0

        for i in range(n - 1, -1, -1):
            if temperatures[i] >= hottest:
                hottest = temperatures[i]
                continue

            days = 1
            while temperatures[i + days] <= temperatures[i]:
                days += result[i + days]
            
            result[i] = days
        
        return result