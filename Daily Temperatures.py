#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        results = [0] * len(temperatures)
        stack = []
        for i,t in enumerate(temperatures):
            while stack and t>stack[-1][0]:
                stackT,stackInd = stack.pop()
                results[stackInd] = i - stackInd
            stack.append((t,i))
        return results