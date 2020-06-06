class RandomPickWithWeight {
    int[] cumulativeWeights;
    int max;
    
    public Solution(int[] w) {
        cumulativeWeights = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            max += w[i];
            cumulativeWeights[i] = max;
        }
    }
    
    public int pickIndex() {
        int num = (int) (Math.random() * max);
        num = num+1;
        int l = 0;
        int r = cumulativeWeights.length - 1;
        
        while (l < r) {
            int mid = l + (r-l)/2;
            
            if (cumulativeWeights[mid] < num)
                l = mid + 1;
            else
                r = mid;
        }
        
        return l;
    }
}
