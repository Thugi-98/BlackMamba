import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int subject = scanner.nextInt();

        double[] scores = new double[subject];
        for (int i = 0; i < subject; i++) {
            scores[i] = scanner.nextDouble();
        }

        double max = 0;
        double sum = 0;

        for (int i = 0; i < subject; i++) {
            
            if (scores[i] > max) {
                max = scores[i];
            }
            
            sum += scores[i];
        }

        System.out.println(sum / max * 100 / subject);
    }
}