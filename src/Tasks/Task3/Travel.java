package Tasks.Task3;

public class Travel {
    public Eopie eopie;
    public Container container;

    public Travel(Eopie eopie, Container container) {
        this.eopie = eopie;
        this.container = container;
    }

    @Override
    public String toString() {
        return "Travel{" +
                "eopie=" + eopie +
                ", container=" + container +
                '}';
    }
}
