package com.mycompany.project.client;

import java.math.BigDecimal;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface DataSourceService extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static DataSourceServiceAsync instance;
		public static DataSourceServiceAsync getInstance(){
			if (instance == null) {
				instance = (DataSourceServiceAsync) GWT.create(DataSourceService.class);
				ServiceDefTarget target = (ServiceDefTarget) instance;
				target.setServiceEntryPoint(GWT.getModuleBaseURL() + "DataSourceService");
			}
			return instance;
		}
	}
	
	public BigDecimal getFirstValue(BigDecimal a);
}
