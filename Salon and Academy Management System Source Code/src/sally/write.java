/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sally;
//import java.awt.Label;
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

import sally.BalanceSheet;


public class write {
    
   public static void main(String[] arg)throws BiffException, IOException, WriteException{
     WritableWorkbook wworkbook;
      wworkbook = Workbook.createWorkbook(new File("C:\\Users\\ASUSI7\\Desktop\\output.xls"));
      WritableSheet wsheet = wworkbook.createSheet("First Sheet", 0);
      Label label =  new  Label(0, 0, "Cash");
      Label label1 = new Label(0, 1, "Acc Rec");
      Label label2 = new Label(0, 2, "Pre Rent");
      Label label3 = new Label(0, 3, "Inven");
      Label label4 = new Label(0, 4, "Total");
      Label label5 = new Label(3, 0, "Stock");
      Label label6 = new Label(3, 1, "Insurance");
      Label label7 = new Label(3, 4, "Total");
      Label label8 = new Label(6, 0, "Assets Total");
      Label label9 = new Label(0, 6, "Cash");
      Label label10 = new Label(0, 7, "Acc Rec");
      Label label11 = new Label(0, 8, "Pre Rent");
      Label label12 = new Label(0, 9, "Total");
      Label label13 = new Label(0, 11, "NCL");
      Label label14 = new Label(0, 13, "Total");
      Label label15 = new Label(3, 6, "capital");
      Label label16 = new Label(3, 7, "Ret earn");
      Label label17 = new Label(3, 13, "Total");
      Label label18 = new Label(6, 13, "Total Liabily and equity");
      //Label label19 = new Label(6, 15, "Total");
      
      
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
       wsheet.addCell(label17);
       wsheet.addCell(label18);
       
       
       
       
      //Number number = new Number(3, 4, 3.1459);
      //wsheet.addCell(number);
      wworkbook.write();
      wworkbook.close();

//      Workbook workbook = Workbook.getWorkbook(new File("output.xls"));
//      Sheet sheet = workbook.getSheet(0);
//      Cell cell1 = sheet.getCell(0, 2);
//      System.out.println(cell1.getContents());
//      Cell cell2 = sheet.getCell(3, 4);
//      System.out.println(cell2.getContents());
//      workbook.close();
    }
    //public void getDetails(int txt1,int txt2,int txt3,int txt4,int txt6,int txt7,int txt8,int txt9,int txt10,int txt11,int txt12){ 
//   
    //}
    
    public static void get(int txt){
        
    
    }
    
}
