"O(N)/O(N)"
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        ans = [0 for _ in temperatures]
        stack = []
        for idx, temp in enumerate(temperatures):
            while stack and stack[-1][0] < temp:
                    curr_temp, curr_idx = stack.pop()
                    ans[curr_idx] = idx - curr_idx
            stack.append([temp,idx])
        return ans
        
