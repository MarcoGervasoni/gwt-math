package java.math;

import com.google.gwt.core.client.JavaScriptObject;

public class InternalMathContext {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JavaScriptObject jsObj;

	public static final int PLAIN = PLAIN();

	public static final int SCIENTIFIC = SCIENTIFIC();

	public static final int ENGINEERING = ENGINEERING();

	public static final int ROUND_CEILING = ROUND_CEILING();

	public static final int ROUND_DOWN = ROUND_DOWN();

	public static final int ROUND_FLOOR = ROUND_FLOOR();

	public static final int ROUND_HALF_DOWN = ROUND_HALF_DOWN();

	public static final int ROUND_HALF_EVEN = ROUND_HALF_EVEN();

	public static final int ROUND_HALF_UP = ROUND_HALF_UP();

	public static final int ROUND_UNNECESSARY = ROUND_UNNECESSARY();

	public static final int ROUND_UP = ROUND_UP();

	public InternalMathContext() {
	}
	
	private InternalMathContext(JavaScriptObject jsObj) {
		this.jsObj = jsObj;
	}

	private native static int PLAIN() /*-{
	 	return $wnd.MathContext.prototype.PLAIN;
	 }-*/;

	private native static int SCIENTIFIC() /*-{
	 	return $wnd.MathContext.prototype.SCIENTIFIC;
	 }-*/;

	private native static int ENGINEERING() /*-{
	 	return $wnd.MathContext.prototype.ENGINEERING;
	 }-*/;

	public native static int ROUND_CEILING()/*-{
		 return $wnd.MathContext.prototype.ROUND_CEILING;
	}-*/;

	public native static int ROUND_DOWN()/*-{
		 return $wnd.MathContext.prototype.ROUND_DOWN;
	 }-*/;

	public native static int ROUND_FLOOR()/*-{
		 return $wnd.MathContext.prototype.ROUND_FLOOR;
	 }-*/;

	public native static int ROUND_HALF_DOWN()/*-{
		 return $wnd.MathContext.prototype.ROUND_HALF_DOWN;
	 }-*/;

	public native static int ROUND_HALF_EVEN()/*-{
		 return $wnd.MathContext.prototype.ROUND_HALF_EVEN;
	 }-*/;

	public native static int ROUND_HALF_UP()/*-{
		 return $wnd.MathContext.prototype.ROUND_HALF_UP;
	 }-*/;

	public native static int ROUND_UNNECESSARY()/*-{
		 return $wnd.MathContext.prototype.ROUND_UNNECESSARY;
	 }-*/;

	public native static int ROUND_UP()/*-{
		 return $wnd.MathContext.prototype.ROUND_UP;
	 }-*/;

	public InternalMathContext(int digits, int form, boolean lostdigits,
			int roundingmode) {
		jsObj = create(digits, form, lostdigits, roundingmode);
	}

	private native JavaScriptObject create(int digits, int form,
			boolean lostdigits, int roundingmode)/*-{
		 return new $wnd.MathContext(digits,form,lostdigits,roundingmode)
	 }-*/;

	public InternalMathContext(int digits, int form, boolean lostdigits) {
		jsObj = create(digits, form, lostdigits);
	}

	private native JavaScriptObject create(int digits, int form,
			boolean lostdigits)/*-{
		 return new $wnd.MathContext(digits,form,lostdigits)
	 }-*/;

	public InternalMathContext(int digits, int form) {
		jsObj = create(digits, form);
	}

	private native JavaScriptObject create(int digits, int form)/*-{
		 return new $wnd.MathContext(digits,form)
	 }-*/;

	public InternalMathContext(int digits) {
		jsObj = create(digits);
	}

	private native JavaScriptObject create(int digits)/*-{
		 return new $wnd.MathContext(digits)
	 }-*/;

	public static InternalMathContext instance(JavaScriptObject jsObj) {

		return new InternalMathContext(jsObj);
	}

	public native int getDigits()/*-{
		 var mathContextJS = this.@java.math.InternalMathContext::jsObj;
		 return mathContextJS.getDigits();

	 }-*/;

	public native int getForm()/*-{
		 var mathContextJS = this.@java.math.InternalMathContext::jsObj;
		 return mathContextJS.getForm();
	 }-*/;

	public native boolean getLostDigits()/*-{
		 var mathContextJS = this.@java.math.InternalMathContext::jsObj;
		 return mathContextJS.getLostDigits();
	 }-*/;

	public native int getRoundingMode()/*-{
		 var mathContextJS = this.@java.math.InternalMathContext::jsObj;
		 return mathContextJS.getRoundingMode();
	 }-*/;

	public native String toString()/*-{
		 var mathContextJS = this.@java.math.InternalMathContext::jsObj;
		 return mathContextJS.toString();
	 }-*/;

}
