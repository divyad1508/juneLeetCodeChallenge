class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        
        Map<Integer, List<Pair>> adjList = new HashMap<>();
        
        for (int i = 0; i < flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int w = flights[i][2];
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.get(u).add(new Pair(v, w, 0));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());
        pq.offer(new Pair(src, 0, -1));
        
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            
            if (p.v == dst) {
                return p.w;
            }
            
            if (p.steps < K && adjList.get(p.v) != null) {
                for (Pair pair : adjList.get(p.v)) {
                    pq.offer(new Pair(pair.v, p.w + pair.w, p.steps + 1));
                }
            }
        }
        
        return -1;
    }
}

class Pair {
    
    int v;
    int w;
    int steps;
    
    public Pair(int v, int w, int steps) {
        this.v = v;
        this.w = w;
        this.steps = steps;
    }
}

class PairComparator implements Comparator<Pair> {
    
    @Override
    public int compare(Pair lhs, Pair rhs) {
        return lhs.w - rhs.w;
    }
}
