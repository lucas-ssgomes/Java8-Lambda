package br.ifpe.entities;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum AccountEnum {

	CHECKING, SAVING, JOINT;

	private static final List<AccountEnum> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();

	public static AccountEnum randomType() {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
}
