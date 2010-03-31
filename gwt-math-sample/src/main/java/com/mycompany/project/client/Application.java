package com.mycompany.project.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Application implements EntryPoint {

	private SimplePanel page;
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final RootPanel rootPanel = RootPanel.get();
		
		HorizontalPanel hp = new HorizontalPanel();
		page = new SimplePanel();

		final Label sampleExampleToLabel = new Label(
				"Sample example to make operation client-side");
		rootPanel.add(sampleExampleToLabel);

		MenuBar bar = new MenuBar();
		bar.addItem(new MenuItem("Calculator BigDecimal", new Command() {

			public void execute() {
				clearAll(new BigDecimalTest());
			}
		}));
		bar.addItem(new MenuItem("Calculator BigInteger", new Command() {

			public void execute() {
				clearAll(new BigIntegerTest());
			}
		}));
		bar.addItem(new MenuItem("TestCase BigDecimal", new Command() {

			public void execute() {
				clearAll(new TestCaseBigDecimal());
			}
		}));
		bar.addItem(new MenuItem("TestCase BigInteger", new Command() {

			public void execute() {
				clearAll(new TestCaseBigInteger());
			}
		}));
		
		hp.add(bar);
		rootPanel.add(hp);
		
		rootPanel.add(page);

	}

	public void clearAll(Widget p) {
		RootPanel.get().remove(page);
		page = new SimplePanel();
		page.add(p);
		RootPanel.get().add(page);
	}
}
