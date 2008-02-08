package com.mycompany.project.client;

import java.math.BigDecimal;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DataSourceServiceAsync {
	public void getFirstValue(BigDecimal a, AsyncCallback callback);
}
