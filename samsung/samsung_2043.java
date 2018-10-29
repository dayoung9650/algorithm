import java.util.Scanner;

public class samsung_2043 {
    public static  void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int p = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());
        int cnt = 0;

        for(int i = k ; i <= p; i++){
            if(p == k){
                break;
            }
        }
        System.out.println(cnt);
    }
}