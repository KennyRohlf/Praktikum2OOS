package bank;

public class IncomingTransfer extends Transfer{

    public IncomingTransfer(String date1, double amount1, String description1){
        super(date1, amount1, description1);
    }

    public IncomingTransfer(String date1, double amount1, String description1, String sender1, String recipient){
        super(date1, amount1, description1, sender1, recipient);
    }

    @Override
    public double calculate(){
        double amount = getAmount();
        return amount;
    }
}
