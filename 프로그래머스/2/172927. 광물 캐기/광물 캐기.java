import java.util.*;

class Solution {
    
    class Mineral implements Comparable<Mineral> {
        String[] m;
        int p = 0; // 피로도
        public Mineral(String[] minerals) {
            m = minerals;
            for(String x : m) {
                p += getScoreWithStone(x);
            }
        }
        public int compareTo(Mineral ob) {
            return ob.p - this.p; // 피로도 내림차순 정렬
        }
    }

    public int getScoreWithIron(String x) {
        if(x.equals("diamond")) return 5;
        else if(x.equals("iron")) return 1;
        else return 1;
    }

    public int getScoreWithStone(String x) {
        if(x.equals("diamond")) return 25;
        else if(x.equals("iron")) return 5;
        else return 1;
    }
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int len = 0; // 곡괭이로 광물 몇번 캘 수 있는지
        for(int p : picks) len += (p*5);
        int n = minerals.length;
        int idx = 0; // 광석 idx
        int tmp_len = len;
        ArrayList<Mineral> arr = new ArrayList<>();
        while(tmp_len-5>=0 && idx+5<n) { // 5개 묶음으로 광석 저장, 5개 이하면 따로 저장
            String[] tmp = new String[5];
            for(int i = idx; i < idx+5; i++) {
                tmp[i-idx] = minerals[i];
            }
            idx += 5;
            tmp_len -= 5;
            arr.add(new Mineral(tmp));
        }
        int size = Math.min(n-idx, tmp_len); // 남은 광물갯수와 곡괭이 사용횟수중 더 적은걸로
        String[] tmp = new String[size];
        int i = 0;
        while(idx<n && tmp_len>0) {
            tmp[i] = minerals[idx];
            i++; idx++; tmp_len--;
        }
        arr.add(new Mineral(tmp));
        Collections.sort(arr);
        for(Mineral x : arr) { // 광물 묶음
            if(picks[0] > 0) {
                for(String target : x.m) answer++;
                picks[0]--;
            } else if(picks[1] > 0) {
                for(String target : x.m) answer += getScoreWithIron(target);
                picks[1]--;
            } else if(picks[2] > 0) {
                for(String target : x.m) answer += getScoreWithStone(target);
                picks[2]--;
            }
        }
        
        return answer;
    }
}