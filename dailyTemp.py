#Time complexity: O(n^2)
#Space complexity: O(n)
class Solution:
    def dailyTemperatures(self, temp: List[int]) -> List[int]:
        
        i = 0
        j = 1
        n = len(temp)
        res = []
        while i < n:
            curr = temp[i]
            j = i + 1
            while  j< n and curr >= temp[j]:
                j += 1
            if j == n:
                res.append(0)
            else:
                res.append(j-i)
            i += 1
        return res
#Time complexity: O(n)
#Space complexity: O(n)
class Solution:
    def dailyTemperatures(self, temp: List[int]) -> List[int]:
        st = []
        res = [0 for _ in range(len(temp))]
        for curr in range(len(temp)):
            while st and  temp[curr] > temp[st[-1]]:
                res[st[-1]] = curr - st[-1]
                st.pop()
            st.append(curr)
        return res
            
        
       
            
        
