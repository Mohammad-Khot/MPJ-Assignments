import java.util.Scanner;

class Shapes {
    void area(double r) {
        System.out.println("Area of Circle = " + (3.14 * r * r));
    }

    void area(double l, double b) {
        System.out.println("Area of Rectangle = " + (l * b));
    }

    void area(double b, double h, int dummy) {
        System.out.println("Area of Triangle = " + (0.5 * b * h));
    }
}

class Hillstations {
    void famousfood() {
        System.out.println("Famous food of hillstation");
    }

    void famousfor() {
        System.out.println("Famous for scenic beauty");
    }
}

class Manali extends Hillstations {
    void famousfood() {
        System.out.println("Manali: Siddu");
    }

    void famousfor() {
        System.out.println("Manali: Snow and mountains");
    }
}

class Mussoorie extends Hillstations {
    void famousfood() {
        System.out.println("Mussoorie: Momos");
    }

    void famousfor() {
        System.out.println("Mussoorie: Hills and waterfalls");
    }
}

class Gulmarg extends Hillstations {
    void famousfood() {
        System.out.println("Gulmarg: Rogan Josh");
    }

    void famousfor() {
        System.out.println("Gulmarg: Skiing");
    }
}

public class OverrideOverload {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== MENU =====");
        System.out.println("1. Calculate Area (Overloading)");
        System.out.println("2. Hillstation Info (Overriding)");
        System.out.print("Enter choice: ");

        int mainChoice = sc.nextInt();

        switch (mainChoice) {

            case 1:
                Shapes s = new Shapes();

                System.out.println("\nChoose Shape:");
                System.out.println("1. Circle");
                System.out.println("2. Rectangle");
                System.out.println("3. Triangle");

                int shapeChoice = sc.nextInt();

                switch (shapeChoice) {
                    case 1:
                        System.out.print("Enter radius: ");
                        double r = sc.nextDouble();
                        s.area(r);
                        break;

                    case 2:
                        System.out.print("Enter length: ");
                        double l = sc.nextDouble();
                        System.out.print("Enter breadth: ");
                        double b = sc.nextDouble();
                        s.area(l, b);
                        break;

                    case 3:
                        System.out.print("Enter base: ");
                        double base = sc.nextDouble();
                        System.out.print("Enter height: ");
                        double h = sc.nextDouble();
                        s.area(base, h, 1);
                        break;

                    default:
                        System.out.println("Invalid choice");
                }
                break;

            case 2:
                Hillstations h;

                System.out.println("\nChoose Hill Station:");
                System.out.println("1. Manali");
                System.out.println("2. Mussoorie");
                System.out.println("3. Gulmarg");

                int hsChoice = sc.nextInt();

                switch (hsChoice) {
                    case 1:
                        h = new Manali();
                        break;
                    case 2:
                        h = new Mussoorie();
                        break;
                    case 3:
                        h = new Gulmarg();
                        break;
                    default:
                        System.out.println("Invalid choice");
                        sc.close();
                        return;
                }

                h.famousfood();
                h.famousfor();
                break;

            default:
                System.out.println("Invalid choice");
        }

        sc.close();
    }
}
