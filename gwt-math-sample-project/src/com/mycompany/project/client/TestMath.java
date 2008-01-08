package com.mycompany.project.client;

import java.math.BigDecimal;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.Widget;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TestMath implements EntryPoint,ClickListener {
	private TextBox scaleTB;
	private Button divideButton;
	private Button multiplyButton;
	private Button subButton;
	private Button addButton;
	
	private TextBox SecondoTB;
	private TextBox PrimoTB;
	Label totaleLB = new Label("");
	
	public void onModuleLoad() {
		RootPanel rootPanel = RootPanel.get();

		final Label sampleExampleToLabel = new Label("Sample example to make operation client-side");
		rootPanel.add(sampleExampleToLabel);

		final FlexTable flexTable_1 = new FlexTable();
		rootPanel.add(flexTable_1);
		flexTable_1.setWidth("100%");
		flexTable_1.setCellSpacing(2);
		flexTable_1.setCellPadding(2);

		addButton = new Button();
		flexTable_1.setWidget(0, 0, addButton);
		addButton.setText("Add");

		subButton = new Button();
		flexTable_1.setWidget(0, 1, subButton);
		subButton.setText("Sub");

		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		flexTable_1.setWidget(0, 4, horizontalPanel);
		flexTable_1.getCellFormatter().setWidth(0, 4, "100%");

		final Label withScaleLabel = new Label("with Scale:");
		horizontalPanel.add(withScaleLabel);
		withScaleLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		horizontalPanel.setCellWidth(withScaleLabel, "70%");

		scaleTB = new TextBox();
		horizontalPanel.add(scaleTB);
		scaleTB.setTextAlignment(TextBoxBase.ALIGN_RIGHT);
		scaleTB.setText("2");
		horizontalPanel.setCellWidth(scaleTB, "30%");

		multiplyButton = new Button();
		flexTable_1.setWidget(0, 2, multiplyButton);
		multiplyButton.setText("Multiply");

		divideButton = new Button();
		flexTable_1.setWidget(0, 3, divideButton);
		divideButton.setText("Divide");

		final FlexTable flexTable = new FlexTable();
		rootPanel.add(flexTable);
		flexTable.setWidth("100%");

		final Label primoLabel = new Label("Primo");
		flexTable.setWidget(0, 0, primoLabel);
		flexTable.getCellFormatter().setWidth(0, 0, "50%");

		PrimoTB = new TextBox();
		flexTable.setWidget(0, 1, PrimoTB);
		PrimoTB.setText("10.45");
		PrimoTB.setTextAlignment(TextBoxBase.ALIGN_RIGHT);
		PrimoTB.setWidth("100%");

		final Label secondoLabel = new Label("Secondo");
		flexTable.setWidget(1, 0, secondoLabel);

		SecondoTB = new TextBox();
		flexTable.setWidget(1, 1, SecondoTB);
		SecondoTB.setText("2.2");
		SecondoTB.setTextAlignment(TextBoxBase.ALIGN_RIGHT);
		SecondoTB.setWidth("100%");

		
		flexTable.setWidget(2, 1, totaleLB);
		totaleLB.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		final Label totaleLabel = new Label("Totale:");
		flexTable.setWidget(2, 0, totaleLabel);
		
		
		addButton.addClickListener(this);
		divideButton.addClickListener(this);
		subButton.addClickListener(this);
		multiplyButton.addClickListener(this);
		
	}

	public void onClick(Widget sender) {
		String t = scaleTB.getText();
		if(t.equals("")) t = "2";
		
		int scale = new Integer(t).intValue();

		BigDecimal primoTBbigDecimal = new BigDecimal(PrimoTB.getText());
		BigDecimal secondoTBbigDecimal = new BigDecimal(SecondoTB.getText());
		
		if(sender == addButton){
			String str = primoTBbigDecimal.add(secondoTBbigDecimal).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
			totaleLB.setText(str);
		}
		else if(sender == subButton){
			String str = primoTBbigDecimal.subtract(secondoTBbigDecimal).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
			totaleLB.setText(str);
		}
		else if(sender == multiplyButton){
			String str = primoTBbigDecimal.multiply(secondoTBbigDecimal).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
			totaleLB.setText(str);
		}
		else if(sender == divideButton){
			String str = primoTBbigDecimal.divide(secondoTBbigDecimal,scale,BigDecimal.ROUND_HALF_UP).toString();
			totaleLB.setText(str);
		}

	}
}
