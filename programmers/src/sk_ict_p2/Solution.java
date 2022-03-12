package sk_ict_p2;

class Solution {
    public int[][] solution(int n, boolean clockwise) {
        int[][] answer = new int[n][n];
        solve(clockwise,answer,n,0,1);
        return answer;
    }

    public void solve(boolean clockwise,int[][] result, int n, int depth, int num){
        int moveCount = n - 2*depth-1;
        if(moveCount == 0){
            result[n/2][n/2] = num;
            return;
        }
        if(moveCount < 0){
            return;
        }

        if(clockwise){
            //왼쪽 위
            int ptrNum = num;
            int row = depth;
            int cal = depth;
            for(int i = 0; i < moveCount; i++){
                result[row][cal +i] = ptrNum++;
            }

            //오른쪽 위
            ptrNum = num;
            row = depth;
            cal = n-1-depth;
            for(int i = 0; i < moveCount; i++){
                result[row+i][cal] = ptrNum++;
            }

            //오른쪽 아래
            ptrNum = num;
            row = n-1-depth;
            cal = n-1-depth;
            for(int i = 0; i < moveCount; i++){
                result[row][cal-i] = ptrNum++;
            }

            // 왼쪽 아래
            ptrNum = num;
            row = n-1-depth;
            cal = depth;
            for(int i = 0; i < moveCount; i++){
                result[row-i][cal] = ptrNum++;
            }

        }
        else{
            //왼쪽 위
            int ptrNum = num;
            int row = depth;
            int cal = depth;
            for(int i = 0; i < moveCount; i++){
                result[row+i][cal] = ptrNum++;
            }

            //오른쪽 위
            ptrNum = num;
            row = depth;
            cal = n-1-depth;
            for(int i = 0; i < moveCount; i++){
                result[row][cal-i] = ptrNum++;
            }

            //오른쪽 아래
            ptrNum = num;
            row = n-1-depth;
            cal = n-1-depth;
            for(int i = 0; i < moveCount; i++){
                result[row-i][cal] = ptrNum++;
            }

            // 왼쪽 아래
            ptrNum = num;
            row = n-1-depth;
            cal = depth;
            for(int i = 0; i < moveCount; i++){
                result[row][cal+i] = ptrNum++;
            }
        }

        solve(clockwise,result,n,depth+1,num + moveCount);
    }
}