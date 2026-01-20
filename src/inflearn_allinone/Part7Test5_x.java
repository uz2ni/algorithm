package inflearn_allinone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [트리] 감염된 폴더
 */
public class Part7Test5_x {

    public static void main(String[] args) {

//        String[][] folders = {{"root", "apps"}, {"apps", "chrome"}, {"apps", "vscode"}}; // apps
//        String p = "chrome";
//        String q = "vscode";

        String[][] folders = {{"root", "usr"}, {"usr", "bin"}, {"usr", "local"}, {"bin", "tools"}}; // bin
        String p = "bin";
        String q = "tools";

        System.out.println(solution(folders, p, q));
    }

    public static String solution(String[][] folders, String p, String q) {
        // 간선리스트 -> 해시맵
        Map<String,List<String>> map = new HashMap<>();
        for(String[] folder : folders) {
            map.putIfAbsent(folder[0], new ArrayList<>());
            map.get(folder[0]).add(folder[1]);
            // map 넣기 개선 버전
            // map.computeIfAbsent(folder[0], k -> new ArrayList<>()).add(folder[1]);
        }

        return dfs(map, "root", p, q);
    }

    public static String dfs(Map<String,List<String>> tree, String node, String p, String q) {
        // basecase
        if(node.equals(p) || node.equals(q)) return node;

        List<String> found = new ArrayList<>();
        List<String> children = tree.getOrDefault(node, new ArrayList<>());
        // dfs
        for(String child : children) {
            String now = dfs(tree, child, p, q);
            if(now != null) found.add(now);
        }

        // result
        if(found.size() == 2) {
            return node;
        }else if(found.size() == 1) {
            return found.get(0);
        }

        return null;
    }
}
