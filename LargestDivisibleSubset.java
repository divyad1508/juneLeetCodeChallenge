class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            list.add(temp);
        }


        int maxSize = Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int maxIndex = Integer.MIN_VALUE;
            int iSize = list.get(i).size();
            int localMaxSize = iSize;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] % nums[i] == 0 && list.get(j).size() >= iSize) {
                    maxIndex = j;
                    iSize = list.get(j).size();
                }
            }
            
            iSize += list.get(i).size();
            
            if (maxIndex != Integer.MIN_VALUE && iSize > localMaxSize) {
                localMaxSize = iSize;
                list.get(i).addAll(list.get(maxIndex));
            }
            
            if (localMaxSize > maxSize) {
                maxSize = localMaxSize;
                result = list.get(i);
            }

        }

        return result;
    }
}
