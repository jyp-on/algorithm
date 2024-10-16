import java.util.*;
class SmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    Set<Integer> set;
    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>((a, b) -> a - b);
        set = new HashSet<>();
        for(int i = 1; i <= 1000; i++) {
            pq.add(i);
            set.add(i);
        }
    }
    
    public int popSmallest() {
        int x = pq.poll();
        set.remove(x);
        return x;
    }
    
    public void addBack(int num) {
        if(!set.contains(num)) {
            set.add(num);
            pq.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */