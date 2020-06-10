class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int[][] result = new int[people.length][2];
        
        Arrays.sort(people, (i1, i2) -> {
            if (i1[0] == i2[0])
                return i1[1] - i2[1];
            else
                return i2[0] - i1[0];
        });
        
        List<List<Integer>> list = new ArrayList<>();
        
        for (int i = 0; i < people.length; i++) {
            int index = people[i][1];
            int height = people[i][0];
            List<Integer> l = new ArrayList<>();
            l.add(height);
            l.add(index);
            list.add(index, l);
        }
        
        // System.out.println("list:"+list);
        
        for (int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i).get(0);
            result[i][1] = list.get(i).get(1);
        }
        
        return result;
    }
}
