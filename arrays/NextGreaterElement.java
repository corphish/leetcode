// https://leetcode.com/problems/next-greater-element-i
class Solution {
    // [137,59,92,122,52,131,79,236,94]
    // [52,59,79,92,94,122,131,137,236]
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int[] index = new int[10001];
        int last = 0;
        Stack<Integer> st = new Stack<>();
        
        Arrays.fill(index, -1);
        
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] > nums2[last]) {
                while (st.size() > 0) {
                    int k = st.pop();
                    if (k >= nums2[i]) {
                        st.push(k);
                        break;
                    }
                    index[k] = nums2[i];
                }
            }
            
            //System.out.println("Current = " + nums2[i] + " Stack = " + st);
            st.push(nums2[i]);
            last = i;
        }
        
        for (int i = 0; i < nums1.length; i++) {
            res[i] = index[nums1[i]];
        }
        
        //System.out.println(Arrays.toString(index));
        
        return res;
    }
}