class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] next = new int[10001];
        java.util.Arrays.fill(next, -1);
        java.util.Stack<Integer> st = new java.util.Stack<>();
        for (int n : nums2) {
            while (!st.isEmpty() && st.peek() < n) next[st.pop()] = n;
            st.push(n);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) res[i] = next[nums1[i]];
        return res;
    }
}
