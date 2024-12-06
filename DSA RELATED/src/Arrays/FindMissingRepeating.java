package Arrays;
import java.util.*;

public class FindMissingRepeating {
    public int sumOfUnique(int arr[]) {
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i])) {
                sum += arr[i];
                set.add(arr[i]);
            }
        }
        return sum;
    }

    public int[] findTwoElements(int arr[], int n) {
        Arrays.sort(arr);
        int repeating = -1;
        int missing = -1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                repeating = arr[i];
                break;
            }
        }

        int uniqueSum = sumOfUnique(arr);
        int realSum = n * (n + 1) / 2;
        missing = realSum - (uniqueSum);

        return new int[] { repeating, missing };
    }

    public static void main(String[] args) {
        FindMissingRepeating finder = new FindMissingRepeating();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.print("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] result = finder.findTwoElements(arr, n);
        System.out.println("Repeating number: " + result[0]);
        System.out.println("Missing number: " + result[1]);
    }
}
