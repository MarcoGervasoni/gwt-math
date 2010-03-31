package com.mycompany.project.client;

import java.math.BigInteger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TestCaseBigInteger extends Composite {
	
	private VerticalPanel vp;

	public TestCaseBigInteger() {
		vp = new VerticalPanel();
		initWidget(vp);
		vp.add(new TestRow("BigInteger gcd(BigInteger b)", new Test() {

			public boolean test() {
				try {
					BigInteger bi = new BigInteger("35563452234234");
					BigInteger res = bi.gcd(new BigInteger("-34523123423456"));
					if(!res.toString().equals("2")){
						return false;
					}
					
					bi = new BigInteger("354");
					res = bi.gcd(new BigInteger("3456"));
					if(!res.toString().equals("6")){
						return false;
					}

					bi = new BigInteger("345654");
					res = bi.gcd(new BigInteger("3456"));
					if(!res.toString().equals("54")){
						return false;
					}
					
					return true;
				} catch (Exception e) {
					return false;
				}
			}
		}));
		
	}

	private class TestRow extends Composite {
		private HorizontalPanel hp;

		public TestRow(String text, Test clickHandler) {
			hp = new HorizontalPanel();
			initWidget(hp);
			// hp.add(new Label(text));
			clickHandler.setHp(hp);
			hp.add(new Button(text, clickHandler));
		}
	}

	private abstract class Test implements ClickHandler {

		private HorizontalPanel hp;

		public Test() {
		}

		public void setHp(HorizontalPanel hp2) {
			hp = hp2;
		}

		public void onClick(ClickEvent arg0) {

			if (test()) {
				Image ok = new Image("images/accept.png");
				ok.setSize("16px", "16px");
				hp.add(ok);
			} else {
				Image fail = new Image("images/exclamation.png");
				fail.setSize("16px", "16px");
				hp.add(fail);
			}
		}

		public abstract boolean test();

	}
}
