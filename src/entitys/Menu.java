package entitys;

public enum Menu {
    SEASON(1, "Saison"), GENERAL(2, "Allgemein"), CACHE(3, "Nicht öffentlich");

    private int id;
    private String name;

    Menu(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
