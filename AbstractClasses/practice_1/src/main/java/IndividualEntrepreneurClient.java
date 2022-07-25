public class IndividualEntrepreneurClient extends Client {


    @Override
    public void put(double amount) {
        if (amount >= 1000){
            amount = amount - ((amount * 0.5) / 100);
            super.put(amount);
        } else {
            amount = amount - (amount / 100);
            super.put(amount);
        }
    }
}
