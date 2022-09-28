"""

## Problem 503: Next Greater Element II

## Author: Neha Doiphode
## Date:   09-28-2022

## Description:
    Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]),
    return the next greater number for every element in nums.

    The next greater number of a number x is the first greater number to its traversing-order next in the array,
    which means you could search circularly to find its next greater number.
    If it doesn't exist, return -1 for this number.

## Examples:
    Example 1:
        Input: nums = [1,2,1]
        Output: [2,-1,2]
        Explanation: The first 1's next greater number is 2;
                     The number 2 can't find next greater number.
                     The second 1's next greater number needs to search circularly, which is also 2.

    Example 2:
        Input: nums = [1,2,3,4,3]
        Output: [2,3,4,-1,4]

## Constraints:
    1 <= nums.length <= 104
    -109 <= nums[i] <= 109

## Time complexity: O(n), where n is length of the array.
                 At first glance, it may look like the time complexity of this algorithm should be O(n^2),
                 because there is a nested while loop inside the for loop.
                 However, each element can only be added to the stack at the max twice, which means the stack is limited to 2n pops.
                 Every iteration of the while loop uses 1 pop, which means the while loop will not iterate more than 2n times in total,
                 across all iterations of the for loop.
                 An easier way to think about this is that in the worst case, every element will be pushed and popped twice.
                 This gives a time complexity of O(4⋅n) = O(n).

## Space complexity: O(2.n) = O(n), we are using auxiliary stack to maintain monotonically increasing indices.
                 If the input was non-increasing, then no element would ever be popped from the stack,
                 and the stack would grow to a size of 2.n elements at the end.
                 Note: Result does not count towards the space complexity because space used for the output format does not count.

"""

from typing import List, Optional

def get_input():
    print("Enter integer elements in the array with spaces: ", end = "")
    try:
        elements = input()
    except KeybordInterrupt:
        pass

    elements = [int(element) for element in elements.split()]
    return elements

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        stack = []
        n = len(nums)
        result = [-1] * n

        for index in range(2 * n):
            while stack and nums[index % n] > nums[stack[-1]]:
                result[stack.pop()] = nums[index % n]
            stack.append(index % n)
            if index > n and index % n > stack[-1]:
                break
        return result


# Driver code
solution = Solution()
elements = get_input()
print()
print(f"Input: Elements array: {elements}")
print(f"Output: Next greater element II: Using Monotonic stack: {solution.nextGreaterElements(elements)}", end = "")
print()
