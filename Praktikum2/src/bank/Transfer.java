package bank;

public class Transfer extends Transaction implements CalculateBill{

    /**
     * Attribute
     */
    private String sender;
    private String recipient;


    /**
     * @return : returns the Attribute sender.
     */
    public String getSender(){return sender;}

    /**
     * @return retuns the Attribute recipient.
     */
    public String getRecipient(){return recipient;}

    /**
     * Set the attribute amount. It has to be 1 or higher.
     * @param x : double parameter to set amount.
     */
    public void setAmount(double x){
        if (x <= 0){
            System.out.println("Der Wert muss größer 0 sein! Wert wird auf 1 gesetzt." + "\n");
            this.amount = 1;
        }
        else {
            this.amount = x;
        }
    }

    /**
     * @param x : String parameter to set sender.
     */
    public void setSender(String x){sender = x;}

    /**
     * @param x : String parameter to set rexipient.
     */
    public void setRecipient(String x){recipient = x;}

    /**
     * Transfer constructor
     * @param date1 : set the date
     * @param amount1 : set the amount
     * @param description1 : set the description.
     * Other 2 parameter are set "Anonym"
     */
    public Transfer(String date1, double amount1, String description1){
        super(date1,description1, amount1);
        this.setSender("Anonym");
        this.setSender("Anonym");
    }

    /**
     * Transfer constructor
     * @param date1 : Set date
     * @param amount1 : Set amount
     * @param description1 : set description
     * @param sender1 : set Sender
     * @param recipient1 : set recipient
     */
    public Transfer(String date1, double amount1, String description1, String sender1, String recipient1){

        super(date1,description1,amount1);
        this.setSender(sender1);
        this.setRecipient(recipient1);
    }

    /**
     * Copy-Konstruktor zur Kopierung Objekte der Klasse Transfer
     */
    public Transfer(Transfer copy){
    this(copy.getDate(),copy.getAmount(),copy.getDescription(),copy.getSender(),copy.getRecipient());
    }

    /**
     * Hier wird eine Berechnung für die Kalkulation ausgeführt. Da diese noch nicht ausgereift ist macht sie noch nicht viel.
     * @return : Gibt den Wert als double zurück.
     */
    @Override
    public double calculate() {
        return this.getAmount();
    }

    /**
     * Die toString Methode wird überschrieben und es gibt alle Attribute des Objektes Transfer zurück.
     */
    public String toString(){
        System.out.println(super.toString());
        return "Sender: " + this.getSender() + "\n" + "Recipient: " + this.getRecipient() + "\n"
                + "Betrag: " + this.calculate() + "\n";
    }

    /**
     * Vergleicht 2 Objekte der Klasse Transfer miteinander.
     * @param other : Erwartet ein Parameter von der Klasse Transfer.
     * @return : Gibt einen Boolean zurück.
     */
    @Override
    public boolean equals(Object other){
        if(other instanceof Transfer equals){
            return (super.equals(equals) && this.sender == equals.sender && this.recipient == equals.recipient);
        }
        else{
            return false;
        }
    }
}