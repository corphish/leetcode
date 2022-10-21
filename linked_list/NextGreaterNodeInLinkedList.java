/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// https://leetcode.com/problems/next-greater-node-in-linked-list
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        int[] arr = list.stream().mapToInt(i -> i).toArray();
        int[] res = new int[arr.length];
        
        // Stores indices
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int minSoFar = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > minSoFar) {
                List<Integer> residue = new ArrayList<>();
                while (!stack.isEmpty()) {
                    int ix = stack.pop();
                    minSoFar = arr[i];
                    if (arr[ix] < arr[i]) {
                        res[ix] = arr[i];
                    } else {
                        residue.add(ix);
                        minSoFar = Math.min(minSoFar, arr[ix]);
                    }
                }
                
                stack.addAll(residue);
                stack.push(i);
            } else {
                minSoFar = Math.min(minSoFar, arr[i]);
                stack.push(i);
            }
            
            //System.out.printf("res=%s, stack=%s\n", Arrays.toString(res), stack.toString());
        }
        
        return res;
    }
}