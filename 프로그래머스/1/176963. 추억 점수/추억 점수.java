class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int idx = 0;
        for(String[] ph : photo) {
            int sum = 0;
            for(String p : ph) {
                for(int i = 0; i < name.length; i++) {
                    if(p.equals(name[i])) sum += yearning[i];
                }
            }
            answer[idx++] = sum;
        }
        return answer;
    }
}