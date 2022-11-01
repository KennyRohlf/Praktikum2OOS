package bank;

public class Transfer extends Transaction implements CalculateBill{

    /**
     * Attribute der Objekte aus der Klasse Transfer.
     */
    private double amount;
    private String sender;
    private String recipient;

    /**
     * Getter Methoden um auf die Attribute zugreifen zu können.
     */

    public double getAmount(){return amount;}
    public String getSender(){return sender;}
    public String getRecipient(){return recipient;}

    /**
     * Setter Methode um über den Parameter x einen neuen Wert in die Attribute zu speichern.
     * Für Amount muss der Wert mindestens >= 0 sein.
     */

    public void setAmount(Double x){
        if(x >= 0){
            this.amount = x;
        }
        else{
            System.out.println("Es würden nur positive Werte verwendet werden! Rufen sie die Methode erneut auf");
        }
    }
    public void setSender(String x){sender = x;}
    public void setRecipient(String x){recipient = x;}

    /**
     * Konstruktoren zur Erstellung der Objekte der Klasse.
     * Der Wert Amount darf dabei keinen Wert < 0 enthalten.
     */
    public Transfer(String date1, double amount1, String description1){
        super(date1,description1);
        this.setAmount(amount1);
        this.setSender("Anonym");
        this.setSender("Anonym");
    }

    public Transfer(String date1, double amount1, String description1, String sender1, String recipient1){
        super(date1,description1);
        this.setAmount(amount1);
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
     * @param equal : Erwartet ein Parameter von der Klasse Transfer.
     * @return : Gibt einen Boolean zurück.
     */
    boolean equals(Transfer equal){
        return (super.equals(equal) && this.getAmount() == equal.getAmount() && this.getSender() == equal.getSender() && this.getRecipient() == equal.getRecipient());
    }
}