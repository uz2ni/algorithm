package programmers.level1;

/*
    x만큼 간격이 있는 n개의 숫자
 */
public class test_12954 {
    public static void main(String[] args) {
        long[] result = solution(-4,2);
        for(int i=0; i<result.length; i++) {
            System.out.print(result[i] + ", ");
        }
    }
    public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        for(int i=1; i<=n; i++) {
            answer[i-1] = new Long(x) * i;
        }
        return answer;
    }
}
