package com.example.application.views.task;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.spreadsheet.Spreadsheet;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;

import java.util.GregorianCalendar;

@PageTitle("Task")
@Route(value = "task", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class TaskView extends Div {

    public TaskView() {
        setSizeFull();

        final var spreadsheet = new Spreadsheet();
        add(spreadsheet);
        spreadsheet.setWidth("100%");

        spreadsheet.createCell(0, 0, "Name");
        spreadsheet.createCell(0, 1, "Age");
        spreadsheet.createCell(0, 2, "Address");

        // Styling
        final var cell = spreadsheet.getCell(0, 0);
        CellStyle boldStyle = spreadsheet.getWorkbook().createCellStyle();
        final var font = spreadsheet.getWorkbook().createFont();
        font.setBold(true);
        //boldStyle.setFont(font);
        //spreadsheet.getCell(0, 0).setCellStyle(boldStyle);
        spreadsheet.getCell(0,0).getCellStyle().setFont(font);
        //spreadsheet.getCell(0, 1).setCellStyle(boldStyle);
        //spreadsheet.getCell(0, 2).setCellStyle(boldStyle);

        spreadsheet.createFreezePane(1, 0);
        spreadsheet.setSheetSelectionBarVisible(false);

        // Task 1: Add spreadsheet to the view, make sure it takes the entire space x
        // Task 2: Let's add some cell data (for two rows, one cell should contain date) x
        // Task 2.1: Make sure one of the columns has date
        // Task 2.2: Make sure that the date is displayed in "yyyy-mm-dd" format
        // Task 4: Let's define a pane of 2 rows and 1 column that are frozen in respect to scrolling x

        // Task 5: Let's hide sheet selection bar as we are using only one sheet
        // Task 6: Let's add a formula cell that will be calculating sum of the dates (considering those are numbers) x
        //final var formulaCell = spreadsheet.createFormulaCell(3, 1, "sum(B1:B2)");

        // Helpers:
        // new GregorianCalendar(1990,1,1).getTime()
        // setColumnWidth
        // createFormulaCell
    }

}
