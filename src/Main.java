// Аттестация по Java, задача на поиск ноутбуков.
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        NotebookStore store = new NotebookStore();

        store.addNotebook(new Notebook("Lenovo", 14, "Windows", "AMD", 16, 256));
        store.addNotebook(new Notebook("Acer", 15, "w/o OS", "Intel", 8, 256));
        store.addNotebook(new Notebook("Apple", 15, "MacOS", "Apple", 16, 512));
        store.addNotebook(new Notebook("Lenovo", 16, "Linux", "Intel", 16, 512));
        store.addNotebook(new Notebook("Dell", 14, "Windows", "AMD", 16, 512));
        store.addNotebook(new Notebook("Apple", 14, "MacOS", "Apple", 32, 1024));

        // выбор ноутбуков по критериям
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> criteria = new HashMap<>();

        System.out.printf("%nВведите необходимые параметры для поиска ноутбука, 'Enter' - пропустить.%n");
        System.out.printf("%nВыберите бренд %s: ", store.menuVariants("brand"));
        String brand = scanner.nextLine();
        if (!brand.isEmpty()) criteria.put("brand", brand);


        System.out.printf("Выберите размер экрана %s: ", store.menuVariants("size"));
        String size = scanner.nextLine();
        try {
            if (!size.isEmpty()) criteria.put("size", Integer.parseInt(size));
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод! параметр пропущен.");
        }

        System.out.printf("Выберите OC %s: ", store.menuVariants("os"));
        String os = scanner.nextLine();
        if (!os.isEmpty()) criteria.put("os", os);

        System.out.printf("Выберите производителя процессора %s: ", store.menuVariants("cpu"));
        String cpu = scanner.nextLine();
        if (!cpu.isEmpty()) criteria.put("cpu", cpu);

        System.out.printf("Выберете минимальный объем RAM %s: ", store.menuVariants("ram"));
        String ramInput = scanner.nextLine();
        try {
            if (!ramInput.isEmpty()) criteria.put("ram", Integer.parseInt(ramInput));
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод! параметр пропущен.");
        }

        System.out.printf("Выберете минимальный объем накопителя HDD/SDD: %s", store.menuVariants("storage"));
        String storageInput = scanner.nextLine();
        try {
            if (!storageInput.isEmpty()) criteria.put("storage", Integer.parseInt(storageInput));
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод! параметр нпропущен.");
        }

        Set<Notebook> filtered = store.filterNotebooks(criteria);
        System.out.printf("%nРезультат поиска: ");
        if (filtered.isEmpty()) {
            System.out.print("ничего не найдено!");
        }
        for (Notebook notebook : filtered) {
            System.out.printf("%n\t%s", notebook);
        }
    }
}