package bank;

public class Payment extends Transaction implements CalculateBill{

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
    public void setIncomingInterest(double x){
    if(x >= 0 && x <= 1){
            incomingInterest = x;
        }
            else{
            System.out.println("Fehler: Es muss ein Wert zwischen 0 - 1 getroffen werden! Wert auf 0 gesetzt");
            this.setIncomingInterest(0);
        }
    }
    /**
     * Set the Attribute OutGoingInterst.
     * @param x : double Parameter has to be between 0 and 1.
     */
    public void setOutGoingInterest(double x){
        if(x >= 0 && x <= 1){
            outGoingInterest = x;
        }
        else{
            System.out.println("Fehler: Es muss ein Wert zwischen 0 - 1 getroffen werden! Wert wurde auf 0 gesetzt");
            this.setOutGoingInterest(0);
        }
    }

    /**
     * Payment Constructor
     * @param date1 : Set date
     * @param amount1 : Set amount
     * @param description1 : Set description
     * Other parameter are set 0.
     */
    public Payment(String date1, double amount1, String description1){
        super(date1,description1,amount1);
        this.setIncomingInterest(0);
        this.setOutGoingInterest(0);
    }

    /**
     * Payment Constructor
     * @param date1 : set date
     * @param amount1 : set amount
     * @param description1 : set description
     * @param incomingInterest1 : set incomingInterest
     * @param outGoingInterest1 : set outGoingInterst
     */
    public Payment(String date1, double amount1, String description1, double incomingInterest1, double outGoingInterest1){
        super(date1,description1, amount1);
        this.setIncomingInterest(incomingInterest1);
        this.setOutGoingInterest(outGoingInterest1);
    }

    /**
     * Copy Konstruktor um ein Objekt der Klasse Payment zu kopieren.
     */
    public Payment(Payment copy){
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
                + this.getOutGoingInterest() + "\n" + "Betrag: " + this.calculate() + "\n";
    }

    /**
     * Überschreibt die equals der Superklasse.
     * Vergleicht, ob 2 Objekte der Klasse Payment gleich sind oder nicht.
     * @param equal : Übergebe ein Objekt der Klasse Payment.
     * @return : Es wird ein Boolean zurückgegeben.
     */
    public boolean equals(Payment equal){
      if(this == null || equal == null){
          return false;
      }
          return (super.equals(equal) && this.getAmount() == equal.getAmount() && this.getIncomingInterest() == equal.getIncomingInterest() && this.getOutGoingInterest() == equal.getOutGoingInterest());
    }
}