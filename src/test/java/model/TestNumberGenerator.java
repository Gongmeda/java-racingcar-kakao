package model;

import java.util.List;

public class TestNumberGenerator implements NumberGenerator {
	private final List<Integer> testNumber;
	private int index = 0;

	public TestNumberGenerator(List<Integer> testNumber) {
		this.testNumber = testNumber;
	}

	@Override
	public int generate() {
		return testNumber.get(index++);
	}
}
