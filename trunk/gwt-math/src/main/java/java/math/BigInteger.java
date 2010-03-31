package java.math;

import java.io.Serializable;

public class BigInteger extends Number implements Cloneable, Serializable,
		Comparable<BigInteger> {

	/*
	 * MIEI CAMPI
	 */
	private transient BigDecimal internalBigInteger = null;

	private static final long serialVersionUID = 1L;

	public transient static final BigInteger ZERO = new BigInteger("0");

	public transient static final BigInteger ONE = new BigInteger("1");

	public transient static final BigInteger TEN = new BigInteger("10");

	// *******************************************

	// Constructors
	public BigInteger() {
		this("0");
	}

	// public BigInteger(byte[] val) {
	// throw new IllegalArgumentException(
	// "Constructor BigInteger(byte[] val) not implemented");
	// }
	//
	// public BigInteger(int signum, byte[] magnitude) {
	// throw new IllegalArgumentException(
	// "Constructor BigInteger(int signum, byte[] magnitude) not implemented");
	// }
	//
	// public BigInteger(String val, int radix) {
	// throw new IllegalArgumentException(
	// "Constructor BigInteger(String val, int radix) not implemented");
	// }

	public BigInteger(String val) {
		try {
			Double.parseDouble(val);
			internalBigInteger = new BigDecimal(val);
			internalBigInteger.setScale(0);
		} catch (Exception e) {
			throw new NumberFormatException(
					"Value of BigInteger isn't a right value.");
		}

	}

	// ADD into 2.0.2
	public BigInteger(int val) {
		this("" + val);
	}

	public BigInteger(long val) {
		this("" + val);
	}

	private BigInteger convert(BigDecimal val) {
		BigDecimal b = val.setScale(0);
		return new BigInteger(b.toString());
	}

	public static BigInteger valueOf(long unscaledVal) {
		BigInteger bi = new BigInteger(unscaledVal);
		return bi;
	}

	// Arithmetic Operations

	public BigInteger add(BigInteger val) {
		BigDecimal val2 = internalBigInteger.add(val.internalBigInteger);
		return convert(val2);
	}

	public BigInteger subtract(BigInteger val) {
		BigDecimal val2 = internalBigInteger.subtract(val.internalBigInteger);
		return convert(val2);
	}

	public BigInteger multiply(BigInteger val) {
		BigDecimal val2 = internalBigInteger.multiply(val.internalBigInteger);
		return convert(val2);
	}

	public BigInteger divide(BigInteger val) {

		BigDecimal val2 = internalBigInteger.divide(val.internalBigInteger, 0,
				BigDecimal.ROUND_DOWN);
		return convert(val2);
	}

	public BigInteger[] divideAndRemainder(BigInteger val) {
		BigInteger[] result = new BigInteger[2];

		BigDecimal val2 = internalBigInteger.divide(val.internalBigInteger, 0,
				BigDecimal.ROUND_DOWN);

		final BigInteger divide = convert(val2);
		result[0] = divide;

		final BigInteger multiply = divide.multiply(val);

		final InternalBigDecimal subtract = internalBigInteger
				.getInternalBigDecimal().subtract(
						multiply.internalBigInteger.getInternalBigDecimal());
		subtract.setScale(0);
		result[1] = new BigInteger(subtract.toString());

		return result;
	}

	public BigInteger remainder(BigInteger val) {
		return divideAndRemainder(val)[1];
	}

	public BigInteger gcd(BigInteger b) {
		if (ZERO.equals(this))
			return b;
		BigInteger a = abs();
		b = b.abs();
		while (! ZERO.equals(b))
			if (a.compareTo(b) > 0) // a > b ?
				a = a.subtract(b);
			else
				b = b.subtract(a);
		return a;	
	}

	public BigInteger pow(int n) {
		if (n < 0 || n > 999999999)
			throw new ArithmeticException("Invalid operation");

		if (n == 0) {
			return ONE;
		}
		BigInteger res = this;
		for (int i = 0; i < n-1; i++) {
			res = res.multiply(this);
		}

		return res;
	}
	public BigInteger abs() {
		BigDecimal val = internalBigInteger.abs();
		return convert(val);
	}

	public BigInteger negate() {
		BigDecimal val = internalBigInteger.negate();
		return convert(val);
	}

	public int signum() {
		return internalBigInteger.signum();
	}

	// Modular Arithmetic Operations

	// public BigInteger mod(BigInteger m) {
	// throw new
	// IllegalArgumentException("Method mod(BigInteger m) not implemented");
	// }
	//
	// public BigInteger modPow(BigInteger exponent, BigInteger m) {
	// throw new IllegalArgumentException(
	// "Method modPow(BigInteger exponent, BigInteger m) not implemented");
	// }

	public int[] clone(int a[]) {
		int temp[] = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			temp[i] = a[i];
		}
		return temp;
	}

	// public BigInteger modInverse(BigInteger m) {
	// throw new IllegalArgumentException("Method  not implemented");
	// }

	// Shift Operations

	// public BigInteger shiftLeft(int n) {
	// throw new IllegalArgumentException("Method  not implemented");
	// }
	//
	// public BigInteger shiftRight(int n) {
	// throw new IllegalArgumentException("Method  not implemented");
	// }
	//
	// public BigInteger and(BigInteger val) {
	// throw new IllegalArgumentException("Method  not implemented");
	// }
	//
	// public BigInteger or(BigInteger val) {
	// throw new IllegalArgumentException("Method  not implemented");
	// }
	//
	// public BigInteger xor(BigInteger val) {
	// throw new IllegalArgumentException("Method  not implemented");
	// }
	//
	// public BigInteger not() {
	// throw new IllegalArgumentException("Method  not implemented");
	// }
	//
	// public BigInteger andNot(BigInteger val) {
	// throw new IllegalArgumentException("Method  not implemented");
	// }
	//
	// // Single Bit Operations
	//
	// public boolean testBit(int n) {
	// throw new IllegalArgumentException("Method  not implemented");
	// }
	//
	// public BigInteger setBit(int n) {
	// throw new IllegalArgumentException("Method  not implemented");
	// }
	//
	// public BigInteger clearBit(int n) {
	// throw new IllegalArgumentException("Method  not implemented");
	// }
	//
	// public BigInteger flipBit(int n) {
	// throw new IllegalArgumentException("Method  not implemented");
	// }
	//
	// public int getLowestSetBit() {
	// throw new IllegalArgumentException("Method  not implemented");
	// }
	//
	// // Miscellaneous Bit Operations
	//
	// public int bitLength() {
	// throw new IllegalArgumentException("Method  not implemented");
	// }
	//
	// public int bitCount() {
	// throw new IllegalArgumentException("Method  not implemented");
	// }

	public int compareTo(BigInteger val) {
		return internalBigInteger.compareTo(val.internalBigInteger);
	}

	// public int compareTo(Object o) {
	// if (!(o instanceof BigInteger)) {
	// throw new
	// IllegalArgumentException("method compareTo only with BigInteger");
	// }
	//
	// return compareTo((BigInteger)o);
	// }

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj instanceof BigInteger) {
			return internalBigInteger
					.equals(((BigInteger) obj).internalBigInteger);
		} else {
			return false;
		}
	}

	public BigInteger min(BigInteger val) {
		BigDecimal val2 = internalBigInteger.min(val.internalBigInteger);
		return convert(val2);
	}

	public BigInteger max(BigInteger val) {
		BigDecimal val2 = internalBigInteger.max(val.internalBigInteger);
		return convert(val2);
	}

	// Hash Function

	public int hashCode() {
		return internalBigInteger.hashCode();
	}

	// public String toString(int radix) {
	// throw new IllegalArgumentException("Method  not implemented");
	// }

	public String toString() {
		return internalBigInteger.toString();
	}

	// public byte[] toByteArray() {
	// throw new IllegalArgumentException("Method  not implemented");
	// }

	//	@Override
	public int intValue() {
		return new Integer(this.toString()).intValue();
	}

	//	@Override
	public double doubleValue() {
		return new Double(this.toString());
	}

	//	@Override
	public float floatValue() {
		return new Float(this.toString());
	}

	//	@Override
	public long longValue() {
		return new Long(this.toString());
	}

	// public byte byteValue() {
	// throw new IllegalArgumentException("Method  not implemented");
	// }
	//
	// public short shortValue() {
	// throw new IllegalArgumentException("Method  not implemented");
	// }
}
