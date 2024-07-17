package goorm.others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [구름] LV1. 369 게임 (없어짐)
 */
public class Game369 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int i=1; i<n; i++) {
            String str = String.valueOf(i);
            for(char ch : str.toCharArray()) {
                if(ch == '3' || ch == '6' || ch == '9') {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

    }


}
