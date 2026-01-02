import java.util.*;

public class 구간합 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int n = scanner.nextInt();
        int[] partialSum = new int[size];
        StringBuilder result = new StringBuilder();

        partialSum[0] = scanner.nextInt();
        for(int i = 1; i<size; i++){
            partialSum[i] = partialSum[i-1];
            partialSum[i] += scanner.nextInt();
        }

        for(int i = 0; i<n; i++){
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            result.append(partialSum[to-1] - (from == 1 ? 0 : partialSum[from - 2]));
            result.append(i == n-1 ? "" : '\n');
        }
        System.out.println(result);
    }
}