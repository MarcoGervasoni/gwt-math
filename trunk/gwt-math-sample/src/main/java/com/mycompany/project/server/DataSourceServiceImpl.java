package com.mycompany.project.server;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.mycompany.project.client.DataSourceService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class DataSourceServiceImpl extends RemoteServiceServlet implements DataSourceService {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	public BigDecimal getFirstValue() {
		String string = "1000.10";
		System.out.println("FirstValue by server: "+string);
		return new BigDecimal(string);
	}


	public BigDecimal getSecondValue() {
		String string = "2.50";
		System.out.println("SecondValue by server: "+string);
		return new BigDecimal(string);
	}


	public void printTotalValue(BigDecimal bigDecimal) {
		System.out.println("TotalValue: "+bigDecimal.toString());

	}


	public BigInteger getFirstIntValue() {
		String string = "200";
		System.out.println("FirstIntValue by server: "+string);
		return new BigInteger(string);
	}


	public BigInteger getSecondIntValue() {
		String string = "5000";
		System.out.println("SecondIntValue by server: "+string);
		return new BigInteger(string);
	}


	public void printTotalValue(BigInteger bigDecimal) {
		System.out.println("TotalIntValue: "+bigDecimal.toString());
	}


}
