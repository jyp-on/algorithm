class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> deque = new LinkedList<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                deque.addLast(asteroid);
            } else {
                while(!deque.isEmpty() && deque.peekLast() > 0 && Math.abs(asteroid) > deque.peekLast()) {
                    deque.removeLast();
                }

                if(!deque.isEmpty() && Math.abs(asteroid) == deque.peekLast()) {
                    deque.removeLast();
                } else if(deque.isEmpty() || deque.peekLast() < 0) {
                    deque.addLast(asteroid);
                }
                
            }
        }

        int[] result = new int[deque.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = deque.removeFirst();
        }
        return result;
    }
}