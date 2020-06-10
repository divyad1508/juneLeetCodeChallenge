class Solution {
    public boolean isPowerOfTwo(int n) {
        
        if (n == 1)
            return true;
        
        double num = n;
        
        while (num > 0) {
            num = num/2;
            if (num == 1.0)
                return true;
        }
        
        return false;
    }
}
