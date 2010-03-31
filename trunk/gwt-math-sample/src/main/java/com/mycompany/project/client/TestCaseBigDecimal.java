package com.mycompany.project.client;

import java.math.BigDecimal;
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

public class TestCaseBigDecimal extends Composite {
	
	private VerticalPanel vp;

	public TestCaseBigDecimal() {
		vp = new VerticalPanel();
		initWidget(vp);
		vp.add(new TestRow("BigDecimal(int val)", new Test() {

			public boolean test() {
				try {
					new BigDecimal(1);
					return true;
				} catch (Exception e) {
					return false;
				}
			}
		}));
		vp.add(new TestRow("BigDecimal(BigInteger val)", new Test() {

			public boolean test() {
				try {
					BigInteger bigInteger = new BigInteger("21215464647687");
					BigDecimal bd = new BigDecimal(bigInteger);
					BigInteger bi = bd.toBigInteger();
					
					if(bigInteger.compareTo(bi) == 0){
						return true;
					}
					else{
						return false;
					}
					
				} catch (Exception e) {
					return false;
				}
			}
		}));
		vp.add(new TestRow("BigDecimal(BigInteger val, int scale)", new Test() {

			public boolean test() {
				try {
					BigInteger bigInteger = new BigInteger("21215464647687");
					BigDecimal bd = new BigDecimal(bigInteger,4);
					bd = bd.add(new BigDecimal("0.8"));
					BigInteger bi = bd.toBigInteger();
					
					if(bigInteger.compareTo(bi) == 0){
						return true;
					}
					else{
						return false;
					}
					
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
