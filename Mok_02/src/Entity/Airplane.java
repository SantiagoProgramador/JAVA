package Entity;

public class Airplane {
    private int id;
    private String model;
    private int Capacity;

    public Airplane(int id, String model, int capacity) {
        this.id = id;
        this.model = model;
        Capacity = capacity;
    }
    public Airplane(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", Capacity=" + Capacity +
                '}';
    }
}
