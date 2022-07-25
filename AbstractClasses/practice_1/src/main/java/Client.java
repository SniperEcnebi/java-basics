public abstract class Client {

    public double bill = 0.0;

    public double getAmount() {
        return bill;
    }

    public void put(double amount) {
        if (amount > 0){
            bill = bill + amount;
        }
    }

    public double take(double amount) {
        if (amount > bill || bill < 0.0){
           return bill;
        }
        else{
            bill = bill - amount;
        }
        return bill;
    }

}
