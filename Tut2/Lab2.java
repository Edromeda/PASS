import java.util.Scanner;
public class Lab2{
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        String s;
        char c;
        String proxy;
        ThreeInts t = new ThreeInts();

        System.out.println("/t WHERE'S THE MIDDLE??");
        System.err.println("Play?");
         s = sc.nextLine();
         c = s.charAt(0);
        
         while((c=='Y') || (c =='y')){
            System.out.print("Enter Value 1: ");
            t.a = sc.nextInt();
            System.out.print("Enter Value 2: ");
            t.b = sc.nextInt();
            System.out.print("Enter Value 3: ");
            t.c = sc.nextInt();
            proxy = sc.nextLine();
         }
         if( (c == 'N') || (c== 'n')){
              System.out.println("Thanks for playing!");
              break;
         }

        

    }
}