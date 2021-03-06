package com.mycompany.project.client;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class BigDecimalTest extends Composite implements ClickListener {
	private TextBox scaleTB;

	private Button divideButton = new Button("Divide",this);
	private Button multiplyButton= new Button("Multiply",this);
	private Button subButton = new Button("Sub",this);
	private Button addButton= new Button("Add",this);
	private Button absButton = new Button("Abs",this);
	private Button negateButton = new Button("Negate",this);
	private Button signumButton = new Button("Signum",this);
	private Button unscaledValueButton = new Button("Unscale",this);
	private Button compareToButton = new Button("compareTo",this);
	private Button minButton = new Button("Min",this);
	private Button maxButton = new Button("Max",this);
	private Button toBigIntegerButton = new Button("toBigInteger",this);
	private Button remainderButton = new Button("Remainder",this);
	
	private Button powButton = new Button("Pow",this);


	private TextBox SecondoTB = new TextBox();
	private TextBox PrimoTB = new TextBox();
	private Label totaleLB = new Label("");

	private VerticalPanel vpDecimal = new VerticalPanel();

	public BigDecimalTest() {

		DataSourceService.Util.getInstance().getFirstValue(new AsyncCallback<Object>(){
			public void onFailure(Throwable caught) { Window.alert(caught.getMessage()); }
			public void onSuccess(Object result) {
				String val = ((BigDecimal)result).toString();
				PrimoTB.setText(val);
			}
		});

		DataSourceService.Util.getInstance().getSecondValue(new AsyncCallback<Object>(){
			public void onFailure(Throwable caught) { Window.alert(caught.getMessage()); }
			public void onSuccess(Object result) {
				String val = ((BigDecimal)result).toString();
				SecondoTB.setText(val);
			}
		});


		initWidget(vpDecimal);
		vpDecimal.setWidth("100%");


		vpDecimal.add(new HTML("<strong> BigDecimal Test</strong>"));

		final FlexTable flexTable_1 = new FlexTable();
		vpDecimal.add(flexTable_1);
		flexTable_1.setWidth("100%");
		flexTable_1.setCellSpacing(2);
		flexTable_1.setCellPadding(2);

		createBottoniera(flexTable_1);

		createSetScale(flexTable_1);



		final FlexTable flexTable = new FlexTable();
		vpDecimal.add(flexTable);
		flexTable.setWidth("100%");

		final Label primoLabel = new Label("First");
		flexTable.setWidget(0, 0, primoLabel);
		flexTable.getCellFormatter().setWidth(0, 0, "50%");

		flexTable.setWidget(0, 1, PrimoTB);
		//PrimoTB.setText("10.45");
		PrimoTB.setTextAlignment(TextBoxBase.ALIGN_RIGHT);
		PrimoTB.setWidth("100%");

		final Label secondoLabel = new Label("Second");
		flexTable.setWidget(1, 0, secondoLabel);

		flexTable.setWidget(1, 1, SecondoTB);
		SecondoTB.setText("2.2");
		SecondoTB.setTextAlignment(TextBoxBase.ALIGN_RIGHT);
		SecondoTB.setWidth("100%");


		flexTable.setWidget(2, 1, totaleLB);
		totaleLB.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		final Label totaleLabel = new Label("Totale:");
		flexTable.setHTML(2, 0, "<strong>"+totaleLabel+"</strong>");


	}

	private void createBottoniera(final FlexTable flexTable_1) {
		final FlexTable bottoniera = new FlexTable();
		flexTable_1.setWidget(0, 0, bottoniera);

		int row = 0;

		bottoniera.setWidget(0,row++,  addButton);
		bottoniera.setWidget(0,row++,  multiplyButton);

		bottoniera.setWidget(0,row++,  absButton);
		bottoniera.setWidget(0,row++,  negateButton);
		bottoniera.setWidget(0,row++,  signumButton);
		bottoniera.setWidget(0,row++,  unscaledValueButton);
		bottoniera.setWidget(0,row++,  remainderButton);

		row = 0;
		bottoniera.setWidget(1,row++,  subButton);
		bottoniera.setWidget(1,row++, divideButton);

		bottoniera.setWidget(1,row++, compareToButton);
		bottoniera.setWidget(1,row++, minButton);
		bottoniera.setWidget(1,row++, maxButton);
		bottoniera.setWidget(1,row++, toBigIntegerButton);
		bottoniera.setWidget(1,row++, powButton);


	}


	private void createSetScale(final FlexTable flexTable_1) {
		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		flexTable_1.setWidget(0, 1, horizontalPanel);
//		flexTable_1.getCellFormatter().setWidth(1, 3, "100%");

		final Label withScaleLabel = new Label("with Scale:");
		horizontalPanel.add(withScaleLabel);
		withScaleLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		horizontalPanel.setCellWidth(withScaleLabel, "70%");

		scaleTB = new TextBox();
		horizontalPanel.add(scaleTB);
		scaleTB.setTextAlignment(TextBoxBase.ALIGN_RIGHT);
		scaleTB.setText("2");
		horizontalPanel.setCellWidth(scaleTB, "30%");
	}

	public void onClick(Widget sender) {
		String t = scaleTB.getText();
		if(t.equals("")) t = "2";

		int scale = new Integer(t).intValue();

		BigDecimal primoTBbigDecimal = new BigDecimal(PrimoTB.getText());
		BigDecimal secondoTBbigDecimal = new BigDecimal(SecondoTB.getText());
		String str;
		BigDecimal res = null;
		if(sender == addButton){
			res = primoTBbigDecimal.add(secondoTBbigDecimal).setScale(scale, BigDecimal.ROUND_HALF_UP);
			str =  res.toString();
			totaleLB.setText(str);
		}
		else if(sender == subButton){
			res = primoTBbigDecimal.subtract(secondoTBbigDecimal).setScale(scale, BigDecimal.ROUND_HALF_UP);
			str =  res.toString();
			totaleLB.setText(str);
		}
		else if(sender == multiplyButton){
			res = primoTBbigDecimal.multiply(secondoTBbigDecimal).setScale(scale, BigDecimal.ROUND_HALF_UP);
			str =  res.toString();
			totaleLB.setText(str);
		}
		else if(sender == divideButton){
			res = primoTBbigDecimal.divide(secondoTBbigDecimal,scale,BigDecimal.ROUND_HALF_UP);
			str =  res.toString();
			totaleLB.setText(str);
		}
		else if(sender == absButton){
			res = primoTBbigDecimal.abs();
			str =  res.toString();
			totaleLB.setText(str);
		}
		else if(sender == negateButton){
			res = primoTBbigDecimal.negate();
			str =  res.toString();
			totaleLB.setText(str);
		}
		else if(sender == signumButton){
			str =  ""+primoTBbigDecimal.signum();
			totaleLB.setText(str);
		}
		else if(sender == unscaledValueButton){
			BigInteger resI = primoTBbigDecimal.unscaledValue();
			str =  resI.toString();
			totaleLB.setText(str);
		}
		else if(sender == compareToButton){
			str =  ""+primoTBbigDecimal.compareTo(secondoTBbigDecimal);
			totaleLB.setText(str);
		}
		else if(sender == minButton){
			res = primoTBbigDecimal.min(secondoTBbigDecimal);
			str =  res.toString();
			totaleLB.setText(str);
		}
		else if(sender == maxButton){
			res = primoTBbigDecimal.max(secondoTBbigDecimal);
			str =  res.toString();
			totaleLB.setText(str);
		}
		else if(sender == toBigIntegerButton){
			BigInteger resI = primoTBbigDecimal.toBigInteger();
			str =  resI.toString();
			totaleLB.setText(str);
		}
		else if(sender == remainderButton){
			res = primoTBbigDecimal.remainder(secondoTBbigDecimal);
			str =  res.toString();
			totaleLB.setText(str);
		}
		else if(sender == powButton){
			int i = new Integer(SecondoTB.getText()).intValue();
			
			res = primoTBbigDecimal.pow(i);
			str =  res.toString();
			totaleLB.setText(str);
		}

		if(res!=null){
			DataSourceService.Util.getInstance().printTotalValue(res, new AsyncCallback(){
				public void onFailure(Throwable caught) {}
				public void onSuccess(Object result) {}
			});
		}
	}
}
