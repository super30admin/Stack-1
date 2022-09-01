# Time Complexity: O(N)
# Space COmplexity: O(1)

# Monotonic Increasing Stack

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        # base
        if temperatures is None:
            return None
        
        if len(temperatures) == 1:
            return [0]

        # logic
        monotonic_stack = []
        result = []
        for i in range(len(temperatures)):
            while monotonic_stack and temperatures[i] > temperatures[monotonic_stack.peek()]:
                idx = monotonic_stack.pop()
                result[idx] = i - idx
            monotonic_stack.push(i)
        
        return result
