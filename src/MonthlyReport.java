import java.util.HashMap;

public class MonthlyReport {
    public void monthlyReport(){
        if (DataReconciliation.globalMonthMap.size() == 0){
            System.out.println("Вы не считали месячный отчёт. Пожалуйста, попробуйте снова ");
            return;
        }

        for (Integer month: DataReconciliation.globalMonthMap.keySet()){
            DataReconciliation.monthList = DataReconciliation.globalMonthMap.get(month);
            System.out.println("Месяц" + month);
            HashMap <String, Integer> profits = new HashMap<>();
            HashMap <String, Integer> expenses = new HashMap<>();

            for (MonthlyTransaction sort: DataReconciliation.monthList){
                if (sort.isExpense){
                    expenses.put(sort.itemName, (sort.quantity*sort.sumOfOne));
                }else{
                    profits.put(sort.itemName, (sort.quantity*sort.sumOfOne));
                }
            }

            String product = "";
            Integer maxNum = 0;
            for (String prod: profits.keySet()){
                Integer iterator = profits.get(prod);
                if (iterator> maxNum){
                    maxNum = iterator;
                    product = prod;
                }
            }
            System.out.println("Самый прибыльный товар:" + product + "на сумму:" + maxNum);

            Integer maximum = 0;
            for (String prod: expenses.keySet()){
                Integer iterator = expenses.get(prod);
                if (iterator>maximum){
                    maximum=iterator;
                    product=prod;
                }
            }
            System.out.println("Самая большая трата" + maximum + "на товар:" + product);
        }
    }
}
