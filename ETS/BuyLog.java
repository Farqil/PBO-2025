public class BuyLog{
    private String coffeeName;
    private int price;
    private int stock;
    private int income;

    public BuyLog(String coffeeName, int price, int stock, int income){
        this.coffeeName = coffeeName;
        this.price = price;
        this.stock = stock;
        this.income = income;
    }

    public String getCoffeeName(){
        return coffeeName;
    }

    public int getPrice(){
        return price;
    }

    public int getStock(){
        return stock;
    }

    public int getIncome(){
        return income;
    }
}