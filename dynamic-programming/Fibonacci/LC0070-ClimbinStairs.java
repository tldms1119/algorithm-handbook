/**
 * LeetCode #70 - Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/
 *
 * Pattern: Dynamic Programming (Fibonacci)
 *
 * 🧠 Core Idea
 * To reach step n:
 * - You came from step (n - 1) by taking 1 step
 * - You came from step (n - 2) by taking 2 steps
 *
 * Therefore, ways(n) = ways(n - 1) + ways(n - 2)
 * This is exactly the Fibonacci recurrence.
 *
 * ⏱️ Time Complexity: O(n)
 * 💾 Space Complexity: O(1)
 */
public class LC0070ClimbingStairs {

    public int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }

        int prev2 = 1; // ways to reach step 1
        int prev1 = 2; // ways to reach step 2

        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
