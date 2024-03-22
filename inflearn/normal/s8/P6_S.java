import java.util.*;
class P6_S {
    public ArrayList<String> solution(String[] subjects, String[] course){
        int n = subjects.length;
        HashMap<String, Integer> node = new HashMap<>();
        for(int i = 0; i < n; i++) node.put(subjects[i], i);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<Integer>());
        }
        int[] indegree = new int[n];
        for(String x : course){ // 그래프 만들면서 진입차수 카운팅
            int a = node.get(x.split(" ")[0]);
            int b = node.get(x.split(" ")[1]);
            graph.get(b).add(a);
            indegree[a]++;
        }

        ArrayList<Integer> order = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) queue.offer(i);
        }

        // 위상정렬
        while(!queue.isEmpty()){
            int pre = queue.poll();
            order.add(pre);
            for(int x : graph.get(pre)){
                indegree[x]--; // 다음과목의 진입차수를 낮춤
                if(indegree[x] == 0){ // 낮췄는데 0이되면 Q에 넣기
                    queue.offer(x);
                }
            }
        }
        ArrayList<String> answer = new ArrayList<>();
//        System.out.println(order);
        for(int i = 0; i < n; i++){
            answer.add(subjects[order.get(i)]);
        }
        return answer;
    }

    public static void main(String[] args){
        P6_S T = new P6_S();
        System.out.println(T.solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"}));
        //System.out.println(T.solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"}));
        //System.out.println(T.solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"}));
    }
}