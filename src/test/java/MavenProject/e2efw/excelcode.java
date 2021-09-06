package MavenProject.e2efw;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelcode {

	/*public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*ArrayList<String> a=new ArrayList<String>();
		FileInputStream f=new FileInputStream("C:\\xeldriven.xlsx");
		XSSFWorkbook xel=new XSSFWorkbook(f);
		int count=xel.getNumberOfSheets();
		System.out.println(count);
		ArrayList<String> a = getdata("Fname","testing","Testdata","C:\\xeldriven.xlsx");
		System.out.println(a.get(1));
		
	}*/
	public static ArrayList<String> getdata(String row_name,String Sheet_name,String heading,String path) throws IOException {
		ArrayList<String> a=new ArrayList<String>();
		FileInputStream f=new FileInputStream(path);
		XSSFWorkbook xel=new XSSFWorkbook(f);
		int count=xel.getNumberOfSheets();
	//	System.out.println(count);
		for(int i=0;i<count;i++) {
			if(xel.getSheetName(i).equalsIgnoreCase(Sheet_name)) {
				XSSFSheet sheet=xel.getSheetAt(i);
				Iterator<Row> row=sheet.iterator();
				Row firstrow=row.next();
				Iterator<Cell> column=firstrow.iterator();
				int k=0,req_col=0;
				while(column.hasNext()) {
					Cell in_value=column.next();
				//	System.out.println(in_value.getStringCellValue());
					if((in_value.getStringCellValue()).equalsIgnoreCase(heading)) {
						req_col=k;
						//break;
						//System.out.println("I came to"+req_col);
					}
					k++;
					
				}
				//System.out.println(req_col);
				while (row.hasNext()) {
					Row value=row.next();
					if((value.getCell(req_col).getStringCellValue()).equalsIgnoreCase(row_name)) {
						Iterator<Cell> cel=value.cellIterator();
						while(cel.hasNext()) {
							Cell c1=cel.next();
							//System.out.println(c1.getStringCellValue().getClass());
							if(c1.getCellType()==CellType.STRING)
							{
							a.add(c1.getStringCellValue());
							}
							else {
								String s1=String.valueOf(c1.getNumericCellValue());
								a.add(s1);
							}
						}
					}
				}
			}
		}
		System.out.println(a);
		return a;
	}
	
}
