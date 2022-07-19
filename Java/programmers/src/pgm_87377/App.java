package pgm_87377;

public class App {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] solution = s.solution(new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}, {1, 0, 4}, {1, 0, -4}});
//        String[] solution = s.solution(new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}});
        for(String sa : solution){
            System.out.println(sa);
        }
    }
}
