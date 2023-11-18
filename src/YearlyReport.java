import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {
    public void printYearlyReport(){
        if (DataReconciliation.globalYearMap.size() == 0){
            System.out.println("Ошибка в считывании годового отчёта. Попробуйте снова");
        return;
        }
        int profit = 0;
        int expense = 0;
        int valueOfProfits = 0;
        int valueOfExpenses = 0;

        HashMap<Integer, Integer> localMap = new HashMap<>();
        ArrayList<Integer> profits = new ArrayList<>();
        ArrayList<Integer> expenses = new ArrayList<>();

        for (Year checker: DataReconciliation.yearList){
            if(!checker.isExpense){
                valueOfProfits = checker.amount;
                profit += checker.amount;
                profits.add(valueOfProfits);
            }else {
                valueOfExpenses = checker.amount;
                expense += checker.amount;
                expenses.add(valueOfExpenses);
            }
            checker.amount = valueOfProfits - valueOfExpenses;
            localMap.put(checker.month, checker.amount);
        }
        for (Integer yearName : DataReconciliation.globalYearMap.keySet()){
            System.out.println("Год" + yearName);

            for (int i = 1; i < 4; i++){
                System.out.println("Месяц" + i + "\nДоход" + localMap.get(i));
            }
        }

        int averageExpense = expense / expenses.size();
        int averageProfit = profit / profits.size();
        System.out.println();
        System.out.println("Средний расход:" + averageExpense);
        System.out.println("Средний доход:" + averageProfit);
    }
}
