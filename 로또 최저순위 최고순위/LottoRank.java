
class Solution2 {
    public int[] solution(int[] lottos, int[] win_nums) {

        int correct = 7;
        int zero_num = 0;

        for(int i = 0; i < lottos.length; i++) {

            if(lottos[i] == 0){
                zero_num++;
            }


            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    correct--;
                }
            }
        }

        if(correct == 7){
            correct = 6;
        }


        int sum = correct - zero_num;

        if(sum == 0){
            sum = 1;
        }

        int[] answer = {sum, correct};

        return answer;
    }
}

public class LottoRank {
    public static void main(String[] args){
        Solution2 solution2 = new Solution2();

        int[] lottos1 = {45, 4, 35, 20, 3, 9};
        int[] win_num1 = {45, 4, 35, 20, 3, 9};

       int[] solutionarray = solution2.solution(lottos1, win_num1);

       for(int i = 0; i < solutionarray.length; i++){
           System.out.print(solutionarray[i]+ " ");

       }

    }
}
