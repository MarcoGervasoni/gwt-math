# gwt-math 2.1 #

## Summary ##
The goal of gwt-math is to provide drop in support for an extended set of the of the standard Java library classes on top of what is provided by the GWT distribution provided by Google.


## GettingStarted ##
The only thing to do in our GWT Module is:
  * to inherit the gwt-math into the gwt.xml
> 

&lt;inherits name="com.googlecode.gwt.math.Math"/&gt;


  * download the jar from the download section and add it into classpath
  * download the server.jar from the download section and add it into classpath of server project to enable RPC call

Now you can use the java.math.BigDecimal and java.math.BigInteger into the GWT Module.

## JRE Emulation ##
java.math.BigDecimal

  * BigDecimal(),**BigDecimal(double)**,BigDecimal(int),BigDecimal(String),abs(),add(BigDecimal),compareTo(BigDecimal),divide(BigDecimal, int),divide(BigDecimal, int, int),**doubleValue()**,equals(Object),**floatValue()**,getInternalBigDecimal(),hashCode(),intValue(),**longValue()**,	max(BigDecimal),min(BigDecimal),multiply(BigDecimal),negate(),**pow(int)**,remainder(BigDecimal),scale(),setScale(int),setScale(int, int),signum(),subtract(BigDecimal),toBigInteger(),toString(),unscaledValue(),**valueOf(long)**,**valueOf(long, int)**

java.math.BigInteger

  * BigInteger(),BigInteger(int),**BigInteger(long)**,BigInteger(String),abs(),add(BigInteger),clone(int[.md](.md)),compareTo(BigInteger),divide(BigInteger),divideAndRemainder(BigInteger),**doubleValue()**,	equals(Object),**floatValue()**,hashCode(),intValue(),**longValue()**,max(BigInteger),min(BigInteger),multiply(BigInteger),negate(),**pow(int)**,remainder(BigInteger),signum(),subtract(BigInteger),toString(),**valueOf(long)**


## Example Project ##
You can find a sample Eclipse project in the [SVN](http://code.google.com/p/gwt-math/source/browse)