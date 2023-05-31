

public class RainWaterTrapped {

    public int trap(final int[] A) {
        int[] leftMaxArr = buildLeftMax(A);
        int[] rightMaxArr = buildRightMax(A);
        int totalTrappedRainWater = 0;
        for (int i = 1; i < A.length - 1; i++) {
            int leftMax = leftMaxArr[i - 1];
            int rightMax = rightMaxArr[i + 1];
            int trappedRainWater = Math.min(leftMax, rightMax) - A[i];

            if (trappedRainWater > 0)
                totalTrappedRainWater += trappedRainWater;
        }

        return totalTrappedRainWater;
    }

    private int[] buildLeftMax(int[] arr) {
        int[] leftMax = new int[arr.length];
        int maxValue = 0;
        for (int i = 0; i < arr.length; i++) {
            leftMax[i] = Math.max(maxValue, arr[i]);
            maxValue = leftMax[i];

        }
        return leftMax;

    }

    private int[] buildRightMax(int[] arr) {
        int[] rightMax = new int[arr.length];
        int maxValue = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            rightMax[i] = Math.max(maxValue, arr[i]);
            maxValue = rightMax[i];
        }
        return rightMax;

    }

    public static void main(String[] args) {
        RainWaterTrapped rainWaterTrapped = new RainWaterTrapped();
        int[] arr = { 1, 2 };
        int ans = rainWaterTrapped.trap(arr);
        System.out.println(ans);

    }
}
