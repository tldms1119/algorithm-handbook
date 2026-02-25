/**
 * LeetCode #21 - Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * 🧠 Core Insight
 * 1. Add head of each list into Min Heap.
 * 2. Extract smallest node.
 * 3. Append to result list.
 * 4. If extracted node has next → push into heap.
 *
 * Use a dummy node to simplify head handling.
 *
 * ⏱ Time Complexity: O((n + m) log2) = O(n + m)
 * 💾 Space Complexity: O(2) = O(1)
 */
public class LC0021MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        PriorityQueue<ListNode> minHeap =
                new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add initial heads
        if (list1 != null) minHeap.offer(list1);
        if (list2 != null) minHeap.offer(list2);

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

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
