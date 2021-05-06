package Tasks.Task3;

/**
 * The type Travel.
 */
public class Travel {
    /**
     * The Eopie.
     */
    public Eopie eopie;
    /**
     * The Container.
     */
    public Container container;

    /**
     * Instantiates a new Travel.
     *
     * @param eopie     the eopie
     * @param container the container
     */
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
