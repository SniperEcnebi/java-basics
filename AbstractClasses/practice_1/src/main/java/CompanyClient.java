public class CompanyClient extends Client {

    @Override
    public double take(double amount) {
        if (bill < amount){
            return bill;
        }
        else {
            double gg = amount/ 100;
            bill = super.take(amount) - gg;


        }
        return bill;
    }
}
