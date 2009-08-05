package com.mycompany.project.client;

import java.math.BigInteger;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class BigIntegerTest extends Composite implements ClickListener{

	private TextBox SecondoTB = new TextBox();
	private TextBox PrimoTB = new TextBox();
	private Label totaleLB = new Label("");

	private Button divideButton = new Button("Divide",this);
	private Button divideAndReminderButton = new Button("Divide And Reminder",this);
	private Button reminderButton = new Button("Reminder",this);
	private Button multiplyButton= new Button("Multiply",this);
	private Button subButton = new Button("Sub",this);
	private Button addButton= new Button("Add",this);
	private Button absButton = new Button("Abs",this);
	private Button negateButton = new Button("Negate",this);
	private Button signumButton = new Button("Signum",this);
	private Button minButton = new Button("Min",this);
	private Button maxButton = new Button("Max",this);
	private Button powButton = new Button("Pow",this);
	private Button compareToButton = new Button("compareTo",this);

	private VerticalPanel vpDecimal = new VerticalPanel();

	public BigIntegerTest() {
		DataSourceService.Util.getInstance().getFirstIntValue(new AsyncCallback(){
			public void onFailure(Throwable caught) { Window.alert(caught.getMessage()); }
			public void onSuccess(Object result) {
				String val = ((BigInteger)result).toString();
				PrimoTB.setText(val);
			}
		});

		DataSourceService.Util.getInstance().getSecondIntValue(new AsyncCallback(){
			public void onFailure(Throwable caught) { Window.alert(caught.getMessage()); }
			public void onSuccess(Object result) {
				String val = ((BigInteger)result).toString();
				SecondoTB.setText(val);
			}
		});

		initWidget(vpDecimal);
		vpDecimal.setWidth("100%");


		vpDecimal.add(new HTML("<strong> BigInteger Test</strong>"));

		final FlexTable flexTable_1 = new FlexTable();
		vpDecimal.add(flexTable_1);
		flexTable_1.setWidth("100%");
		flexTable_1.setCellSpacing(2);
		flexTable_1.setCellPadding(2);

		createBottoniera(flexTable_1);

		final FlexTable flexTable = new FlexTable();
		vpDecimal.add(flexTable);
		flexTable.setWidth("100%");

		final Label primoLabel = new Label("First");
		flexTable.setWidget(0, 0, primoLabel);
		flexTable.getCellFormatter().setWidth(0, 0, "50%");

		flexTable.setWidget(0, 1, PrimoTB);
		PrimoTB.setTextAlignment(TextBoxBase.ALIGN_RIGHT);
		PrimoTB.setWidth("100%");

		final Label secondoLabel = new Label("Second");
		flexTable.setWidget(1, 0, secondoLabel);

		flexTable.setWidget(1, 1, SecondoTB);
		SecondoTB.setTextAlignment(TextBoxBase.ALIGN_RIGHT);
		SecondoTB.setWidth("100%");


		flexTable.setWidget(2, 1, totaleLB);
		totaleLB.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		final Label totaleLabel = new Label("Totale:");
		flexTable.setHTML(2, 0, "<strong>"+totaleLabel+"</strong>");

	}

	private void createBottoniera(FlexTable flexTable_1) {
		final FlexTable bottoniera = new FlexTable();
		flexTable_1.setWidget(0, 0, bottoniera);

		int row = 0;

		bottoniera.setWidget(0,row++,  addButton);
		bottoniera.setWidget(0,row++,  multiplyButton);

		bottoniera.setWidget(0,row++,  absButton);
		bottoniera.setWidget(0,row++,  negateButton);
		bottoniera.setWidget(0,row++,  signumButton);
		bottoniera.setWidget(0,row++,  divideAndReminderButton);
		bottoniera.setWidget(0,row++,  powButton);

		row = 0;
		bottoniera.setWidget(1,row++,  subButton);
		bottoniera.setWidget(1,row++, divideButton);

		bottoniera.setWidget(1,row++, compareToButton);
		bottoniera.setWidget(1,row++, minButton);
		bottoniera.setWidget(1,row++, maxButton);
		bottoniera.setWidget(1,row++, reminderButton);
	}

	public void onClick(Widget sender) {
		BigInteger primoTBBigInteger = new BigInteger(PrimoTB.getText());
		BigInteger secondoTBBigInteger = new BigInteger(SecondoTB.getText());

		String str;
		BigInteger res = null;

		if(sender == addButton){
			res = primoTBBigInteger.add(secondoTBBigInteger);
			str = res.toString();
			totaleLB.setText(str);
		}
		else if(sender == subButton){
			res = primoTBBigInteger.subtract(secondoTBBigInteger);
			str = res.toString();
			totaleLB.setText(str);
		}
		else if(sender == multiplyButton){
			res = primoTBBigInteger.multiply(secondoTBBigInteger);
			str = res.toString();
			totaleLB.setText(str);
		}
		else if(sender == divideButton){
			res = primoTBBigInteger.divide(secondoTBBigInteger);
			str = res.toString();
			totaleLB.setText(str);
		}
		else if(sender == absButton){
			res = primoTBBigInteger.abs();
			str = res.toString();
			totaleLB.setText(str);
		}
		else if(sender == negateButton){
			res = primoTBBigInteger.negate();
			str = res.toString();
			totaleLB.setText(str);
		}
		else if(sender == signumButton){
			str = ""+primoTBBigInteger.signum();
			totaleLB.setText(str);
		}
		else if(sender == compareToButton){
			str = ""+primoTBBigInteger.compareTo(secondoTBBigInteger);
			totaleLB.setText(str);
		}
		else if(sender == minButton){
			res = primoTBBigInteger.min(secondoTBBigInteger);
			str = res.toString();
			totaleLB.setText(str);
		}
		else if(sender == maxButton){
			res = primoTBBigInteger.max(secondoTBBigInteger);
			str = res.toString();
			totaleLB.setText(str);
		}
		else if(sender == reminderButton){
			res = primoTBBigInteger.remainder(secondoTBBigInteger);
			str = res.toString();
			totaleLB.setText(str);
		}
		else if(sender == divideAndReminderButton){
			final BigInteger[] divideAndRemainder = primoTBBigInteger.divideAndRemainder(secondoTBBigInteger);
			str = "[0]"+divideAndRemainder[0]+"***[1]:"+divideAndRemainder[1];
			totaleLB.setText(str);
		}
		else if(sender == powButton){
			int i = new Integer(SecondoTB.getText()).intValue();
			
			res = primoTBBigInteger.pow(i);
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
