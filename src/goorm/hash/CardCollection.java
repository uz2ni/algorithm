package goorm.hash;

import java.io.*;
import java.util.*;

/**
 * [구름] LV2. 카드 수집 (해쉬)
 */
public class CardCollection {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]); // 모을 N종
        int m = Integer.parseInt(nm[1]); // 제공 카드 수
        List<Integer> cardList = new ArrayList<>();
        for(int i=0; i<m; i++) {
            cardList.add(Integer.parseInt(br.readLine()));
        }
        int cnt = 0; // 카드 최소 장수
        Set<Integer> hs = new HashSet<>(); // hashSet에 카드 넣으면서 수집 완료 조건 충족하는지 판별
        for(int i=0; i<cardList.size(); i++) {
            hs.add(cardList.get(i));
            cnt++;
            if(hs.size() == n) {
                System.out.println(cnt);
                return;
            }
        }

        System.out.println(-1); // for문에서 걸리지 못한 경우 = 카드 모두 모으지 못한 경우 -1
        return;
    }
}
