package TGame2;
import java.util.Scanner;
public class Main {
    static char input = '\0';
    static int X = 1;
    static int Y = 1;
    static Scanner scan = new Scanner(System.in);
    public static void controller() {
        if (input == 'e') {
            Y++;
        }
        else if (input == 'f') {
            X++;
        }
        else if (input == 's') {
            X--;
        }
        else if (input == 'd') {
            Y--;
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
