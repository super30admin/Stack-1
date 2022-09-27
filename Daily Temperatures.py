# TC: O(2n) = O(n)
# SC: O(n) when the temperatures are given in decreasing order
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        ans = [0 for _ in range(len(temperatures))]
        stack = []
        
        for i in range(len(temperatures)):
            while stack and temperatures[stack[-1]] < temperatures[i]:
                popped = stack.pop()
                ans[popped] = i - popped
            stack.append(i)
        return ans