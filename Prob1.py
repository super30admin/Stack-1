class Solution:
    def dailyTemperatures(self, t: List[int]) -> List[int]:

        #Method 1 - Brute force - 2 pointer - TC - O(n^2)
        #Method 2 - Monotic decreasing stack - TC and SC - O(n)

        #Logic here, is to find next bigger number, if curr bigger than top, pop the top and input the difference of index between top and cur into res arrray, else keep appending the curr index on to the stack
        if not t or len(t)==0: return [0]

        st=[]
        res = [0] * len(t)
        for i in range(len(t)):
            while st and t[st[-1]]<t[i]: #if stack isn't empty and curr is bigger than top of stack, then pop it and res[pop] = i-pop else you keep appending the index into the stack
                popped=st.pop()
                res[popped]=i-popped
            st.append(i)
        return res
