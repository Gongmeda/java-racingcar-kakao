package org.example.racinggame;

import org.example.racinggame.model.Car;
import org.example.racinggame.model.RandomIntegerGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 숫자가_3이하면_가지않는다(int number) {
        Car car = new Car("pobi");
        car.forward(number);
        assertThat(car.getPosition()).isZero();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    void 숫자가_4이상이면_간다(int number) {
        Car car = new Car("pobi");
        car.forward(number);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 이름이_5글자가_넘으면_에러가_발생한다() {
        assertThatThrownBy(() ->
                new Car("pobiTeacher")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_5자_이하면_에러가_발생하지_않는다() {
        Car car = new Car("pobi");
        assertThat(car).isInstanceOf(Car.class);
    }

    @Test
    void 랜덤으로_0에서_9사이의_숫자를_생성한다() {
        int randomNumber = RandomIntegerGenerator.generateEndInclusive(0, 9);
        assertThat(randomNumber).isBetween(0, 9);
    }
}
