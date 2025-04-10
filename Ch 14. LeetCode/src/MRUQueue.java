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
    private List<List<Integer>> list;
    private int size;
    private int chunkSize;

    public MRUQueue(int n) {
        // Create ceil(sqrt(n)) chunks of ceil(sqrt(n)) size to speed up fetch from O(n) to O(sqrt(n))
        list = new ArrayList<>();
        size = n;
        chunkSize = (int) Math.ceil(Math.sqrt(n));

        for (int k = 0; k < n; k++) {
            if (k % chunkSize == 0) {
                list.add(new ArrayList<>());
            }

            list.get(k / chunkSize).add(k + 1);
        }
    }

    public List<List<Integer>> getList() {
        return list;
    }

    public int fetch(int k) {
        k = k - 1;

        int target = -1;
        int acc = 0;
        int i = 0;
        while (i < list.size()) {
            int currentSize = list.get(i).size();
            acc += currentSize;
            if (k < acc) {
                target = list.get(i).remove((k - (acc - currentSize)) % currentSize);
                break;
            }
            i++;
        }

        var last = list.get(list.size() - 1);
        last.add(target);

        if (last.size() >= chunkSize * 2) {
            rebalance();
        }

        return target;
    }

    // [[1], [5], [7, 8, 3, 6, 2, 4]]
    // [[1, 5, 7], [8, 3, 6], [2, 4]]
    // TODO: To rebalance, create an empty list, and populate in order
    public void rebalance() {
//        var rebalanced = new ArrayList<List<Integer>>();
//
//        for (int i = 0; i < list.get(0); i++) {
//            rebalanced.add(new ArrayList<>());
//            var current = rebalanced.get(i);
//            for (int j = 0; j < chunkSize; j++) {
//                current.add(list.)
//            }
//        }
    }
}

// 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
// 1 -> 2 ------> 4 -> 5 -> 6 -> 7 -> 8 -> 3
// start    = [1, 2, 3, 4, 5, 6, 7, 8]
// fetch(3) = [1, 2, -1, 4, 5, 6, 7, 8, 3]
// fetch(6) = [1, 2, -1, 4, 5, -1, 7, 8, 3, 6]