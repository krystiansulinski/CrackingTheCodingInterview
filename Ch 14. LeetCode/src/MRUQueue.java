/*
    Description

    Design a queue-like data structure that moves the most recently used element to the end of the queue.

    Implement the MRUQueue class:
        - MRUQueue(int n) constructs the MRUQueue with n elements: [1,2,3,...,n].
        - int fetch(int k) moves the kth element (1-indexed) to the end of the queue and returns it.

    Example 1:
    Input:
            ["MRUQueue", "fetch", "fetch", "fetch", "fetch"]
            [[8], [3], [5], [2], [8]]
    Output:
            [null, 3, 6, 2, 2]

    Explanation:
    MRUQueue mRUQueue = new MRUQueue(8); // Initializes the queue to [1,2,3,4,5,6,7,8].
    mRUQueue.fetch(3); // Moves the 3rd element (3) to the end of the queue to become [1,2,4,5,6,7,8,3] and returns it.
    mRUQueue.fetch(5); // Moves the 5th element (6) to the end of the queue to become [1,2,4,5,7,8,3,6] and returns it.
    mRUQueue.fetch(2); // Moves the 2nd element (2) to the end of the queue to become [1,4,5,7,8,3,6,2] and returns it.
    mRUQueue.fetch(8); // The 8th element (2) is already at the end of the queue so just return it.
*/

import java.util.ArrayList;
import java.util.List;

public class MRUQueue {
    private final List<List<Integer>> buckets;
    private final int MAX_BUCKET_SIZE;

    public MRUQueue(int n) {
        // Divide n elements into chunks of size ~sqrt(n) to support fast fetch().
        buckets = new ArrayList<>();
        MAX_BUCKET_SIZE = (int) Math.ceil(Math.sqrt(n));

        for (int k = 0; k < n; k++) {
            if (k % MAX_BUCKET_SIZE == 0) {
                buckets.add(new ArrayList<>());
            }

            buckets.get(k / MAX_BUCKET_SIZE).add(k + 1);
        }
    }

    public List<List<Integer>> getBuckets() {
        return buckets;
    }

    public int fetch(int k) {
        // k is 1-indexed
        k--;

        int fetchedValue = -1;
        int elementsBefore = 0;
        int bucketIndex = 0;
        while (bucketIndex < buckets.size()) {
            int bucketSize = buckets.get(bucketIndex).size();
            elementsBefore += bucketSize;
            if (k < elementsBefore) {
                int localIndex = (k - (elementsBefore - bucketSize)) % bucketSize;
                fetchedValue = buckets.get(bucketIndex).remove(localIndex);
                break;
            }
            bucketIndex++;
        }

        var last = buckets.get(buckets.size() - 1);
        last.add(fetchedValue);

        if (last.size() >= MAX_BUCKET_SIZE * 2) {
            rebalanceBuckets();
        }

        return fetchedValue;
    }

    // [[1], [4, 5], [7, 8, 3, 6, 2]] => [[1, 4, 5], [7, 8, 3], [6, 2]]
    public void rebalanceBuckets() {
        List<Integer> lastBucket = buckets.get(buckets.size() - 1);

        int i = 0;
        while (lastBucket.size() >= MAX_BUCKET_SIZE) {
            List<Integer> current = buckets.get(i);

            if (current.size() < MAX_BUCKET_SIZE && i + 1 < buckets.size()) {
                int shift = buckets.get(i + 1).remove(0);
                current.add(shift);
            } else {
                i++;
            }
        }
    }
}
