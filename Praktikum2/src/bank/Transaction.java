package bank;

abstract class Transaction {
    /**
     * Private Attribute
     */
     protected String date;
     protected String description;
     protected double amount;

    /**
     * Getter Methoden
     * @return // Der Wert des Objektes wird zurückgegeben.
     */

    public String getDate(){return date;}
    public String getDescription(){return description;}
    public double getAmount(){return amount;}

    /**
     * Setter Methoden.
     * @param x  // Es wird der passende Parameter x immer übergeben
     */
    public void setDate(String x){date = x;}
    public void setDescription(String x){description = x;}
    public void setAmount(double x){amount = x;}

    /**
     * Es handelt sich hierbei um den Konstruktor der Abstrakten Klasse Transaction
     * welcher für die beiden Unterklassen Payment und Transfer benutzt wird.
     * @param date // wird in das Attribut date überführt des Objektes.
     * @param description // wird in das Attribut description überführt des Objektes.
     */
     Transaction(String date, String description, double amount){
         this.setDate(date);
         this.setDescription(description);
         this.setAmount(amount);
     }

    /**
     * Überschreibe die toString Methode von der Superklasse, sodass das komplette Objekt ausgegeben wird.
     */
    @Override
    public String toString(){
        return "Date: " + this.getDate() + "\n" + "Description: "
                + this.getDescription();
    }

    /**
     * Vergleicht, ob 2 Objekte der Klasse Transaction gleich sind.
     * @param equal : Gebe ein Objekt der Klasse Transaction an.
     * @return : Es wird ein boolean ausgegeben.
     */

    boolean equals(Transaction equal){
        return (this.getDate() == equal.getDate() && this.getDescription() == equal.getDescription());
    }
}
