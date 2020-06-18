class Solution {
    int m, n;
    
    public void solve(char[][] a) {
        
        if (a.length == 0)
            return;
        
        m = a.length;
        n = a[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 'O') {
                    a[i][j] = '-';
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            floodFill(a, i, 0, 'O', '-'); //Left
        }
        
        for (int i = 0; i < m; i++) {
            floodFill(a, i, n - 1, 'O', '-'); //Right
        }
        
        for (int i = 0; i < n; i++) {
            floodFill(a, 0, i, 'O', '-'); //Top
        }
        
        for (int i = 0; i < n; i++) {
            floodFill(a, m - 1, i, 'O', '-'); //Bottom
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == '-') {
                    a[i][j] = 'X';
                }
            }
        }
        
    }
    
    public void floodFill(char[][] a, 
                          int i, int j, Character newV, Character prevV) {
        
        if ((i < 0 || i >= m) || (j < 0 || j >= n))
            return;
        
        if (a[i][j] != prevV)
            return;
            
        a[i][j] = newV;
            
        floodFill(a, i, j + 1, newV, prevV);
        floodFill(a, i, j - 1, newV, prevV);
        floodFill(a, i + 1, j, newV, prevV);
        floodFill(a, i - 1, j, newV, prevV);
        
    }
}
