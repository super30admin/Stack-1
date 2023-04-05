"""
Rasika Sasturkar
Time Complexity: O(3n) = O(n), where n is total no. of elements
Space Complexity: O(n), length of the stack
"""


def nextGreaterElements(nums):
    # null case
    if nums is None:
        return [-1]

    n = len(nums)
    result = [-1 for _ in range(n)]
    stk = []

    for i in range(2 * n):
        while stk and nums[i % n] > nums[stk[-1]]:
            curr = stk.pop()
            result[curr] = nums[i % n]
        if i < n:
            stk.append(i)
        # optimization
        if i >= n and stk[-1] == i % n:
            break

    return result


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    print(nextGreaterElements(nums=[1, 2, 1]))  # return [2, -1, 2]
    print(nextGreaterElements(nums=[1, 2, 3, 4, 3]))  # return [2, 3, 4, -1, 4]


if __name__ == "__main__":
    main()
