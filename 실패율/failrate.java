import java.util.ArrayList;
import java.util.Collections;

class Solution3 {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        ArrayList<Double> fail = new ArrayList<Double>(N);
        double[] failarray = new double[N];

        int a = 0; //count N
        int stgnum = 1; //stage number++
        int size = stages.length;
        int orisize = size;

        while(a < N){
            int count = 0;

            for(int i = 0; i < stages.length; i++){
                if(stgnum == stages[i]){
                    size--;
                    count++;
                }
            }

            if(count > 0) {
                failarray[a] = (count * 1.0) / orisize;

                fail.add(failarray[a]);
            }else if(count ==0){
                failarray[a] = 0.0;
                fail.add(0.0);
            }

            System.out.print(failarray[a] + " ");
            stgnum++;
            orisize = size;
            a++;
        }


        Collections.sort(fail, Collections.reverseOrder());


        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(fail.get(i) == failarray[j]){
                    answer[i] = j + 1;
                    failarray[j] = -1.0;
                    break;
                }
            }
        }
        return answer;
    }
}

public class failrate{
    public static void main(String[] args){
        Solution3 sol = new Solution3();

        int[] array = {4, 4, 4, 4, 4};
        int[] abc = sol.solution(5, array);

        for(int i = 0; i < abc.length; i++){
            System.out.print(abc[i] + " ");
        }
    }
}