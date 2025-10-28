"""
TC: O(N) {We iterate through the list of temperatures once. Each element is pushed and popped from the stack at most once.}
SC: O(N) {In the worst case, when temperatures are in decreasing order, all elements are stored in the stack. 
          We also maintain an output list of size N.}

Approach:
We use a monotonic decreasing stack to keep track of the indices and values of temperatures. 
For each day's temperature, we check if it is warmer than the temperature corresponding to the top of the stack. 
If it is, we pop elements from the stack until the current temperature is no longer warmer, 
and for each popped element, we calculate the number of days until a warmer temperature appears by subtracting indices.
We store this difference in the result list at the corresponding index.
Finally, we append the current day's temperature and index to the stack.
Once all elements are processed, we return the result list, which contains, for each day, the number of days to wait until a warmer temperature (or 0 if none).

This problem ran successfully on Leetcode.
"""
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        res = [0]*len(temperatures)
        stack = []

        for i in range(len(temperatures)):
            curr = temperatures[i]

            while stack and stack[-1]['temp'] < curr:
                head = stack.pop()
                res[head['idx']] = i - head['idx']
            
            stack.append({'temp': curr, 'idx': i})
        
        return res