package boxes;

public class Thing {

    private String name;
    private int weight;

    public Thing(String name, int weight) {
        if (weight < 0) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.weight = weight;
    }

    public Thing(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        Thing thing = (Thing) o;

        if (this.name == null || !this.name.equals(thing.getName())) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        if (this.name == null) {
            return 7;
        }

        return this.name.hashCode();
    }



}
