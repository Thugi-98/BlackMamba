import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        int[] numArray = new int[size];

        String[] strArray = br.readLine().split(" ");
        for (int i = 0; i < size; i++) {
            numArray[i] = Integer.parseInt(strArray[i]);
        }

        Arrays.sort(numArray);

        int answer = 0;

        for (int i = 0; i < size; i++) {

            int target = numArray[i];

            int startPoint = 0;
            int endPoint = target - 1;

            while (true) {

                if (startPoint == endPoint) {
                    break;
                }

                int add = numArray[startPoint] + numArray[endPoint];

                if (add == target) {
                    answer++;
                    break;
                }

                if (add > target) {
                    endPoint--;
                } else if (add < target) {
                    startPoint++;
                }
            }
        }

        System.out.println(answer);
    }
}