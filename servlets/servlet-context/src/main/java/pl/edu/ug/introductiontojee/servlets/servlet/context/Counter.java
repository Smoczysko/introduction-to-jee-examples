package pl.edu.ug.introductiontojee.servlets.servlet.context;

public class Counter {
    private int value;

    public Counter () {
        this.value = 0;
    }

    public int get() {
        return value;
    }

    public void set(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }
}
