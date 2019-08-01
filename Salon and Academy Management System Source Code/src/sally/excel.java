/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sally;

import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import jxl.read.biff.BiffException;

import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class excel {
    
    public static void main(String[] arg)throws BiffException, IOException, WriteException{
    WritableWorkbook wworkbook;
      wworkbook = Workbook.createWorkbook(new File("C:\\Users\\ASUSI7\\Desktop\\profit.xls"));
      WritableSheet wsheet = wworkbook.createSheet("Sheet", 0);
      Label label =  new  Label(0, 0, "Salon");
      Label label1 = new Label(0, 1, "Academy");
      Label label2 = new Label(0, 3, "Total");
    
      Label label3 = new Label(0, 5, "Salary");
      Label label4 = new Label(0, 6, "Accounting");
      Label label5 = new Label(0, 7, "Advertise");
      Label label6 = new Label(0, 8, "Assets");
      Label label7 = new Label(0, 9, "Elecricity");
      Label label8 = new Label(0, 10, "Inventory");
      Label label9 = new Label(0, 11, "Hire");
      Label label10 = new Label(0, 12, "Insurance");
      Label label11 = new Label(0, 13, "Interese");
      Label label12 = new Label(0, 14, "Rent");
      Label label13 = new Label(0, 15, "Repair");
      Label label14 = new Label(0, 16, "Telephone");
      Label label15 = new Label(0, 18, "Total");
      Label label16 = new Label(0, 20, "Total");
      wsheet.addCell(label);
      wsheet.addCell(label1);
      wsheet.addCell(label2);
      wsheet.addCell(label3);
      wsheet.addCell(label4);
      wsheet.addCell(label5);
      wsheet.addCell(label6);
      wsheet.addCell(label7);
       wsheet.addCell(label8);
       wsheet.addCell(label9);
      wsheet.addCell(label10);
      wsheet.addCell(label11);
      wsheet.addCell(label12);
      wsheet.addCell(label13);
       wsheet.addCell(label14);
       wsheet.addCell(label15);
       wsheet.addCell(label16);
    wworkbook.write();
      wworkbook.close();
    
    
    
    }
    
    
    
    
    
    
    
    
}
