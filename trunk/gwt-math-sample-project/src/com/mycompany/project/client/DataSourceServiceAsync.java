package com.mycompany.project.client;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DataSourceServiceAsync {
	public void getFirstValue(AsyncCallback callback);

	public void getSecondValue(AsyncCallback callback);

	public void printTotalValue(BigDecimal bigDecimal, AsyncCallback callback);

	public void getFirstIntValue(AsyncCallback callback);

	public void getSecondIntValue(AsyncCallback callback);

	public void printTotalValue(BigInteger bigDecimal,AsyncCallback callback);


}
