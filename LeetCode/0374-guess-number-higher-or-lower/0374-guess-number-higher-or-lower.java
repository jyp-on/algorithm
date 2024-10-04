/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lt = 0, rt = n;
        while(lt <= rt) {
            int mid = lt + (rt - lt) / 2;
            int res = guess(mid);
            if (res == 1) lt = mid + 1;
            else if (res == -1) rt = mid - 1;
            else return mid;
        }

        return 0;
    }
}