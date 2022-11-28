package bank;

public class OutgoingTransfer extends Transfer {
    public OutgoingTransfer(String date1, double amount1, String description1) {
        super(date1, amount1, description1);
    }
    public OutgoingTransfer(String date1, double amount1, String description1, String sender1, String recipient1){
        super(date1, amount1, description1, sender1, recipient1);
    }

    @Override
    public double calculate(){
        double amount = -(getAmount());
        return amount;
    }
}
