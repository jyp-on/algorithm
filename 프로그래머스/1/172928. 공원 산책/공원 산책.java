class Solution {
    // 방향벡터 {북남서동}
    int[] dh = {-1, 1, 0, 0};
    int[] dw = {0, 0, -1, 1};
    public int getIdx(String dir) {
        if(dir.equals("N")) return 0;
        else if(dir.equals("S")) return 1;
        else if(dir.equals("W")) return 2;
        else return 3;
    }
    public int[] getStartPoint(String[] park) {
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[0].length(); j++) {
                if(park[i].charAt(j) == 'S') return new int[]{i, j};
            }
        }
        return new int[]{0, 0}; // S가 주어지지 않은 경우는 없음
    }
    public int[] solution(String[] park, String[] routes) {
        int h_length = park.length;
        int w_length = park[0].length();
        int[] startPoint = getStartPoint(park);
        int h = startPoint[0], w = startPoint[1];
        for(String route : routes) {
            String dir = route.split(" ")[0]; // 방향
            int n = Integer.parseInt(route.split(" ")[1]); // 이동할 칸 수
            int idx = getIdx(dir);
            int nh = 0, nw = 0;
            boolean flag = true;
            for(int i = 1; i <= n; i++) {
                nh = h + (dh[idx] * i);
                nw = w + (dw[idx] * i);
                // 가는 도중 park를 벗어나는 경우
                if(nh < 0 || nh >= h_length || nw < 0 || nw >= w_length) {
                    flag = false;
                    break;
                }
                // 가는 도중 장애물을 발견할 경우
                if(park[nh].charAt(nw) == 'X') {
                    flag = false;
                    break;
                };
            }
            if(!flag) continue;
            h = nh;
            w = nw;
        }
        return new int[]{h, w};
    }
}