
class Animal {
    protected String name;
    protected int runLimit;
    protected int swimLimit;
    private static int animalCount = 0;

    public Animal(String name, int runLimit, int swimLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        animalCount++;
    }

    public void run(int distance) {
        if (distance <= runLimit) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не смог пробежать " + distance + " м.");
        }
    }

    public void swim(int distance) {
        if (swimLimit == 0) {
            System.out.println(name + " не умеет плавать.");
        } else if (distance <= swimLimit) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не смог проплыть " + distance + " м.");
        }
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}
class Dog extends Animal {
    private static int dogCount = 0;

    public Dog(String name) {
        super(name, 500, 10);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }
}

class Cat extends Animal {
    private static int catCount = 0;
    private boolean satiety;

    public Cat(String name) {
        super(name, 200, 0);
        this.satiety = false;
        catCount++;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void eat(FoodBowl bowl, int amount) {
        if (bowl.getFoodAmount() < amount) {
            System.out.println(name + " не стал есть, так как еды слишком мало.");
            return;
        }
        if (bowl.decreaseFood(amount)) {
            this.satiety = true;
            System.out.println(name + " поел и теперь сыт.");
        }
    }

    public static int getCatCount() {
        return catCount;
    }
}
class FoodBowl {
    private int foodAmount;

    public FoodBowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public boolean decreaseFood(int amount) {
        if (foodAmount >= amount) {
            foodAmount -= amount;
            return true;
        }
        return false;
    }

    public void addFood(int amount) {
        foodAmount += amount;
        System.out.println("Добавлено " + amount + " еды в миску. Теперь в миске " + foodAmount + " еды.");
    }

    public void showFoodAmount() {
        System.out.println("В миске осталось " + foodAmount + " еды.");
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
class Test {
    public static void main(String[] args) {
        Dog dogBobik = new Dog("Бобик");
        Cat catMurzik = new Cat("Мурзик");

        dogBobik.run(150);
        dogBobik.swim(5);
        catMurzik.run(100);
        catMurzik.swim(10);

        FoodBowl bowl = new FoodBowl(20);
        Cat[] cats = {new Cat("Барсик"), new Cat("Рыжик"), new Cat("Снежок")};

        for (Cat cat : cats) {
            cat.eat(bowl, 10);
        }
        bowl.showFoodAmount();
        bowl.addFood(20);
        bowl.showFoodAmount();
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
        System.out.println("Всего котов: " + Cat.getCatCount());
    }
}

