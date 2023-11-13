package TGame2;
import java.util.Scanner;
public class Main {
    static char input = '\0';
    static int X, Y = 1;
    static Scanner scan = new Scanner(System.in);
    public static void controller() {
        if (input == 'E') {
            Y++;
        }
        else if (input == 'F') {
            X++;
        }
        else if (input == 'S') {
            X--;
        }
        else if (input == 'D') {
            Y--;
        }
        else {
            System.exit(0);
        }
    }
    public static void main(String[] args){
        System.out.println("Загрузка...");
        while (input != 'q') {
            input = scan.next().charAt(0);
            controller();
            System.out.println("Ваши координаты: X=" + X + " Y=" + Y);
        }
    }
}
