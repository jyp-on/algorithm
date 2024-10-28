class Solution {
    public int integerReplacement(int n) {
        Queue<Long> q = new LinkedList<>();
        HashSet<Long> set = new HashSet<>();
        q.offer((long)n);
        set.add((long)n);
        int cnt = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                long c = q.poll();
                if(c == 1) return cnt;
                if(c % 2 == 0) { 
                    long next = (long)c/2;
                    if(!set.contains(next)) {
                        q.add(next);
                        set.add(next);
                    }

                }
                else {
                    long next1 = (long)(c+1);
                    long next2 = (long)(c-1);
                    if(!set.contains(next1)) {
                        q.add(next1);
                        set.add(next1);
                    }
                    if(!set.contains(next2)) {
                        q.add(next2);
                        set.add(next2);
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
}