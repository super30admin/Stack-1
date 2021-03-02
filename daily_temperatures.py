# Brute Force Approach - For each temperature traverse the array and check which is higher temperature(warmer) get this index
# Nested loops - O(N ^ 2) Time 

# Optimized Solution - Use stack and process the temperatures in array and whenever array[i] > temp index in stack note the days corresponding in result
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        
        if not T or len(T) == 0:
            return []
        
        result = [0] * len(T)
        st = []
        
        for i in range(len(T)):
            while st and T[i] > T[st[-1]]:
                idx = st.pop()
                result[idx] = i - idx
                
            st.append(i)
            
        return result
            
            
        
# Brute Force Approach - TLE
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        if not T or len(T) == 0:
                    return []
                
                result = [0] * len(T)
                for i in range(0, len(T)):
                    for j in range(i, len(T)):
                        if T[j] > T[i]:
                            result[i] = j-i
                            break # dont need to proceed further once we find the match 
                            
                return result