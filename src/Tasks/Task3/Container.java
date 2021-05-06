package Tasks.Task3;

/**
 * The type Container.
 */
public class Container {
    /**
     * The Container id.
     */
    public int container_id;
    /**
     * The Water volume.
     */
    public double water_volume;

    /**
     * Instantiates a new Container.
     *
     * @param container_id the container id
     * @param water_volume the water volume
     */
    public Container(int container_id, double water_volume) {
        this.container_id = container_id;
        this.water_volume = water_volume;
    }

    /**
     * Gets water volume.
     *
     * @return the water volume
     */
    public double getWater_volume() {
        return water_volume;
    }

    /**
     * Sets water volume.
     *
     * @param water_volume the water volume
     */
    public void setWater_volume(double water_volume) {
        this.water_volume = water_volume;
    }

    /**
     * Gets container id.
     *
     * @return the container id
     */
    public int getContainer_id() {
        return container_id;
    }

    /**
     * Sets container id.
     *
     * @param container_id the container id
     */
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
