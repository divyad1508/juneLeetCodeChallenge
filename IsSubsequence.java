class Solution {
    public boolean isSubsequence(String s, String t) {
        boolean isSubsequence = false;
        
        if (s.length() == 0)
            return true;
        
        if (t.length() == 0 && s.length() != 0)
            return isSubsequence;
        else if (t.length() == 0 && s.length() == 0)
            return true;
        
        int i = 0;
        int idx = 0;
        int count = 0;
        while (idx < t.length()) {
            if (i >= s.length())
                break;
            char ch = s.charAt(i);
            char c = t.charAt(idx);
            
            if (ch == c) {
                count++;
                i++;
            }
            
            idx++;
        }
        
        if (count == s.length())
            isSubsequence = true;
        
        return isSubsequence;
    }
}
