package sk_ict_p1;

public class Solution {
    public int solution(int money, int[] costs) {
        return findMin(money,costs);
    }

    public int findMin(int money, int[] costs){
        int[] usedCosts = new int[6];
        int min = Integer.MAX_VALUE;
        for(int use500 = money/500; use500 >= 0; use500--){
            usedCosts[5] = use500;
            int remainder = remainderCalculator(money,500,use500);
            for(int use100 = remainder/100; use100 >= 0; use100--){
                usedCosts[4] = use100;
                remainder = remainderCalculator(money,100,use100);
                for(int use50 = remainder/50; use50 >= 0; use50--){
                    usedCosts[3] = use50;
                    remainder = remainderCalculator(money,50,use50);
                    for(int use10 = remainder/10; use10>=0; use10--){
                        usedCosts[2] = use10;
                        remainder = remainderCalculator(money,10,use10);
                        for(int use5 = remainder/5; use5>=0; use5--){
                            usedCosts[1] = use5;
                            usedCosts[0] = remainderCalculator(money,5,use5);
                            int cost = costCalculator(usedCosts, costs);
                            min = cost < min ? cost : min;
                        }
                    }
                }
            }
        }
        return min;
    }

    public int remainderCalculator(int money, int cost, int quantity){
        return money - (cost*quantity);
    }

    public int costCalculator(int[] useCosts, int[] costs){
        int usedMoney = 0;
        for(int i = 0; i < useCosts.length; i++){
            usedMoney += useCosts[i]*costs[i];
        }
        return usedMoney;
    }
}
