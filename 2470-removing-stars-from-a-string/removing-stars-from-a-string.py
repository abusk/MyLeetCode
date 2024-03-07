class Solution:
    def removeStars(self, s: str) -> str:
        st = []
        for i in range(len(s)):
            if s[i] != '*':
                st.append(s[i])
            elif st:
                st.pop()
        return ''.join(st)
        