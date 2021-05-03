public class test_12921 {
    public static void main(String[] args) {
        solution(30); // 4
    }
    /*
    static public int solution(int n) {
        int answer = 0;

        for(int i=2; i<=n; i++) { // i = n
            boolean isSosu = true;
            for(int j=2; j<Math.sqrt(i); j++) { // j = i 이하의 수
                if(i%j == 0) { // 나누어지므로 합성수
                    isSosu = false;
                    break;
                }
            }
            if(isSosu) {
                answer++;
                System.out.print(i + ", ");
            }
        }

        return answer;
    }
    */
    static public int solution(int n) {
        int answer = 0;

        // n+1 false로 채운 배열을 생성.
        boolean[] checked = new boolean[n+1];

        // 2부터 n까지 늘리면서 각 숫자의 배수를 배열에 true로 채운다.
        for(int i=2; i<=n; i++) {
            if(!checked[i]) answer++; // checked 되지 않은 배열 카운트++
            for(int j=i; j<=n; j+=i) {
                if(checked[j] == true) continue;
                checked[j] = true;
            }
        }

        return answer;
    }
}
