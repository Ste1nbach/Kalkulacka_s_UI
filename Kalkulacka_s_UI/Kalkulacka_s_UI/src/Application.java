import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;

public class Application {

    public static void printMenu() {
        System.out.println("Kalkulačka s UI");
        System.out.println("Kalkulačka se ovládá pomocí numerické klávesnice");

        System.out.println("[START]");
        System.out.println("Jestli chcete zapnout kalkulačku napište 1");
    }


    public static void Calculate(int x) {
        Scanner sc = new Scanner(System.in);

        double result;
        int num;
        double remember = 0;
        while (x == 1) {
            System.out.println("Kolik cisel chces zadat?");
            int count = sc.nextInt();

            System.out.println("Zadejte první číslo");
            result = sc.nextDouble();
            if (count == 1) {
                System.out.println("Jestli chcete mocnit napište p a jestli chcete odmocnit napište s");
                String a = sc.next().trim().toLowerCase(Locale.ROOT);


                switch (a) {

                    case "p":
                        System.out.println("Na kolikátou chce mocnit ?");
                        num = sc.nextInt();
                        result = Math.pow(result, num);
                        if (result % num == 0) {
                            System.out.println((int) result);
                        } else {
                            System.out.println(result);
                        }
                        break;
                    case "s":
                        result = Math.sqrt(result);
                        System.out.println(result);
                }


            } else {
                for (int i = 0; i < count - 1; i++) {

                    System.out.println("Zadejte  číslo");
                    double num2 = sc.nextDouble();


                    System.out.println("Napište + pro scitani, - pro odcitani, / pro deleni nebo * pro nasobeni.");
                    String metods = sc.next().trim();


                    switch (metods) {
                        case "+":
                            result += num2;
                            break;
                        case "-":
                            result -= num2;
                            break;
                        case "*":
                            result *= num2;
                            break;
                        case "/":
                            result /= num2;
                            break;
                        default:
                            System.out.println("Error: Zadal jste chybnou operaci");
                            i = count;
                            break;

                    }

                    if (i == (count - 2)) {
                        System.out.println("Konecny vysledek je: " + result);
                    }

                }
            }


            System.out.println("Chcete zacit znovu? Pokud ano napište 1.");
            x = sc.nextInt();
        }

        System.out.println("KONEC");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        printMenu();
        Calculate(sc.nextInt());


    }
}
