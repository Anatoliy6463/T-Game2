package TGame2;

import java.util.Scanner;

public class City {
    static char input = '\0';
    static int X = 100;
    static int Y = 100;
    static double hunger = Main.hunger;
    static int hp = Main.hp;
    static int peaches = Main.peaches;
    static Scanner scan = new Scanner(System.in);
    static int mech  = Main.mech;
    static int armor = Main.armor;
    static int money = Main.money;
    static boolean dragontame = Main.dragontame;
    static boolean depressia = Main.depressia;
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в город! Чтобы выйти с вокзала, нажмите любую клавишу");
        input = scan.next().charAt(0);
        if (input != '\0') check();
    }
    public static void check() {
        if (Main.X == 45 && Main.Y == 20) {
            engine();
        }
        else {
            System.out.println("!!!ВЫ ЧИТЕР!!!");
            System.exit(0);
        }
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
            money-=8;
        }
    }
    public static void sell() {
        System.out.println("Сколько персиков вы хотите продать?");
        int A = 0;
        A = scan.nextInt();
        
        if (A > peaches) {
            A = peaches;
        }
        money += 8 * A;
        peaches-=A;
    }
    public static void peaches() {
        System.out.println("У вас " + peaches + "персиков");
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
    public static void restaurant() {
        System.out.println("Добро пожаловать в наш ресторан! Что вы бы хотели поесть? c = куриные пальчики, r = картошка фри");
        if (input == 'c') {
            money -= 5;
            if (hunger >= 45) {
                hunger -= 45;
            }
            if (hunger < 45) {
                hunger = 0;
            }
        }
        if (input == 'r') {
            money -= 3;
            if (hunger >= 40) {
                hunger -= 40;
            }
            if (hunger < 40) {
                hunger = 0;
            }
        }
    }
    public static void engine() {
        System.out.println("Загрузка...");
        while (input != 'q') {
            input = scan.next().charAt(0);
            controller();
            System.out.println("Ваши координаты: X=" + X + " Y=" + Y + " Уровень голода=" + hunger + " Здоровье= " + hp);
            hunger += 0.5;
            if (hunger > 100) {
                hunger();
            }
            if (hp <= 0) {
                System.out.println("Game over!");
                System.exit(0);
            }
            if (X % 5 == 0 && Y % 5 == 0) {
                System.out.println("Чтобы что-то купить, нажмите H, чтобы что-то продать, нажмите L");
                if (input == 'H') {
                    shop();
                }
                if (input == 'L') {
                    sell();
                }
            }
            if (X % 7 == 0 && Y % 2 == 0) {
                restaurant();
            }
            if (depressia == true) {
                hp -= 20;
                hunger += 20;
            }
            if (X == 100 && Y == 100) {
                System.out.println("Вы хотите вернуться? Y/N");
                if (input == 'Y' || input == 'y') {
                    Main.X = 100;
                    Main.Y = 100;
                    Main.depressia = false;
                    money -= 2;
                    System.out.println("Станция: Персиковая");
                    Main.engine();
                }
                if (input == 'N' || input == 'n') {
                    X = 101;
                    Y = 99;
                }
            }
        }
    }
}
