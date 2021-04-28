package programmers;

/*
    로또의 최고 순위와 최저 순위
 */
public class test_77484 {
    public static void main(String[] args) {
        int[] lottos = {45, 4, 35, 20, 3, 9}; // 구매한 번호
        int[] win_nums = {20, 9, 3, 45, 4, 35}; // 당첨 번호
        solution(lottos, win_nums);
    }
    // 최고, 최저 순위 배열 리턴
    static public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero=0, matched=0;

        for(int l : lottos) {
            if(l == 0) {
                zero++;
            }else {
                for(int w : win_nums) {
                    if(l == w) {
                        matched++;
                        break;
                    }
                }
            }
        }

        // 순위 계산
        answer[0] = getGrade(zero+matched);
        answer[1] = getGrade(matched);

        return answer;
    }

    static public int getGrade(int cnt) {
        if(cnt == 6) return 1;
        else if(cnt == 5) return 2;
        else if(cnt == 4) return 3;
        else if(cnt == 3) return 4;
        else if(cnt == 2) return 5;
        else return 6;
    }
}
