package org.example.inflearn.normal.s3;
import java.util.*;
public class P5 {
    class Task implements Comparable<Task>{
        int ord; // 작업번호
        int st; // 호출시간
        int pt; // 실행시간
        public Task(int ord, int st, int pt){
            this.ord = ord;
            this.st = st;
            this.pt = pt;
        }
        public int compareTo(Task ob){
            if(this.pt == ob.pt) return this.ord - ob.ord; // 실행 시간이 작으면 작업번호순
            return this.pt - ob.pt; // 실행시간 우선
        }
    }
    public int[] solution(int[][] tasks){
        PriorityQueue<Task> pQ = new PriorityQueue<>(); // pQ는 실행시간 짧은 것 우선
        ArrayList<Task> arr = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int n = tasks.length;
        for(int i=0; i<n; i++){ // task 번호
            arr.add(new Task(i, tasks[i][0], tasks[i][1]));
        }
        Collections.sort(arr, new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2){
                if(t1.st == t2.st) return t1.pt - t2.pt;
                return t1.st - t2.st;
            }
        });

        int ft = arr.get(0).st + arr.get(0).pt;
        ans.add(arr.get(0).ord);
        int pos = 1;

//        for(Task t : arr) System.out.println(t.st + " " + t.pt + " " + t.ord);

        for(int t = ft; t<10000; t++){
            while(pos < n && arr.get(pos).st<=t){ // 호출시간이 되면 pQ에 삽입
                pQ.offer(arr.get(pos++));
            }
            if(!pQ.isEmpty() && t >= ft){ // 이전 작업이 끝나면 pQ에서 실행시간이 가장 적은 것 실행
                Task tsk = pQ.poll();
                ft += tsk.pt;
                ans.add(tsk.ord);
            }
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }

    public int[] solution2(int[][] tasks){
        int n = tasks.length;
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<int[]> programs = new LinkedList<>();
        for(int i=0; i<n; i++){
            // 호출시간, 실행시간, 작업번호
            programs.add(new int[]{tasks[i][0], tasks[i][1], i});
        }
        // 호출시간 기준으로 오름차순 정렬
        programs.sort((a, b) -> a[0] - b[0]);
        // 실행시간, 작업번호 순으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int fT = 0;
        while(!programs.isEmpty() || !pq.isEmpty()){
            if(pq.isEmpty()) fT = Math.max(fT, programs.peek()[0]);
            while(!programs.isEmpty() && programs.peek()[0] <= fT){
                int[] x = programs.pollFirst();
                pq.add(new int[]{x[1], x[2]});
            }
            int[] ex = pq.poll();
            fT += ex[0];
            res.add(ex[1]);
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args){
        P5 T = new P5();
        System.out.println(Arrays.toString(T.solution2(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(T.solution2(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution2(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution2(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }
}
