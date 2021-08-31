
class Solution1 {
    public String solution(String new_id) {
            String answer = "";
            String str;


            answer = new_id.toLowerCase();


            answer = answer.replaceAll("[^0-9a-z_.-]","");
            answer = answer.replaceAll("[.]{2,}",".");

            if(answer.startsWith(".")){
                answer = answer.substring(1);
            }

            if(answer.endsWith(".")){
                answer = answer.substring(0, answer.length() - 1);
            }

            if(answer.length() == 0){
                answer = "a";
            }

            if(answer.length() >= 16){
                answer = answer.substring(0,15);
                if(answer.endsWith(".")){
                    answer = answer.substring(0, answer.length() - 1);
                }
            }

            if(answer.length() <=2){
                char last = answer.charAt(answer.length()-1);

                while(true){
                    answer = answer + last;
                    if(answer.length()==3)
                        break;
                }
            }


            return answer;
    }
}

public class ID_rename {
    public static void main(String[] args){
        Solution1 solution = new Solution1();
        String abc = "/";
        System.out.println(solution.solution(abc));
    }
}
