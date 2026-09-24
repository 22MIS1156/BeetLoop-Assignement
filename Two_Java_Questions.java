/*
 * Java Practice File
 * Q1: Longest Common Prefix
 * Q2: Jump Game II
 *
 * Both programs take input from the user and call the Solution function.
 */

import java.util.*;

public class Main {

    // ============================================================
    // Q1) Longest Common Prefix
    // ============================================================
    static class LongestCommonPrefixSolution {

        public String longestCommonPrefix(String[] strs) {

            if (strs == null || strs.length == 0)
                return "";

            String prefix = strs[0];

            for (int i = 1; i < strs.length; i++) {

                while (!strs[i].startsWith(prefix)) {

                    prefix = prefix.substring(0, prefix.length() - 1);

                    if (prefix.equals(""))
                        return "";
                }
            }

            return prefix;
        }
    }

    // ============================================================
    // Q2) Jump Game II
    // ============================================================
    static class JumpGameSolution {

        public int jump(int[] nums) {

            int jumps = 0;
            int end = 0;
            int farthest = 0;

            for (int i = 0; i < nums.length - 1; i++) {

                farthest = Math.max(farthest, i + nums[i]);

                if (i == end) {
                    jumps++;
                    end = farthest;
                }
            }

            return jumps;
        }
    }

    // ============================================================
    // Main Method - User Input
    // ============================================================
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ---------------- Q1 ----------------
        System.out.println("===== Q1: Longest Common Prefix =====");

        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();

        String[] strs = new String[n];

        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }

        LongestCommonPrefixSolution q1 =
                new LongestCommonPrefixSolution();

        String prefix = q1.longestCommonPrefix(strs);

        System.out.println("Longest Common Prefix: " + prefix);


        // ---------------- Q2 ----------------
        System.out.println("\n===== Q2: Jump Game II =====");

        System.out.print("Enter number of elements: ");
        int m = sc.nextInt();

        int[] nums = new int[m];

        System.out.println("Enter the elements:");
        for (int i = 0; i < m; i++) {
            nums[i] = sc.nextInt();
        }

        JumpGameSolution q2 = new JumpGameSolution();

        int result = q2.jump(nums);

        System.out.println("Minimum jumps: " + result);

        sc.close();
    }
}

/*
============================================================
SAMPLE INPUT
============================================================

3
flower
flow
flight
5
2 3 1 1 4

============================================================
SAMPLE OUTPUT
============================================================

===== Q1: Longest Common Prefix =====
Enter number of strings: 3
Enter the strings:
flower
flow
flight
Longest Common Prefix: fl

===== Q2: Jump Game II =====
Enter number of elements: 5
Enter the elements:
2 3 1 1 4
Minimum jumps: 2

============================================================
SECOND SAMPLE FOR Q2
============================================================

Input:
5
2 3 0 1 4

Output:
Minimum jumps: 2
============================================================
*/
