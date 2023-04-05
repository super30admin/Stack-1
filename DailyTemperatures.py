"""
Rasika Sasturkar
Time Complexity: O(2n) = O(n), where n is total no. of temperatures
Space Complexity: O(n), length of the stack
"""


def dailyTemperatures(temperatures):
    # null case
    if temperatures is None:
        return [0]

    n = len(temperatures)
    result = [0 for _ in range(n)]

    temp_stk = []
    for i in range(n):
        while temp_stk and temperatures[i] > temperatures[temp_stk[-1]]:
            idx = temp_stk.pop()
            result[idx] = i - idx
        temp_stk.append(i)

    return result


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    print(dailyTemperatures(temperatures=[73, 74, 75, 71, 69, 72, 76, 73]))  # return [1, 1, 4, 2, 1, 1, 0, 0]
    print(dailyTemperatures(temperatures=[30, 40, 50, 60]))  # return [1, 1, 1, 0]
    print(dailyTemperatures(temperatures=[30, 60, 90]))  # return [1, 1, 0]


if __name__ == "__main__":
    main()
