#As taught in class, using stack to push lesser tempeerature index and then keep popping until you find the greater eleement to calculate the next higher tempeerature
#Time complexity: O(2n)
#Space Complexity :O(n)
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        if T is None or len(T)==0:
            return [0]
        result = [0]*len(T)
        st = list()
        for i in range(len(T)):
            while len(st)!=0 and T[i] > T[st[-1]]:
                idx = st.pop()
                result[idx] = i - idx
            st.append(i)
        return result