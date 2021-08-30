class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        
        N = len(temperatures)
        stack, answer = [], [0 for _ in range(N)]
        for index, value in enumerate(temperatures):
            while stack and stack[-1][1] < value:
                i = stack.pop()[0]
                answer[i] = index-i
            stack.append((index, value))
        return answer
