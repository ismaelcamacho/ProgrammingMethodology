package Tasks.Task3;

/**
 * The type Eopie.
 */
public class Eopie {
    /**
     * The Eopie id.
     */
    public int eopie_id;
    /**
     * The Carry volume.
     */
    public double carry_volume;

    /**
     * Instantiates a new Eopie.
     *
     * @param eopie_id     the eopie id
     * @param carry_volume the carry volume
     */
    public Eopie(int eopie_id, double carry_volume) {
        this.eopie_id = eopie_id;
        this.carry_volume = carry_volume;
    }

    /**
     * Gets eopie id.
     *
     * @return the eopie id
     */
    public int getEopie_id() {
        return eopie_id;
    }

    /**
     * Sets eopie id.
     *
     * @param eopie_id the eopie id
     */
    public void setEopie_id(int eopie_id) {
        this.eopie_id = eopie_id;
    }

    /**
     * Gets carry volume.
     *
     * @return the carry volume
     */
    public double getCarry_volume() {
        return carry_volume;
    }

    /**
     * Sets carry volume.
     *
     * @param carry_volume the carry volume
     */
    public void setCarry_volume(double carry_volume) {
        this.carry_volume = carry_volume;
    }

    @Override
    public String toString() {
        return "Eopie{" +
                "ID of the Eopie=" + eopie_id +
                ", An Eopie can carry=" + carry_volume +
                '}';
    }
}