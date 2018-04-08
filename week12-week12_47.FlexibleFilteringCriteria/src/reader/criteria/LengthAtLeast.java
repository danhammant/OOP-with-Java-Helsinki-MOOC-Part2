package reader.criteria;


public class LengthAtLeast implements Criterion {
    private int lengthAtLeast;

    public LengthAtLeast(int lengthAtLeast) {
        this.lengthAtLeast = lengthAtLeast;
    }

    @Override
    public boolean complies(String line) {
        return line.length() >= lengthAtLeast;
    }
}
