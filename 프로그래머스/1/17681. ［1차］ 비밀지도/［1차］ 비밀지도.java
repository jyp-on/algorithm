class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++) {
            String a1 = toBinary(arr1[i], n);
            String a2 = toBinary(arr2[i], n);
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++) {
                if(a1.charAt(j)=='1' || a2.charAt(j)=='1')
                    sb.append("#");
                else 
                    sb.append(" ");
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
    
    private String toBinary(int x, int n) {
        StringBuilder sb = new StringBuilder();
        while(x > 1) {
            int q = x / 2;
            int m = x % 2;
            sb.append(m);
            x = q;
        }
        sb.append(x);
        while(sb.length()<n) 
            sb.append(0);
        return sb.reverse().toString();
    }
}