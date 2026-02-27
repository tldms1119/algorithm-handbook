/**
 * LeetCode #23 - Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 *
 * Pattern: Heap (Priority Queue) + Linked List
 *
 * 🧠 Core Idea
 * This is a generalization of `Merge Two Sorted Lists`
 * Instead of comparing two heads, we always compare the smallest head among k lists.
 * Min Heap gives O(log k) access to smallest element.
 *
 * Approach (Min Heap)
 * 1. Initialize a min heap ordered by node value
 * 2. Push the head of each non-null list into the heap
 * 3. While heap is not empty:
 *    - pop smallest node
 *    - append it to result list
 *    - if popped node has next → push next into heap
 *
 * ⏱ Time Complexity: O(n log k)
 *    n = total number of nodes
 *    k = number of lists
 * 💾 Space Complexity: O(k)
 */
import java.util.PriorityQueue;

public class LC0023MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Step 1: push initial heads
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Step 2: extract min node and push next
        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;

            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }
        return dummy.next;
    }
}
