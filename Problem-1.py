'''
    Time Complexity: O(n)
    Space Complexity: O(n)
'''
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        answers = [0 for _ in range(n)]
        stack = []

        for i in range(n):
            while len(stack) and stack[-1][0] < temperatures[i]:
                topIdx = stack[-1][1]
                answers[topIdx] = i - topIdx
                stack.pop()

            stack.append((temperatures[i], i))

        return answers