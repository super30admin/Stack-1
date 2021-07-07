
# STACK approach        (storing -- unresolved elements in stack)
# time : O(2N), better than bruteforce O(N*N) 
# space : O(1) 
# run on leetcode: yes


class Solution:
    def dailyTemperatures(self, T):
        result = [0]*len(T)

        # EDGE CASE
        if T == [] or len(T) == 0:
            return result

        st = [0]
        for i in range(0, len(T)):
            while st != [] and T[i] > T[st[-1]]:
                idx = st.pop()
                result[idx] = i - idx 
            st.append(i)
        return result


        
obj = Solution()
print(obj.dailyTemperatures(T = [73, 74, 75, 71, 69, 72, 76, 73]))
