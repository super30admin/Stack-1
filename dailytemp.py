# using stacks
# time complexity - O(2n) -- since every element is being compared one other element in nums.
# space complexity - O(2n) -- O(n) for deque and O(n) for result.
# Did this code run on leetcode? - yes
# STEPS:
# 1. traverse the temp array.
# 2. if the temp is less than the top on the stack, pop it. and update the result with the value equal to distance between the incoming element and the value of the top.
# 3. add the current index to the top.
# 4. return the result.
from collections import deque

class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        # no of days
        n = len(T) 
        res = [0] * n
        s = deque()
        
        for i, temp in enumerate(T):        # O(n) time
            while s and T[s[-1]] < temp:    # worst case - O(n)
                top = s.pop()
                res[top] = i-top
                    
            s.append(i)   
            
        return res
            
# brute force solution
# from every index i, start a new pointer j.
# traverse j till the end of the array, and if the element at j is greater than the element at index i, update the distance.
# time complexity - O(n^2)
# space complexity - O(n) -- results array
# did this code run on leetcode? - no (TLE)
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        n = len(T)
        res = [0] * n
        for i, temp in enumerate(T):
            j = i+1
            while j<n:
                if T[j] > T[i]:
                    res[i] = j-i 
                    break
                j+=1
        return res
    