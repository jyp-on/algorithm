class Solution {
    public int hIndex(int[] citations) {
        int papers = citations.length;
        int[] count = new int[papers+1];
        for(int c : citations) {
            count[Math.min(c, papers)]++;
        }

        int published = 0;
        for(int h_index=papers; h_index>=0; h_index--) {
            published += count[h_index];
            if(published >= h_index) {
                return h_index;
            }
        }
        
        // 0 1 2 3 4 5 (i)
        // 1 1 0 1 0 2 (count[i])

        return 0;
    }
}