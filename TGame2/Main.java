package TGame2;
import java.util.Scanner;
public class Main {
    static char input = '\0';
    static int X = 1;
    static int Y = 1;
    static double hunger = 0;
    static int hp = 100;
    static int peaches = 0;
    static Scanner scan = new Scanner(System.in);
    static int mech, armor = 0;
    static int money = 100;
    static int dragonhp = 1000;
    static boolean dragontame = false;
    static boolean depressia = false;
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в T-Game2! Чтобы начать игру, нажмите любую клавишу");
        input = scan.next().charAt(0);
        if (input != '\0') engine();
    }
    public static void hunger() {
        hp-=30;
    }
    public static void shop() {
        System.out.println("Чтобы купить меч, нажмите w, чтобы купить броню, нажмите r, чтобы купить персики, нажмите r");
        input = scan.next().charAt(0);
        if (input == 'w') {
            money-=10;
            mech = 1;
        }
        if (input == 'r') {
            money-=10;
            armor = 1;
        }
        if (input == 'a') {
            peaches++;
            money-=5;
        }
        return;
    }
    public static void sell() {
        System.out.println("Сколько персиков вы хотите продать?");
        int A = 0;
        A = scan.nextInt();
        
        if (A > peaches) {
            A = peaches;
        }
        money += 3 * A;
        peaches-=A;
    }
    public static void peaches() {
        System.out.println("У вас " + peaches + "персиков");
        return;
    }
    public static void dragon() {
        if (armor == 0) {
            hp -= 5;
        }
        if (armor == 1) {
            hp -= 2;
        }
        if (mech == 0 && input == 'k' && dragontame == false) {
            dragonhp -= 4;
        }
        if (mech == 1 && input == 'k' && dragontame == false) {
            dragonhp -= 10;
        }
        if (armor == 1 && input == 't' && peaches >= 10) {
            dragonhp -= 15;
            peaches -= 10;
            dragontame = true;
            System.out.println("Вы приручили дракона!");
            money += 100;
        }
        if (dragonhp <= 0) {
            System.out.println("Вы победили дракона!");
            money += 50;
            depressia = true;
        }
    }
    public static void eat() {
        peaches--;
        if (hunger >= 30){
            hunger -= 30;
        }
        else hunger = 0;
    }
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
        else if (input == 'a' && peaches > 0) {
            eat();
        }
        else if (input == 'a' && peaches == 0) {
            System.out.println("У вас нет персиков");
            hunger += 0.25;
        }
        else if (input == 'p' && peaches > 0) {
            peaches();
        }
        else if (input == 'p' && peaches < 0) {
            System.out.println("У вас нет персиков!");
            hunger += 0.15;
        }
    }
    public static void engine() {
        System.out.println("Загрузка...");
        while (input != 'q') {
            input = scan.next().charAt(0);
            controller();
            System.out.println("Ваши координаты: X=" + X + " Y=" + Y + " Уровень голода=" + hunger + " Здоровье= " + hp);
            if (Y % 6 == 0 && Y != 0 || X % 6 == 0 && X != 0) {
                peaches++;
                System.out.println("Вы нашли персик! Теперь у вас " + peaches + "персиков");
            }
            hunger += 0.5;
            if (hunger > 100) {
                hunger();
            }
            if (hp <= 0) {
                System.out.println("Game over!");
                System.exit(0);
            }
            if (X == 19 && Y == 21) {
                System.out.println("Чтобы что-то купить, нажмите H, чтобы что-то продать, нажмите L");
                if (input == 'H') {
                    shop();
                }
                if (input == 'L') {
                    sell();
                }
            }
            if (X >= 50 && X <= 69 && Y >= 59 && Y <= 69) {
                dragon();
            }
            if (depressia == true) {
                hp -= 20;
                hunger += 20;
            }
        }
    }
}
