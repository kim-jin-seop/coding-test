package pgm_12949;

public class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int fX = 0; fX < arr1.length; fX++){
            for(int bY = 0; bY < arr2[0].length; bY++){
                int result = 0;
                for(int lo = 0; lo < arr1[0].length; lo++){
                    result += arr1[fX][lo] * arr2[lo][bY];
                }
                answer[fX][bY] = result;
            }
        }
        return answer;
    }
}