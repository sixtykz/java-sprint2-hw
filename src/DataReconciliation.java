import java.util.ArrayList;
import java.util.HashMap;

public class DataReconciliation {
    static HashMap<Integer, ArrayList<MonthlyTransaction>> globalMonthMap = new HashMap<>();
    static HashMap<Integer, ArrayList<yerlyTransaction>> globalYearMap = new HashMap<>();
    static ArrayList <MonthlyTransaction> monthList = new ArrayList<>();
    static ArrayList <yerlyTransaction> yearList = new ArrayList<>();

    public void dataReconciliation() {
        if (globalMonthMap.size() == 0 && globalYearMap.size() == 0) {
            System.out.println("Невозвможно провести сверку итогов!");
            return;
        }

        HashMap<Integer, Integer> monthProfits = new HashMap<>();
        HashMap<Integer, Integer> monthExpenses = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            ArrayList<MonthlyTransaction> local = globalMonthMap.get(i);
            for (int j = 0; j < local.size(); j++){
                MonthlyTransaction item = local.get(j);
                if(item.isExpense) {
                    monthExpenses.put(i, monthExpenses.getOrDefault(i, 0) + item.quantity * item.sumOfOne);
                }else{
                    monthProfits.put(i, monthProfits.getOrDefault(i, 0) + item.quantity * item.sumOfOne);
                }
            }
        }
        HashMap<Integer, Integer> yearProfits = new HashMap<>();
        HashMap<Integer, Integer> yearExpenses = new HashMap<>();

        for (yerlyTransaction key: yearList){
            if(key.isExpense) {
                yearExpenses.put(key.month, key.amount);
            }else{
                yearProfits.put(key.month, key.amount);

            }
        }
        if (monthProfits.size() != yearProfits.size()){
            System.out.println("Ошибка! Файлы с месячными или годовыми отчётами некорректны");
        }
        for (Integer key: monthProfits.keySet()){
            if (!monthProfits.get(key).equals(yearProfits.get(key))){
                System.out.println("Ошибка! Сверка отчётов прошла не успешно");
            }
        }
        if (monthExpenses.size() != yearExpenses.size()){
            System.out.println("Ошибка! Файлы с месячными или годовыми отчётами некорректны");
        }
        for (Integer key: monthExpenses.keySet()){
            if(!monthExpenses.get(key).equals(yearExpenses.get(key))){
                System.out.println("Ошибка! Сверка отчётов прошла не успешно");
            }
        }
    }
}

