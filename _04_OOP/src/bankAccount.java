public class bankAccount {

    //Attributes
    private String owner;
    private double balance;

    //Constructors
    public  bankAccount(){}
    public  bankAccount(String owner, double balance){
        this.owner = owner;
    }
    // Methods
    public void increaseBalance(){

    }
    // Setters and getters

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    // Object to String
    @Override
    public String toString() {
        return "bankAccount{" +
                "owner='" + owner + '\'' +
                ", balance=" + balance +
                '}';
    }
}
