package programmers.weekly;
/*
    부족한 금액 계산하기
 */
public class test_82612 {
    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;
        System.out.println(solution(price, money, count));
    }

    static public long solution(int price, int money, int count) {
        long answer = -1;
        long sum = 0;
        for(int i=1; i<=count; i++) {
            sum += (price*i);
        }
        long sub = sum - money;

        if(sub > 0) return sub;
        else return 0;
    }
}
