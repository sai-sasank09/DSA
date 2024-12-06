package BinarySearch;

import java.util.*;

// Mock implementation of the MountainArray interface
class MockMountainArray implements MountainArray {
    private int[] arr;

    public MockMountainArray(int[] arr) {
        this.arr = arr;
    }

    @Override
    public int get(int index) {
        return arr[index];
    }

    @Override
    public int length() {
        return arr.length;
    }
}

// MountainArray interface definition
interface MountainArray {
    int get(int index);
    int length();
}

// Main class
public class MountainArraySolution {

    public static int findInMountainArray(int target, MountainArray mArr) {
        int n = mArr.length();
        int peak = findPeak(mArr, 0, n - 1);
        int index = binarySearch(mArr, 0, peak, target, true);
        if (index != -1) {
            return index;
        }
        return binarySearch(mArr, peak + 1, n - 1, target, false);
    }

    private static int binarySearch(MountainArray arr, int l, int r, int target, boolean ascending) {
        while (l <= r) {
            int mid = (l + r) / 2;
            int midVal = arr.get(mid);
            if (midVal == target) {
                return mid;
            }
            if (ascending) {
                if (midVal < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (midVal > target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    private static int findPeak(MountainArray arr, int l, int r) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr.get(mid) < arr.get(mid + 1)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        // Example mountain array and target
        int[] mountainArray = {1, 2, 3, 4, 5, 3, 1};
        int target = 3;

        // Create an instance of the mock MountainArray
        MockMountainArray mArr = new MockMountainArray(mountainArray);

        // Find the target in the mountain array
        int result = findInMountainArray(target, mArr);

        // Print the result
        System.out.println("Target found at index: " + result);
    }
}
