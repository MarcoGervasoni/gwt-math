package com.mycompany.project.server;

import java.math.BigDecimal;

import com.mycompany.project.client.DataSourceService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class DataSourceServiceImpl extends RemoteServiceServlet implements DataSourceService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public BigDecimal getFirstValue(BigDecimal a) {
		return new BigDecimal("10.45");
	}
	
	
}
