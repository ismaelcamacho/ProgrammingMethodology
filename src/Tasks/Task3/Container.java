package Tasks.Task3;

public class Container {
    public int container_id;
    public double water_volume;

    public Container(int container_id, double water_volume) {
        this.container_id = container_id;
        this.water_volume = water_volume;
    }

    public double getWater_volume() {
        return water_volume;
    }

    public void setWater_volume(double water_volume) {
        this.water_volume = water_volume;
    }

    public int getContainer_id() {
        return container_id;
    }

    public void setContainer_id(int container_id) {
        this.container_id = container_id;
    }

    @Override
    public String toString() {
        return "Container{" +
                "ID of the Container=" + container_id +
                ", Volume of the Container=" + water_volume +
                '}';
    }
}
