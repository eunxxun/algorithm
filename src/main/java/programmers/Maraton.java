package programmers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Maraton {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashMap = new HashMap<>();
//        StringBuilder result = new StringBuilder();
        String answer = "";
        for (String p : participant) {
            hashMap.put(p, hashMap.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            hashMap.put(c, hashMap.get(c) - 1);
        }

        Iterator<Map.Entry<String, Integer>> iter = hashMap.entrySet().iterator();

        while (iter.hasNext()){
            Map.Entry<String, Integer> entry = iter.next();
            if (entry.getValue() != 0) {
                answer = entry.getKey();
                break;
            }
        }

        return answer;

//        for (String key : hashMap.keySet()) {
//            if (hashMap.get(key) > 0) {
//                result.append(key);
//            }
//        }
//        return result.toString();
    }
}
