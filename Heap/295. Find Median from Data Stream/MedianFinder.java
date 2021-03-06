public class MedianFinder {
    // min for small , max for large
    PriorityQueue<Integer> min = new PriorityQueue<>();// minHeap default
    PriorityQueue<Integer> max = new PriorityQueue<>((a,b)->(b-a)); // maxHeap
    // Adds a number into the data structure.
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (max.size() < min.size()){
            max.offer(min.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (max.size() == min.size()) return (max.peek() + min.peek()) /  2.0;
        else return max.peek();
    }
}