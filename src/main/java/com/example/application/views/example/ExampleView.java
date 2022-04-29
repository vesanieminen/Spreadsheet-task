package com.example.application.views.example;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.spreadsheet.Spreadsheet;
import com.vaadin.flow.component.spreadsheet.action.SpreadsheetDefaultActionHandler;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;

import java.util.GregorianCalendar;

@PageTitle("Example")
@Route(value = "example", layout = MainLayout.class)
public class ExampleView extends Div {

    public ExampleView() {
        setSizeFull();

        Spreadsheet spreadsheet = new Spreadsheet();
        spreadsheet.setWidth("100%");

        spreadsheet.createCell(0, 0, "Yuriy");
        spreadsheet.createCell(0, 1, "Yevstihnyeyev");
        spreadsheet.createCell(0, 2,
                new GregorianCalendar(1990,1,1).getTime());

        spreadsheet.createCell(1, 0, "David");
        spreadsheet.createCell(1, 1, "Sosa");
        spreadsheet.createCell(1, 2,
                new GregorianCalendar(1990,1,1).getTime());

        spreadsheet.setColumnWidth(1, 200);
        spreadsheet.setColumnWidth(2, 200);

        spreadsheet.createFreezePane(2, 2);

        spreadsheet.createFormulaCell(2, 2, "SUM(C1:C2)");

        CellStyle dateStyle = spreadsheet.getWorkbook().createCellStyle();
        DataFormat format = spreadsheet.getWorkbook().createDataFormat();
        dateStyle.setDataFormat(format.getFormat("yyyy-mm-dd"));

        spreadsheet.getCell(0,2).setCellStyle(dateStyle);
        spreadsheet.getCell(1,2).setCellStyle(dateStyle);

        spreadsheet.setSheetSelectionBarVisible(false);

        add(spreadsheet);
    }

}
