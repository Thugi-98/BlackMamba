import java.util.Arrays;
import java.util.Scanner;

// Caution
// 1. 정답과의 상대/절대 오차는 10-2, 즉 0.01 까지 허용한다.
// 2. 두 번째 줄에 주어지는 수는 공백을 기준으로 주어진다.
// 3. 입력받은 값중 최댓값 M 을 사용하여 모든 점수에 (점수/M)*100 으로 연산한 뒤 새로운 평균을 구해야 한다.

// How to solve
// 배열에 모든 원소를 입력받아 저장 후 Arrays 패키지에 sort()사용해서 오름차순 정렬
public class 평균구하기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
		double arr[] = new double[scanner.nextInt()];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextDouble();
		}
		scanner.close();
		
		double sum = 0;
		Arrays.sort(arr);
		
		for(int i = 0; i < arr.length; i++) {
			sum += ((arr[i] / arr[arr.length-1]) * 100);
		}
		System.out.print(sum / arr.length);
        
    }
}
