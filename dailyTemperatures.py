#Time Complexity : O(N)
#Space Complexity : O(N)

def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
    if not temperatures:
        return []
    st = []
    idx = 0
    n = len(temperatures)
    output = [0] * n
    st.append(idx)
    idx += 1
    while idx < n:
        curr = temperatures[idx]
        while st and temperatures[st[-1]] < curr:
            i = st.pop()
            output[i] = idx - i
        st.append(idx)
        idx += 1
    return output