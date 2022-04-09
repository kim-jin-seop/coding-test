package pgm_12953;

public class Solution {
    public int solution(int[] arr) {
        int lcm = arr[0];
        for(int i = 1; i < arr.length; i++){
            int a = lcm;
            int b = arr[i];
            int gcd = gcd(a < b ? b : a, a < b ? a : b);
            lcm = gcd * (a/gcd) * (b/gcd);
        }
        return lcm;
    }

    public int gcd(int a, int b){
        if(a % b == 0)
            return b;
        return gcd(b,a%b);
    }
}