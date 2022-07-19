package pgm_12911;

public class Solution {
    public int solution(int n) {
        int backZeroCount = 0;
        int zeroPoint = 0;

        n *= 2;
        boolean backZeroFlag = true;
        while (backZeroFlag || (n&1) == 0) {
            n /= 2;
            zeroPoint++;
            if (backZeroFlag && (n & 1) == 0) {
                backZeroCount++;
                continue;
            }
            backZeroFlag = false;
        }

        int front = n+1;
        for(int i = 0; i < zeroPoint; i++)
            front*= 2;

        int back = 0;
        int backOneCount = (zeroPoint - backZeroCount - 2);
        while (backOneCount >= 0){
            backOneCount--;
            back += 1;
            back *= 2;
        }
        back/=2;

        return front +back;
    }
}