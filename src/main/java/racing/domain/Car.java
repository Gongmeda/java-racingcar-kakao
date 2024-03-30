package racing.domain;

public class Car {
    public static final int MOVE_THRESHOLD = 4;
    private final CarName name;
    private final NumberGenerator generator;
    private int position;

    public Car(String name, NumberGenerator generator) {
        this.name = new CarName(name);
        this.generator = generator;
        this.position = 0;
    }

    public void move() {
        if (generator.generate() >= MOVE_THRESHOLD) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }

    public boolean locates(int position) {
        return this.position == position;
    }
}
