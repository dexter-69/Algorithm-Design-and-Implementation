import java.util.Scanner;
class findy {
    void count_loneliness(int num,int []a) {
        int pos = 1;
        while(num != 0) {
            if((num & 1) != 0) {
                ++a[pos-1];
                a[pos-1] %= 3;
            }
            ++pos;
            num >>>= 1;
        }
    }
}
public class lonelynumber {
    public static void main(String []args) {
        Scanner scan = new Scanner(System.in);
        int []a = new int [32];
        System.out.println("Enter no of element");
        int n = scan.nextInt();
        for(int i = 0; i < n; i++) {
            int num = scan.nextInt();
            findy obj = new findy();
            obj.count_loneliness(num,a);
        }
        scan.close();
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
