// Задание 1
class Product {
    private String name;
    private String manufactureDate;
    private String manufacturer;
    private String country;
    private double price;
    private boolean BookStatus;

    public Product(String name, String manufactureDate, String manufacturer, String country, double price, boolean BookStatus) {
        this.name = name;
        this.manufactureDate = manufactureDate;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.BookStatus = BookStatus;
    }

    public void displayInfo() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + manufactureDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + country);
        System.out.println("Цена: " + price);
        System.out.println("Забронировано: " + (BookStatus ? "Да" : "Нет"));
        System.out.println();
    }
}

// Задание 2
public class Item {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("BelGee Atlas", "10.02.2024", "BelGee", "Беларусь", 28000, true);
        productsArray[1] = new Product("Atlant XM 4425", "05.05.2023", "Atlant", "Беларусь", 950, true);
        productsArray[2] = new Product("Horizont 43LE7511D", "15.08.2022", "Horizont", "Беларусь", 700, false);
        productsArray[3] = new Product("Vityaz 55U651DG", "20.11.2023", "Vityaz", "Беларусь", 800, true);
        productsArray[4] = new Product("BelGee CoolRay", "01.03.2024", "BelGee", "Беларусь", 32000, false);
        System.out.println("Информация о товарах:");
        for (Product product : productsArray) {
            product.displayInfo();
        }

        // Задание 3
        Park park = new Park("Центральный Парк им. Горького", new Park.Attraction[]{
                new Park.Attraction("Американские горки", "10:00 - 22:00", 5),
                new Park.Attraction("Колесо обозрения", "09:00 - 21:00", 12),
                new Park.Attraction("5D Кино", "12:00 - 23:00", 12.5)
        });

        park.displayParkInfo();
    }
}

class Park {
    private String name;
    private Attraction[] attractions;

    public Park(String name, Attraction[] attractions) {
        this.name = name;
        this.attractions = attractions;
    }

    public void displayParkInfo() {
        System.out.println("Парк: " + name);
        for (Attraction attraction : attractions) {
            attraction.displayInfo();
        }
    }

    static class Attraction {
        private String attractionName;
        private String workingHours;
        private double price;

        public Attraction(String attractionName, String workingHours, double price) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void displayInfo() {
            System.out.println("Аттракцион: " + attractionName);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость: " + price);
            System.out.println();
        }
    }
}
