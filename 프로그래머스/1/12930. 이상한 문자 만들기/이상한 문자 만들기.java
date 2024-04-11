class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split("");
        int idx = 0;
        
        for(String x : arr) {
            if(x.equals(" ")) idx = 0;
            else idx++;
            
            // idx를 미리 증가시켜놨으니 반대로
            if(idx%2==0) sb.append(x.toLowerCase());
            else sb.append(x.toUpperCase());
        }
        return sb.toString();
    }
}