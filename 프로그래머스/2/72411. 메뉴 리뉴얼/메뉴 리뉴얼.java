import java.util.*;

class Solution {
    
    List<String> answerList = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        
        // order 정렬
        for(int i=0; i<orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }
        
        for(int courseLength : course) {
            // course Length 만큼의 조합 생성
            
            for(String order : orders) {
                combi("", order, courseLength);
            }
            
            if(!map.isEmpty()) {
                List<Integer> countList = new ArrayList<>(map.values());
                int max = Collections.max(countList);

                if(max > 1) {
                    for(String key : map.keySet()) {
                        if(map.get(key) == max) {
                            answerList.add(key);
                        }
                    }
                }
            }
            
            
            map.clear();
        }
        
        Collections.sort(answerList);
        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answer.length; i++)
            answer[i] = answerList.get(i);
        
        return answer;
    }
    
    void combi(String order, String others, int count) {
        if(count == 0) {
            map.put(order, map.getOrDefault(order, 0) + 1);
            return;
        }
        
        for(int i=0; i<others.length(); i++) {
            combi(order + others.charAt(i), others.substring(i+1), count - 1);
        }
    }
}