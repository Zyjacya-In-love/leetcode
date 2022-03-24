package lcof40;

/**
 * 剑指 Offer 40. 最小的k个数
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * @author xzq
 * @create 2022-03-22-23:11
 */
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        partition(arr, 0, arr.length-1, k-1);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private void partition(int[] arr, int first, int last, int k) {
        int l = first, r = last;
        while (l < r) {
            while (l < r && arr[r] > arr[first]) r--;
            while (l < r && arr[l] <= arr[first]) l++;
            swap(arr, l, r);
        }
        swap(arr, first, l);
        if (l == k || l == k+1) {
            return;
        } else if (l > k) {
            partition(arr, first, l-1, k);
        } else if (l < k) {
            partition(arr, l+1, last, k);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}