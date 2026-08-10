class Solution {
    public int lastStoneWeight(int[] stones) {

        // Max Heap
        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>((a, b) -> b - a);

        // Add all stones
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        // Keep smashing the two heaviest stones
        while (maxHeap.size() > 1) {

            int y = maxHeap.poll(); // heaviest
            int x = maxHeap.poll(); // second heaviest

            if (x != y) {
                maxHeap.add(y - x);
            }
        }

        // If no stone remains, return 0
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}