# o(N) time N - number of items/elements in the temperatures array
#O(n) space, space we use for the stack

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        result = [0 for x in range(len(temperatures))]
        stack = []
        for i in range(len(temperatures)):
            while stack and temperatures[i] > temperatures[stack[-1]]:
                print(temperatures[stack[-1]])
                popped = stack.pop()
                result[popped] = i - popped
            stack.append(i)
        return result
            