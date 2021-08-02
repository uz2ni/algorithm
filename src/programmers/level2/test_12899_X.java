package programmers.level2;
/*
    124 나라의 숫자
 */
public class test_12899_X {
    public static void main(String[] args) {
        System.out.println(solution(9));
    }
    static public String solution(int n) {
        String answer = "";
        // 1%3=1 -> 1
        // 2%3=2 -> 2
        // 3%3=0 -> 4
        // arr[0,1,2] -> 4,1,2
        int num = n;
        int[] arr = {4,1,2};

        while(num > 0) {
            int reminder = num % 3;
            num /= 3;

            if(reminder == 0) num--;

            answer = arr[reminder] + answer;
        }

        return answer;
    }
}
