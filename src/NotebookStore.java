import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NotebookStore {
    private Set<Notebook> notebooks; // Множество ноутбуков

    public NotebookStore() {
        notebooks = new HashSet<>();
    }

    // Метод для добавления ноутбука
    public void addNotebook(Notebook notebook) {
        notebooks.add(notebook);
    }

    // Метод для фильтрации
    public Set<Notebook> filterNotebooks(Map<String, Object> criteria) {
        Set<Notebook> filteredNotebooks = new HashSet<>(notebooks);

        for (Map.Entry<String, Object> entry : criteria.entrySet()) {
            switch (entry.getKey()) {
                case "brand":
                    filteredNotebooks.removeIf(n -> !n.getBrand().equalsIgnoreCase((String) entry.getValue()));
                    break;
                case "size":
                    filteredNotebooks.removeIf(n -> n.getSize() != (Integer) entry.getValue());
                    break;
                case "os":
                    filteredNotebooks.removeIf(n -> !n.getOs().equalsIgnoreCase((String) entry.getValue()));
                    break;
                case "cpu":
                    filteredNotebooks.removeIf(n -> !n.getCpu().equalsIgnoreCase((String) entry.getValue()));
                    break;
                case "ram":
                    filteredNotebooks.removeIf(n -> n.getRam() < (Integer) entry.getValue());
                    break;
                case "storage":
                    filteredNotebooks.removeIf(n -> n.getStorage() < (Integer) entry.getValue());
                    break;
            }
        }
        return filteredNotebooks;
    }

    //списки вариантов для меню из коллекции ноутбуков
    public Set<String> menuVariants(String parametr) {
        Set<String> menu = new HashSet<>();
        switch (parametr) {
            case "brand":
                for (Notebook notebook : notebooks) {
                    menu.add(notebook.getBrand());
                }
                return menu;
            case "size":
                for (Notebook notebook : notebooks) {
                    menu.add(Integer.toString(notebook.getSize()));
                }
                return menu;
            case "os":
                for (Notebook notebook : notebooks) {
                    menu.add(notebook.getOs());
                }
                return menu;
            case "cpu":
                for (Notebook notebook : notebooks) {
                    menu.add(notebook.getCpu());
                }
                return menu;
            case "ram":
                for (Notebook notebook : notebooks) {
                    menu.add(Integer.toString(notebook.getRam()));
                }
                return menu;
            case "storage":
                for (Notebook notebook : notebooks) {
                    menu.add(Integer.toString(notebook.getStorage()));
                }
                return menu;
        }
        return menu;
    }
}

