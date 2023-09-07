class Solution:
    # Time Complexity: O(n)
    # Space Complexity: O(n)
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        result = len(temperatures) * [0]
        for i in range(len(temperatures)):
            while stack and temperatures[i] > temperatures[stack[-1]]:
                k = stack.pop()
                result[k] = i - k
            stack.append(i)
        return result
