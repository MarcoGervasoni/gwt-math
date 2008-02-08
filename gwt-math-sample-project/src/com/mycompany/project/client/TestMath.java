package com.mycompany.project.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TestMath implements EntryPoint {
	
	public void onModuleLoad() {
		RootPanel rootPanel = RootPanel.get();
		
		final Label sampleExampleToLabel = new Label("Sample example to make operation client-side");
		rootPanel.add(sampleExampleToLabel);

		BigDecimalTest vpDecimal = new BigDecimalTest();
		rootPanel.add(vpDecimal);
		
		rootPanel.add(new HTML("<br><br>"));
		
		BigIntegerTest bigIntegerTest = new BigIntegerTest();
		rootPanel.add(bigIntegerTest);
		
		
		
		
	}

	
}
