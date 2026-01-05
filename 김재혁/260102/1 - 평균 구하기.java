import.java.util.*

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 과묵 개수 입력
        int n = scanner.nextInt();

        // 점수 배열 선언
        double[] score = new double[n];

        // 최고 점수 변수 선언
        double m = 0;

        // 합계 변수 선언
        double sum = 0;

        // 최고 점수 찾기
        for (int i = 0; i < n; i++) {
            score[i] = scanner.nextLong();
            if (score[i] > m) {
                m = score[i];
            }
        }

        // 점수 변환하기
        for (int i = 0; i < n; i++) {
            score[i] = score[i] / m * 100;
            sum += score[i];
        }

        // 결과 출력하기
        System.out.println(sum / n);

    }
}