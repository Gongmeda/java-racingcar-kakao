package racingcar.model;

import racingcar.model.vo.Name;
import racingcar.model.vo.Position;

public class Car {

    private static final int START_POSITION = 0;

    private Position position;
    private final Name name;

    private Car(final String name, final int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public static Car makeNewCar(final String name) {
        return new Car(name, START_POSITION);
    }

    public void move() {
        this.position = position.moveFront();
    }

    public boolean isAt(final Position otherPosition) {
        return this.position.compareTo(otherPosition) == 0;
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }
}
