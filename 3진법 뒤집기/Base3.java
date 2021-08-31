
class Solution {
    public int solution(int n) {
        int answer = 0;

        String Ternary = "";  //3진수 저장
        while(n > 0){
            Ternary = (n % 3) + Ternary;
            n /= 3;
        }

        long Ternary3 = Long.parseLong(Ternary);// 3진수 int형으로 저장
        long BackTernary = 0;  //3진수의 역수 저장

        while(Ternary3 > 0){
            BackTernary = (BackTernary * 10) + (Ternary3 % 10);
            Ternary3 /= 10;
        }

        String STTernary = Long.toString(BackTernary); // 역3진수 string으로 저장

        double Decimal = 0;  //10진수 저장

        for(int i = 0; i < STTernary.length(); i++){
            Decimal = Decimal + Double.parseDouble(STTernary.substring(i, i+1)) * Math.pow(3, (STTernary.length() - 1) - i);
        }

        answer = (int)Decimal;

        return answer;
    }
}

public class Base3 {
    public static void main(String[] args){
        Solution abc = new Solution();
        System.out.print(abc.solution(78413450));
    }
}
