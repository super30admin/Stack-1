#---------Time - O(n) + O(n) = O(n), Space = O(n)
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        n = len(temperatures)
        result = [0 for _ in range(n)]
        for i in range(n):
            while stack and temperatures[stack[-1]] < temperatures[i]:
                popped_idx = stack.pop()
                result[idx] = i - popped_idx
            stack.append(i)
        return result
        