class Solution {
    public int[] solution(String[] board) {
        int lux = 51, luy = 51, rdx = -1, rdy = -1;
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length(); c++) {
                if(board[r].charAt(c) == '#') {
                    lux = Math.min(lux, r);
                    luy = Math.min(luy, c);
                    rdx = Math.max(rdx, r);
                    rdy = Math.max(rdy, c);
                }
            }
        }
        return new int[]{lux, luy, rdx+1, rdy+1};
    }
}