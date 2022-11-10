import bank.Transfer;
import bank.Payment;

public class main {
    public static void main(String[] args){

    Payment payment1 = new Payment("2.8.2000", 1000, "Betrag sollte = 950€ sein", 0.05, 0.1);
    Payment payment2 = new Payment("3.8.2000",-1000, "Betrag sollte = -1100€ sein", 0.05, 0.1);
    Payment payment3 = new Payment(payment2);

    Transfer transfer1 = new Transfer("4.8.2000",999, "Betrag sollte = 999€ sein", "Ich","Du");
    Transfer transfer2 = new Transfer("4.8.2000",-100, "Betrag sollte = 999€ sein", "Ich","ich");
    Transfer transferCopy = new Transfer(transfer1);

    System.out.println("Payment1: " + payment1.calculate());
    System.out.println("Payment2: " + payment2.calculate());
    System.out.println("Transfer1: " + transfer1.calculate() + "\n");

    System.out.print(payment1 + "\n");
    System.out.println(payment2 + "\n");
    System.out.print(transfer1 + "\n");

    payment3.equals(payment2);
    System.out.println(payment3.equals(payment1)); // False

    System.out.println(transfer1.equals(transfer2)); //False
    System.out.println(transfer1.equals(transferCopy)); //False
    }
}