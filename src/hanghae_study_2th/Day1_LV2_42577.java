package hanghae_study_2th;

import java.util.Arrays;

/**
 * 24.5.20 (월)
 * [프로그래머스] LV2 코딩테스트>해시 - 전화번호 목록
 */
public class Day1_LV2_42577 {

    public static void main(String[] args) {
         String[] phone_book = {"119", "97674223", "1195524421"};
//        String[] phone_book = {"123","456","789"};
//        String[] phone_book = {"010","123","0102345","567","88"};
        System.out.println(solution2(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for(int i=0; i< phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return answer;

    }

    public static boolean solution2(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for(int i=0; i< phone_book.length-1; i++) {
            if(phone_book[i+1].indexOf(phone_book[i]) == 0) {
                return false;
            }
        }

        return answer;

    }
}
