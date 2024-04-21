import java.util.*;
class Solution {
    class Route implements Comparable<Route> {
        int s, e;
        public Route(int s, int e) {
            this.s = s;
            this.e = e;
        }
        @Override
        public int compareTo(Route ob) {
            return this.e - ob.e;
        }
    }
    public int solution(int[][] routes) {
        int answer = 1;
        List<Route> routeList = new ArrayList<>();
        
        for(int[] r : routes) {
            routeList.add(new Route(r[0], r[1]));
        }
        
        Collections.sort(routeList);
        
        // for(Route r : routeList) {
        //     System.out.println(r.s + " " + r.e);
        // }
        
        int last = routeList.get(0).e;
        for(int i=1; i<routeList.size(); i++) {
            Route next = routeList.get(i);
            if(next.s > last) {
                last = next.e;
                answer++;
            }
        }
        return answer;
    }
}