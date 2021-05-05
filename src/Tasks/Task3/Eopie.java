package Tasks.Task3;

public class Eopie {
    public int eopie_id;
    public double carry_volume;

    public Eopie(int eopie_id, double carry_volume) {
        this.eopie_id = eopie_id;
        this.carry_volume = carry_volume;
    }

    public int getEopie_id() {
        return eopie_id;
    }

    public void setEopie_id(int eopie_id) {
        this.eopie_id = eopie_id;
    }

    public double getCarry_volume() {
        return carry_volume;
    }

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