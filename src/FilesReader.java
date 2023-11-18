import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilesReader {
    public void monthFilesReader() {
        for (int i = 1; i <= 3; i++) {
            DataReconciliation.monthList = readMonthFiles("resources/m.20210" + i + ".csv");
            DataReconciliation.globalMonthMap.put(i, DataReconciliation.monthList);
        }
    }

    public void yearFilesReader() {
        int yearName = 2021;
        DataReconciliation.yearList = readYearFiles("resources/y." + yearName + ".csv");
        DataReconciliation.globalYearMap.put(yearName, DataReconciliation.yearList);
    }

    public ArrayList<MonthlyTransaction> readMonthFiles(String path) {
        ArrayList<MonthlyTransaction> months = new ArrayList<>();
        List<String> content = readFileContents(path);
        for (int j = 1; j < content.size(); j++) {
            String[] parts = content.get(j).split(",");
            String itemName = parts[0];
            boolean isExpense = Boolean.parseBoolean(parts[1]);
            int quantity = Integer.parseInt(parts[2]);
            int sumOfOne = Integer.parseInt(parts[3]);

            months.add(new MonthlyTransaction(itemName, isExpense, quantity, sumOfOne));
        }
        return months;
    }

    public ArrayList<yerlyTransaction> readYearFiles(String path) {
        ArrayList<yerlyTransaction> years = new ArrayList<>();
        List<String> content = readFileContents(path);
        for (int i = 1; i < content.size(); i++) {
            String line = content.get(i);
            String[] parts = line.split(",");
            int month = Integer.parseInt(parts[0]);
            int amount = Integer.parseInt(parts[1]);
            boolean isExpense = Boolean.parseBoolean(parts[2]);

            years.add(new yerlyTransaction(month, amount, isExpense));
        }
        return years;
    }

    List<String> readFileContents(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
            return Collections.emptyList();
        }
    }
}