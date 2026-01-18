import java.util.ArrayList;
public class ratInMaze{
    public  ArrayList<String> findPaths(int n, int[][]grid){
        ArrayList<String> path=new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        if(grid[0][0]==1){
            solve(n, grid, path, "", 0, 0, visited);
        }
        return path;
    }
    public void solve(int n, int[][]grid, ArrayList<String> path, String move, int row, int col, boolean[][] visited){
        if(row == n-1 && col == n-1){
            path.add(move);
            return;
        }
        //down
        if(row+1<n && grid[row+1][col] == 1 && !visited[row+1][col]){
            visited[row][col] =  true;
            solve(n, grid, path, move + 'D', row + 1, col, visited);
            visited[row][col] = false;
        }
        //left
        if(col - 1 >= 0 && grid[row][col - 1] == 1 && !visited[row][col - 1]){
            visited[row][col] =  true;
            solve(n, grid, path, move + 'L', row, col - 1, visited);
            visited[row][col] = false;
        }
        //right
        if(col+1<n && grid[row][col+1] == 1 && !visited[row][col+1]){
            visited[row][col] =  true;
            solve(n, grid, path, move + 'R', row , col + 1, visited);
            visited[row][col] = false;
        }
        //up
        if(row-1 >= 0 && grid[row-1][col] == 1 && !visited[row - 1][col]){
            visited[row][col] =  true;
            solve(n, grid, path, move + 'U', row - 1, col, visited);
            visited[row][col] = false;
        }
    }
    public static void main(String[] args){
        ratInMaze rm = new ratInMaze();
        int n = 4; 
        int[][] grid = { { 1, 0, 0, 0 },
                         { 1, 1, 0, 1 },
                         { 1, 1, 0, 0 },
                         { 0, 1, 1, 1 } };
                         ArrayList<String> result = rm.findPaths(n, grid);
        System.out.println(result);
    }
}