import java.util.Collections;
import java.util.PriorityQueue;

class Solution {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();

            if (first != second) {
                maxHeap.offer(first - second);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}

public class LastStoneWeight {

    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] stones = {2, 7, 4, 1, 8, 1};
        int ans = obj.lastStoneWeight(stones);
        System.out.println("Last Stone Weight: " + ans);
    }
}
