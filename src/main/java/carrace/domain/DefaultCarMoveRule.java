package carrace.domain;

public class DefaultCarMoveRule implements CarMoveRule {

    private static final int MOVE_THRESHOLD = 4;

    private final NumberGenerator numberGenerator;

    public DefaultCarMoveRule(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public boolean isMovable() {
        return numberGenerator.generate() >= MOVE_THRESHOLD;
    }
}
