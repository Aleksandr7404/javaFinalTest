public class Notebook {
    private String brand;   // бренд ноутбука
    private int size;       // диагональ (дюйм)
    private String os;      // опреационная система
    private String cpu;     // процессор
    private int ram;        // оперативная память (ГБ)
    private int storage;    // объем HDD/SDD (ГБ)

    public Notebook(String brand, int size, String os, String cpu, int ram, int storage) {
        this.brand = brand;
        this.size = size;
        this.os = os;
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
    }

    public String getBrand() { return brand; }
    public int getSize() {return size;}
    public String getOs() { return os; }
    public String getCpu() { return cpu; }
    public int getRam() { return ram; }
    public int getStorage() { return storage; }

    @Override
    public String toString() {
        return String.format("Notebook %s, size=%d, OS=%s, cpu=%s, ram=%d, storage=%d",
                brand, size, os, cpu, ram, storage);
    }
}