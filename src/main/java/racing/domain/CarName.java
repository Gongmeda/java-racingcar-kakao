package racing.domain;

public class CarName {
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    private static void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new RuntimeException("빈 문자열 혹은 널 값은 차 이름이 될 수 없습니다");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new RuntimeException("차 이름은 5글자 이하여야 합니다");
        }
    }

    public String getName() {
        return name;
    }
}
