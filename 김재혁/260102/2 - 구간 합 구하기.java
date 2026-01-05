import.java.util.*

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 수의 개수 n ( 1 <= n <= 100000 )
        int n = scanner.nextInt();
        if (n < 1 || n > 100000) { throw new RuntimeException("n 값이 범위를 벗어났습니다."); }

        // 합을 구해야 하는 횟수 m ( 1 <= m <= 100000 )
        int m = scanner.nextInt();
        if (m < 1 || m > 100000) { throw new RuntimeException("m 값이 범위를 벗어났습니다."); }

        // 기준 배열 선언
        int[] number = new int[n];

        // 결과 배열 선언
        int[] result = new int[m];

        // n개의 수 입력받기 ( 0 <= number[i] <= 1000 )
        for (int i = 0; i < n; i++) {
            number[i] = scanner.nextInt();
            if (number[i] < 0 || number[i] > 1000) { throw new RuntimeException("수가 범위를 벗어났습니다."); }
        }

        // i부터 j까지의 계산 범위를 입력받고 결과 저장(m회)
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;

            for (int j = a; j <= b; j++) {
                result[i] += number[j];
            }
        }

        // 결과 출력
        for (int a = 0; a < m; a++) {
            System.out.println("결과: " + result[a]);
        }

    }
}