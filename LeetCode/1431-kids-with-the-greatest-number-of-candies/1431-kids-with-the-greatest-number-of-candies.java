class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> answer = new ArrayList<>();
        int max = -1;
        for(int candie : candies) {
            max = Math.max(max, candie);
        }

        for(int candie : candies) {
            if(candie + extraCandies < max) 
                answer.add(false);
            else
                answer.add(true);
        }
        return answer;
    }
}