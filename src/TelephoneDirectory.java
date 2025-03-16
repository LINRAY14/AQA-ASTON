import java.util.*;

class PhoneDirectory {
    private Map<String, Set<String>> directory;

    public PhoneDirectory() {
        this.directory = new HashMap<>();
    }

    public void add(String surname, String phoneNumber) {
        directory.computeIfAbsent(surname, k -> new HashSet<>()).add(phoneNumber);
    }

    public Set<String> get(String surname) {
        return directory.getOrDefault(surname, Collections.emptySet());
    }

    public void printAll() {
        for (Map.Entry<String, Set<String>> entry : directory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();

        phoneDirectory.add("Петров", "+375-33-234-56-78");
        phoneDirectory.add("Сидоров", "+375-25-456-78-90");
        phoneDirectory.add("Смирнов", "+375-33-678-90-12");
        phoneDirectory.add("Сидоров", "+375-44-789-01-23");
        phoneDirectory.add("Прохоров", "+375-25-890-12-34");
        phoneDirectory.add("Орлов", "+375-29-901-23-45");

        System.out.println("Номера Петрова: " + phoneDirectory.get("Петров"));
        System.out.println("Номера Сидорова: " + phoneDirectory.get("Сидоров"));
        System.out.println("Номера Смирнова: " + phoneDirectory.get("Смирнов"));
        System.out.println("Номера Прохорова: " + phoneDirectory.get("Прохоров"));
        System.out.println("Номера Орлова: " + phoneDirectory.get("Орлов"));

        System.out.println("\nВсе записи в справочнике:");
        phoneDirectory.printAll();
    }
}
