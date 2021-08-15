package dictionary;
/*
    최소공배수(gcd) / 최대공약수(lcm)
 */
public class gcdLcm {
    public static void main(String[] args) {

    }
    public static int gcd(int a, int b) { // 유클리드 호제법 풀이방식
        // r:임시변수, a:나눌수, b:나눈수
        while( b!= 0) {
            int r = a%b;
            a = b;
            b = r;
        }
        return a; // b가 0이 되면 a를 리턴 => a가 a,b의 최대공약수
    }

    public static int lcm(int arr) {
        return 0;
    }
}
