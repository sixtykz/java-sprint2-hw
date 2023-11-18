
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static FilesReader filesReader = new FilesReader();
    static DataReconciliation dataReconciliation = new DataReconciliation();
    static MonthlyReport monthlyReport = new MonthlyReport();
    static YearlyReport yearlyReport = new YearlyReport();
    public static void main(String[] args) {

        while (true) {
            System.out.println("Что вы хотите сделать?");

            printMenu();
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    filesReader.monthFilesReader();
                    System.out.println("Все месячные отчёты успешно считаны!");
                    break;
                case 2:
                    filesReader.yearFilesReader();
                    System.out.println("Годовой отчёт успешно считан!");
                    break;
                case 3:
                    dataReconciliation.dataReconciliation();
                    System.out.println("Отчёты сходятся");
                    break;

                case 4:
                    monthlyReport.monthlyReport();
                    break;

                case 5:
                    yearlyReport.printYearlyReport();
                    break;

                case 6:
                    System.out.println("Выход!");
                    break;

                default:
                    System.out.println("Извините, такой команды нет!");

                    return;
            }
        }
    }


        public static void printMenu () {
            System.out.println("1 - Считать все месячные отчёты\n2 - Считать годовой отчёт");
            System.out.println("3 - Сверить отчёты\n4 - Вывести информацию о всех месячных отчётах");
            System.out.println("5 - Вывести информацию о годовом отчёте");
            System.out.println("6 - Выход");
        }
    }
