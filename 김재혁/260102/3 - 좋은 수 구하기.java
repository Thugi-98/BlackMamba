import.java.util.*

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 수의 개수 n 지정 ( 1 <= n <= 2000 )
        int n = scanner.nextInt();

        // 숫자 입력받기 (n회)
        int[] number = new int[n];
        for(int i = 0; i < n; i++) {
            number[i] = scanner.nextInt();
        }

        // 결과 저장 변수 선언
        int result = 0;

        // 좋은 수 탐색하기
        for (int i = 0; i < n; i++) {

            // 좋은 수 지정
            int goodNum = number[i];

            // 좋은 수를 탐색하는 반복문을 작성할 때에는 본인이 "다른 두 수"에 포함이 되면 안 됨
            // 그래서 좋은 수의 기준인 number[i]를 "다른 두 수"에 포함시키는 경우 X
            // 또한 탐색은 이중 반복문이기 때문에, 탐색 전 result와 탐색 후 result가 다를 경우 추가 탐색 X

            for (int j = 0; j < n; j++) {

                // 기준 값 지정
                int std = result;
                for (int k = 1; j + k < n; k++) {

                    // number[i]를 "다른 두 수"에 포함시키는 경우
                    if (j == i || j + k == i)
                        break;

                    // 좋은 수의 기준에 부합하는 경우
                    if (number[j] + number[j + k] == goodNum) {
                        result++;
                        break;
                    }
                }

                // 기준 값이 바뀌었을 경우 - "number[i]가 좋은 수인 경우"에 대한 탐색 즉시 중지
                if (std != result) break;
            }
        }

        // 결과 출력
        System.out.println(result);

    }
}