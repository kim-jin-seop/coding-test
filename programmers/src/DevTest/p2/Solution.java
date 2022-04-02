package DevTest.p2;

import java.util.ArrayList;

public class Solution {
    public int count = 0;

    public int solution(String[] grid) {
        ArrayList<int[]> questionMarkList = new ArrayList<>();
        char[][] charGrid = new char[grid.length][grid[0].length()];
        findQuestionMarkAndCharGrid(grid, questionMarkList, charGrid);
        recursive(questionMarkList,0,charGrid);
        return count;
    }

    private void findQuestionMarkAndCharGrid(String[] grid, ArrayList<int[]> questionMarkList,char[][] charGrid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                charGrid[i][j] = grid[i].charAt(j);
                if (grid[i].charAt(j) == '?')
                    questionMarkList.add(new int[]{i, j});
            }
        }
    }

    private void recursive(ArrayList<int[]> questionMarkList, int idx, char[][] charGrid) {
        if(idx == questionMarkList.size()) {
            if(validCheck(charGrid))
                count++;
            return;
        }

        int[] loc = questionMarkList.get(idx);
        charGrid[loc[0]][loc[1]] = 'a';
        recursive(questionMarkList,idx+1,charGrid);
        charGrid[loc[0]][loc[1]] = 'b';
        recursive(questionMarkList,idx+1,charGrid);
        charGrid[loc[0]][loc[1]] = 'c';
        recursive(questionMarkList,idx+1,charGrid);
    }

    private boolean validCheck(char[][] charGrid) {
        boolean[][] check = new boolean[charGrid.length][charGrid[0].length];
        boolean flagA = true;
        boolean flagB =true;
        boolean flagC = true;
        for (int i = 0; i < charGrid.length && (flagA || flagB || flagC); i++) {
            for (int j = 0; j < charGrid[i].length; j++) {
                if(charGrid[i][j] == 'a' && flagA){
                    check[i][j] = true;
                    dfs(check, charGrid,i,j,'a');
                    flagA = false;
                }
                if(charGrid[i][j] == 'b' && flagB){
                    check[i][j] = true;
                    dfs(check, charGrid,i,j,'b');
                    flagB = false;
                }
                if(charGrid[i][j] == 'c' && flagC) {
                    check[i][j] = true;
                    dfs(check, charGrid, i, j, 'c');
                    flagC = false;
                }
                if(!(flagA || flagB || flagC))
                    break;
            }
        }
        return checkResult(check);
    }

    private boolean checkResult(boolean[][] check) {
        for(int i = 0; i < check.length; i++){
            for(int j = 0; j < check[i].length; j++)
                if(!check[i][j])
                    return false;
        }
        return true;
    }

    private void dfs(boolean[][] check, char[][] charGrid, int x, int y, char target){
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        for(int i = 0; i < 4; i ++){
            if(boundaryCheck(charGrid,x+dx[i],y+dy[i])){
                if(charGrid[x+dx[i]][y+dy[i]] == target && !check[x+dx[i]][y+dy[i]]){
                    check[x+dx[i]][y+dy[i]] = true;
                    dfs(check,charGrid,x+dx[i],y+dy[i],target);
                }
            }
        }
    }

    private boolean boundaryCheck(char[][] grid, int x, int y){
        return (x >= 0 && x < grid.length) && (y >= 0 && y < grid[0].length);
    }
}