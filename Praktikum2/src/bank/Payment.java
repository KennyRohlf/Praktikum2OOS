package bank;

import java.util.Objects;
import bank.exceptions.*;

public class Payment extends Transaction{

    /**
     * Die Attribute der Objekte.
     */

    private double incomingInterest;
    private double outGoingInterest;

    /**
     * @return : get the Attribute incomingInterest.
     */
    public double getIncomingInterest(){return incomingInterest;}

    /**
     * @return : get the Attribute outGoingIntrest.
     */
    public double getOutGoingInterest(){return outGoingInterest;}

    /**
     * Set the Attribute IncomingInterest.
     * @param x : double Parameter has to be between 0 and 1.
     */
    public void setIncomingInterest(double x) throws AttributeException{
    if(x >= 0 && x <= 1){
            incomingInterest = x;
        }
            else{
        throw new AttributeException("OutGoingInterest nicht zwischen 0 und 1!");
        }
    }
    /**
     * Set the Attribute OutGoingInterst.
     * @param x : double Parameter has to be between 0 and 1.
     */
    public void setOutGoingInterest(double x) throws AttributeException{
        if(x >= 0 && x <= 1){
            outGoingInterest = x;
        }
        else{
            throw new AttributeException("OutGoingInterest nicht zwischen 0 und 1!");
        }
    }

    /**
     * Payment Constructor
     * @param date1 : Set date
     * @param amount1 : Set amount
     * @param description1 : Set description
     * Other parameter are set 0.
     */
    public Payment(String date1, double amount1, String description1) throws AttributeException{
        super(date1,description1,amount1);
        this.setIncomingInterest(0);
        this.setOutGoingInterest(0);

        if(amount1 == 0){
            throw new AttributeException("Amount darf nicht 0 sein!");
        }
    }

    /**
     * Payment Constructor
     * @param date1 : set date
     * @param amount1 : set amount
     * @param description1 : set description
     * @param incomingInterest1 : set incomingInterest
     * @param outGoingInterest1 : set outGoingInterst
     */
    public Payment(String date1, double amount1, String description1, double incomingInterest1, double outGoingInterest1) throws AttributeException {
        this(date1, amount1, description1);
        this.setIncomingInterest(incomingInterest1);
        this.setOutGoingInterest(outGoingInterest1);

        if (amount1 == 0) {
            throw new AttributeException("Amount darf nicht 0 sein!");
        }
        else if(!(incomingInterest1 >= 0 && incomingInterest1 <= 1) || !(outGoingInterest1 >= 0 && outGoingInterest1 <= 1)){
            throw new AttributeException("outGoingInterest/inComingInterest Fehler!");
        }
    }
    /**
     * Copy Konstruktor um ein Objekt der Klasse Payment zu kopieren.
     */
    public Payment(Payment copy) throws AttributeException{
       this(copy.getDate(),copy.getAmount(),copy.getDescription(),copy.getIncomingInterest(),copy.getOutGoingInterest());
    }

    /**
     * Überschreibe die calculate Methode der Superklasse.
     * Hier wird eine Berechnung angestellt auf Basis der Amount und der IncomingInterest bzw der OutgoingInterest berechnet.
     * @return : Es wird das Ergebnis als Double Wert zurückgegeben.
     */
    @Override
    public double calculate() {
        double sum;
        if(this.getAmount() >= 0) {
            sum = this.getAmount() - (this.getAmount() * this.getIncomingInterest());
        }
        else {
            sum = this.getAmount() + (this.getAmount() * this.getOutGoingInterest());
        }
        return sum;
    }

    /**
     * Überschreibe die toString Methode der Superklasse.
     * Hier werden die Attribute vom Objekt Payment ausgegeben.
     */

    public String toString(){
        System.out.println(super.toString());
        return "IncomingInterest: " + this.getIncomingInterest() + "\n" + "OutGoingInterest: "
                + this.getOutGoingInterest() + "\n";
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Payment payment = (Payment) o;
        return Double.compare(payment.incomingInterest, incomingInterest) == 0 && Double.compare(payment.outGoingInterest, outGoingInterest) == 0;
    }
}