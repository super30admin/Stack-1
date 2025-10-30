# Time Complexity : O(N) where N is length of temperatures
# Space Complexity : O(1) as we are not using any extra space proportional to input size
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes

# Your code here along with comments explaining your approach:
# I am thinking this as bottom up approach. So I am starting from the end of the array.
# I will keep track of the highest temperature seen so far while traversing from the end.
# If the current temperature is greater than or equal to the highest temperature seen so far,
# I will update the highest temperature and move to the next day.
# If the current temperature is less than the highest temperature seen so far,
# I will check how many days it takes to find a warmer temperature by using the result array.
# I will keep adding the number of days until I find a warmer temperature.
# This intution helps to skip the days which are not warmer than the current day.And even use constant space which the stack approach cannot achieve.

from typing import List
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        result = [0] * n
        higher = 0
        for i in range(n-1,-1,-1):
            if higher <= temperatures[i]:
                higher = temperatures[i]
                continue
            day = 1
            while temperatures[day+i] <= temperatures[i]:
                # print(temperatures[day+i])
                day += result[day+i]
            result[i] = day
        return result
            

