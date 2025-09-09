class Prototype implements Cloneable {
    private String name;

    public Prototype(String name) {
        this.name = name;
    }

    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }

    public String getName() {
        return name;
    }
}