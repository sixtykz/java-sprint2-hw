public class MonthlyTransaction {

    String itemName;
    boolean isExpense;
    int quantity;
    int sumOfOne;

    public MonthlyTransaction(String itemName, boolean isExpense, int quantity, int sumOfOne) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }
}