class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        # tc O(n), sc O(n), great solution, without use of monotonous stack.
        res = [0] * len(temperatures)

        for i in range(len(temperatures)-2, -1, -1):
            j = i + 1
            while temperatures[j] <= temperatures[i]:
                if res[j] == 0:
                    j = i
                    break
                
                j = j + res[j]
            
            res[i] = j - i
        
        return res
