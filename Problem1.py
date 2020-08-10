# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# Brute Force 
# Time = O(n^2) | Space = O(1)
# We match all elements from i to j(where j will start from i+1) and find out the first occurence of warmer day
# class Solution:
#     def dailyTemperatures(self, T):
#         if len(T) == 0:
#             return []
#         result = [0 for _ in range(len(T))]
#         for i in range(len(T)-1):
#             for j in range(i+1, len(T)):
#                 if T[j] > T[i]:
#                     result[i] = j - i 
#                     break 
                    
#         return result 
    
# Method 2) Using a Stack, we keep the track of all unresolved indices in the stack.
# when we encountered a larger temperataure day compared to the top indices of the stack, we loop till the end of 
# the stack and check all the unresolved indices and if greater then we store the difference. 
# Time = O(2n) = O(n), because of while loop we go trace back all the elements in the stack till the end | 
# Space = O(1) 
class Solution:
    def dailyTemperatures(self, T):
        if len(T) == 0:
            return []
        result = [0 for _ in range(len(T))]
        unresolved_indices = []
        for i in range(len(T)):
            while unresolved_indices and T[i] > T[unresolved_indices[-1]]:
                indx = unresolved_indices.pop()
                result[indx] = i - indx
            unresolved_indices.append(i)
        
        return result 
    
if __name__ == "__main__":
    s = Solution()
    temp = [73,74,75,71,69,72,76,73]
    
    # Test case 1
    print(s.dailyTemperatures(temp))