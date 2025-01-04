# TC: O(n)
# SC: O(n)

def dailyTemperatures(temperatures):
    result = [0] * len(temperatures)
    stack = []

    for idx, val in enumerate(temperatures):
        while stack and val > stack[-1][0]:
            temp, i = stack.pop()
            result[i] = idx - i
        stack.append((val, idx))
    return result