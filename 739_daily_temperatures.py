'''

## Problem 739: Daily Temperatures

## Author: Neha Doiphode
## Date:   09-28-2022

## Description:
    Given an array of integers temperatures represents the daily temperatures,
    return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
    If there is no future day for which this is possible, keep answer[i] == 0 instead.

## Examples:
    Example 1:
        Input: temperatures = [73,74,75,71,69,72,76,73]
        Output: [1,1,4,2,1,1,0,0]

    Example 2:
        Input: temperatures = [30,40,50,60]
        Output: [1,1,1,0]

    Example 3:
        Input: temperatures = [30,60,90]
        Output: [1,1,0]

## Constraints:
    1 <= temperatures.length <= 105
    30 <= temperatures[i] <= 100

## Time complexity: Please refer to respective doc-strings of different approaches used below.

## Space complexity: Please refer to respective doc-strings of different approaches used below.

'''

from typing import List, Optional

def get_input():
    print("Enter temperatures in the array with spaces: ", end = "")
    try:
        temperatures = input()
    except KeybordInterrupt:
        pass

    temperatures = [int(temperature) for temperature in temperatures.split()]
    return temperatures

class Solution:
    def dailyTemperatures_using_monotonic_stack(self, temperatures: List[int]) -> List[int]:
        """
        Time complexity: O(n), where n is number of temperatures.
                         At first glance, it may look like the time complexity of this algorithm should be O(n^2),
                         because there is a nested while loop inside the for loop.
                         However, each element can only be added to the stack once, which means the stack is limited to n pops.
                         Every iteration of the while loop uses 1 pop, which means the while loop will not iterate more than n times in total,
                         across all iterations of the for loop.
                         An easier way to think about this is that in the worst case, every element will be pushed and popped once.
                         This gives a time complexity of O(2⋅n) = O(n).

        Space complexity: O(n), we are using auxiliary stack to maintain monotonically increasing temperatures.
                         If the input was non-increasing, then no element would ever be popped from the stack,
                         and the stack would grow to a size of n elements at the end.
                         Note: Result does not count towards the space complexity because space used for the output format does not count.
        """
        output = [0] * len(temperatures)
        stack = []
        for current_index, current_temperature in enumerate(temperatures):
            while stack and current_temperature > temperatures[stack[-1]]:
                previous_day_index = stack.pop()
                output[previous_day_index] = current_index - previous_day_index
            stack.append(current_index)

        return output

    def dailyTemperatures_reusing_answer_information(self, temperatures: List[int]) -> List[int]:
        """
        Time complexity: O(n) , Similar to the first approach,
                         the nested while loop makes this algorithm look worse than O(n) However,
                         same as in the first approach, the total number of iterations in the while loop does not exceed n,
                         which gives this algorithm a time complexity of O(2⋅n)=O(n).

                         The reason the iterations in the while loop does not exceed n is because the "jumps" prevent an index from being visited twice.
                         If we had the example temperatures = [45, 43, 45, 43, 45, 31, 32, 33, 50],
                         after 5 iterations we would have answer = [..., 4, 1, 1, 1, 0].
                         The day at index 2 will use answer[4] to jump to the final day (which is the next warmer day),
                         and then answer[4] will not be used again.
                         This is because at the first day, answer[2] will be used to jump all the way to the end.
                         The final solution is answer = [8,1,6,1,4,1,1,1,0].
                         The 6 was found with the help of the 4 and the 8 was found with the help of the 6.

        Space complexity: O(1), As stated above, while answer does use O(n) space,
                          the space used for the output does not count towards the space complexity.
                          Thus, only constant extra space is used.
        """
        output = [0] * len(temperatures)
        hottest = 0
        n = len(temperatures)

        for current_day in range(n - 1, -1, -1):
            current_temp = temperatures[current_day]
            if current_temp >= hottest:
                hottest = current_temp
                continue

            days = 1
            while temperatures[current_day + days] <= current_temp:
                days += output[current_day + days]

            output[current_day] = days

        return output

# Driver code
solution = Solution()
temperatures = get_input()
print()
print(f"Input: Temperatures array: {temperatures}")
print(f"Output: Approach 1: Using Monotonic stack: {solution.dailyTemperatures_using_monotonic_stack(temperatures)}", end = "")
print()
print(f"Output: Approach 2: Re-using answer information: {solution.dailyTemperatures_reusing_answer_information(temperatures)}", end = "")
print()
