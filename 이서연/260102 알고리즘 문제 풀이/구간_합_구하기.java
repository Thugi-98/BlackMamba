import java.io.IOException;
import java.util.Scanner;

class 구간_합_구하기 {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int times = scanner.nextInt();

        int[] sumArray = new int[size];

        for (int i = 0; i < size; i++) {
            
            int num = scanner.nextInt();

            if (i == 0) {
                sumArray[i] = num;
                continue;
            }

            sumArray[i] = sumArray[i-1] + num;
        }

        for (int i = 0; i < times; i++) {

            int start = scanner.nextInt();
            int end = scanner.nextInt();

            int answer = start == 1 ? sumArray[end-1] : sumArray[end-1] - sumArray[start-2];

            System.out.println(answer);
        }
    }
}