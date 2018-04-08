import java.util.HashMap;

public class PromissoryNote {
    private HashMap<String, Double> promissory;

    public PromissoryNote() {
        this.promissory = new HashMap<String, Double>();
    }

    public void setLoan(String toWhom, double value) {
        this.promissory.put(toWhom, value);
    }

    public double howMuchIsTheDebt(String whose) {
        if (this.promissory.containsKey(whose)) {
            return this.promissory.get(whose);
        }

        return 0;
    }
}
