package java.math;

import java.io.Serializable;


public class BigDecimal  implements Cloneable,Serializable{

	/*
	 * MIEI CAMPI
	 */

	private transient InternalBigDecimal internalBigDecimal = null;

	// Rounding Modes

	public final transient static int ROUND_UP = 0;

	public final transient static int ROUND_DOWN = 1;

	public final transient static int ROUND_CEILING = 2;

	public final transient static int ROUND_FLOOR = 3;

	public final transient static int ROUND_HALF_UP = 4;

	public final transient static int ROUND_HALF_DOWN = 5;

	public final transient static int ROUND_HALF_EVEN = 6;

	public final transient static int ROUND_UNNECESSARY = 7;

	//***********************************************

	/* Appease the serialization gods */
	private static final long serialVersionUID = 6108874887143696463L;

	// Constructors

	public BigDecimal() {
		this("0");
	}

	public BigDecimal(String val) {
		
		try{
			Double.parseDouble(val);
			internalBigDecimal = new InternalBigDecimal(val);
		}
		catch (Exception e) {
			throw new IllegalArgumentException("Value of BigDecimal isn't a right value.");
		}
		
		
	}

	//ADD into 2.0.2
	public BigDecimal(int val) {
		this(""+val);
	}
	
//	public BigDecimal(double val) {
//		throw new IllegalArgumentException("Constructor not implemented");
//	}
//
//	public BigDecimal(BigInteger val) {
//		throw new IllegalArgumentException("Constructor not implemented");
//	}
//
//	public BigDecimal(BigInteger unscaledVal, int scale) {
//		throw new IllegalArgumentException("Constructor not implemented");
//	}
//
//	// Static Factory Methods
//
//	public static BigDecimal valueOf(long unscaledVal, int scale) {
//		throw new IllegalArgumentException("Constructor not implemented");
//	}
//
//	public static BigDecimal valueOf(long val) {
//		throw new IllegalArgumentException("Constructor not implemented");
//	}

	// Arithmetic Operations

	public BigDecimal add(BigDecimal val) {
		final InternalBigDecimal i = internalBigDecimal.add(val.internalBigDecimal);
		final BigDecimal b = new BigDecimal(i.toString());
		return b;

	}

	public BigDecimal subtract(BigDecimal val) {
		final InternalBigDecimal i = internalBigDecimal.subtract(val.internalBigDecimal);
		final BigDecimal b = new BigDecimal(i.toString());
		return b;

	}

	public BigDecimal multiply(BigDecimal val) {
		final InternalBigDecimal i = internalBigDecimal.multiply(val.internalBigDecimal);
		final BigDecimal b = new BigDecimal(i.toString());
		return b;


	}

	public BigDecimal divide(BigDecimal val, int scale, int roundingMode) {
		final InternalBigDecimal i = internalBigDecimal.divide(val.internalBigDecimal,scale,roundingMode);
		final BigDecimal b = new BigDecimal(i.toString());
		return b;
	}

	public BigDecimal divide(BigDecimal val, int roundingMode) {
		final InternalBigDecimal i = internalBigDecimal.divide(val.internalBigDecimal,roundingMode);
		final BigDecimal b = new BigDecimal(i.toString());
		return b;
	}

	public BigDecimal abs() {
		final InternalBigDecimal i = internalBigDecimal.abs();
		final BigDecimal b = new BigDecimal(i.toString());
		return b;
	}

	public BigDecimal negate() {
		final InternalBigDecimal i = internalBigDecimal.negate();
		final BigDecimal b = new BigDecimal(i.toString());
		return b;
	}

	public int signum() {
		return internalBigDecimal.signum();
	}

	public int scale() {
		return internalBigDecimal.scale();
	}

	public BigInteger unscaledValue() {
		String s = internalBigDecimal.toString();
		String s2 = s.replaceAll("\\.", "");
		return new BigInteger(s2);
	}

/*
 into Shell Ok outside NO
 * public BigDecimal pow(int n) {

		for (int i = 0; i < Math.abs(n); i++) {
			InternalBigDecimal multiply = internalBigDecimal.multiply(internalBigDecimal);
			internalBigDecimal = multiply;
		}

		InternalBigDecimal divide;
		if(n<0){
			BigDecimal menoUno = new BigDecimal("1");
			divide = menoUno.internalBigDecimal.divide(internalBigDecimal);
		}
		else{
			divide = internalBigDecimal;
		}


		final BigDecimal b = new BigDecimal(divide.toString());
		return b;
	}
 */
	// Scaling/Rounding Operations

	public BigDecimal setScale(int scale, int roundingMode) {

		final InternalBigDecimal i = internalBigDecimal.setScale(scale, roundingMode);
		final BigDecimal b = new BigDecimal(i.toString());
		return b;
	}

	public BigDecimal setScale(int scale) {
		return setScale(scale, ROUND_UNNECESSARY);
	}

	// Decimal Point Motion Operations

//	public BigDecimal movePointLeft(int n) {
//		throw new IllegalArgumentException("movePointLeft(int n) not implemented");
//	}
//
//	public BigDecimal movePointRight(int n) {
//		throw new IllegalArgumentException("movePointRight(int n) not implemented");
//	}

	// Comparison Operations

	public int compareTo(BigDecimal val) {
		return internalBigDecimal.compareTo(val.internalBigDecimal);

	}

	public int compareTo(Object o) {
		if (!(o instanceof BigDecimal)) {
			throw new IllegalArgumentException("method compareTo only with BigDecimal");
		}

		return compareTo((BigDecimal) o);
	}

	public boolean equals(Object obj) {
		if(obj == null){
        	return false;
        }
        else if (obj instanceof BigDecimal) {
        	return internalBigDecimal.equals(((BigDecimal)obj).internalBigDecimal);
		}
        else{
        	return false;
        }
	}

	public BigDecimal min(BigDecimal val) {
		InternalBigDecimal i = new InternalBigDecimal(val.internalBigDecimal.toString());
		final InternalBigDecimal i2 = internalBigDecimal.min(i);
		final BigDecimal b = new BigDecimal(i2.toString());
		return b;

	}

	public BigDecimal max(BigDecimal val) {
		InternalBigDecimal i = new InternalBigDecimal(val.internalBigDecimal.toString());
		final InternalBigDecimal i2 = internalBigDecimal.max(i);
		final BigDecimal b = new BigDecimal(i2.toString());
		return b;
	}

	// Hash Function

	public int hashCode() {
		return internalBigDecimal.hashCode();
	}

	// Format Converters

	public String toString() {
		return internalBigDecimal.toString();
	}

	public BigInteger toBigInteger() {
		InternalBigDecimal i = internalBigDecimal.setScale(0, ROUND_DOWN);
		return new BigInteger( i.toString());
	}

	public int intValue() {
		return toBigInteger().intValue();
	}

	public InternalBigDecimal getInternalBigDecimal() {
		return internalBigDecimal;
	}



//	public long longValue() {
//		throw new IllegalArgumentException("longValue not implemented");
//	}
//
//	public float floatValue() {
//		throw new IllegalArgumentException("floatValue not implemented");
//	}
//
//	public double doubleValue() {
//		throw new IllegalArgumentException("doubleValue not implemented");
//	}

	// Private "Helper" Methods

//	public byte byteValue() {
//		throw new IllegalArgumentException("byteValue not implemented");
//	}
//	public short shortValue() {
//		throw new IllegalArgumentException("shortValue not implemented");
//	}
}
