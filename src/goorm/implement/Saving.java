package goorm.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * [구름] LV1. 절약
 */
public class Saving {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int balance = 0;
        String result;

        List<String[]> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(br.readLine().split(" "));
        }

        for(int i=0; i<list.size(); i++) {
            String lavel = list.get(i)[0];
            int money = Integer.parseInt(list.get(i)[1]);

            if("in".equals(lavel)) {
                balance += money;
            }else {
                if(balance < money) {
                    System.out.println("fail");
                    return;
                }
                balance -= money;
            }

        }
        result = (balance > 0 ? "success" : "fail");
        System.out.println(result);
    }
}
