package programmers.level2;

import java.util.Arrays;

/*
    해시 - 전화번호 목록
 */
public class test_42577 {
    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(solution(phone_book));
    }
    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i=0; i< phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }

        }
        return true;
    }

    public static boolean solution2(String[] phone_book) {
        for(int i=0; i<phone_book.length-1; i++) {
            for(int j=i+1; j<phone_book.length; j++) {
                if(phone_book[i].startsWith(phone_book[j])) {return false;}
                if(phone_book[j].startsWith(phone_book[i])) {return false;}
            }
        }
        return true;
    }

}
