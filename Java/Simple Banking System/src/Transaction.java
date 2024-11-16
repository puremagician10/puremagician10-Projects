import java.io.Serializable;

public class Transaction implements Serializable{
    private static final long serialVersionUID = 1L;

    private String type;
    private double amount;

    public Transaction(String type, double amount){
        this.type = type;
        this.amount = amount;
    }

    public String getType() { return type; }
    public double getAmount() { return amount; }
}
