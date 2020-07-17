package test.excelfile;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import javax.json.*;
import java.io.*;

public class WriteExcel {
	// Blank workbook
	XSSFWorkbook workbook = new XSSFWorkbook();
	// Create a blank sheet
	XSSFSheet sheet = workbook.createSheet("student Details");

	@Test
	public void test1() throws FileNotFoundException {
		FileReader fr = new FileReader("employees.json");
		JsonReader reader = Json.createReader(fr);
		JsonObject jsonObject = reader.readObject();
		JsonBuilderFactory jsonBuilderFactory = Json.createBuilderFactory(null);
		JsonObjectBuilder jsonObjectBuilder = jsonBuilderFactory.createObjectBuilder();
		for (int j = 40; j < 50; j++) {
		for (String key : jsonObject.keySet()) {
			jsonObjectBuilder.add(key, jsonObject.get(key));
		}

			jsonObjectBuilder.add("age", j);


			jsonObject = jsonObjectBuilder.build();
			System.out.println(jsonObject.toString());


// Iterate over data and write to sheet
			//Set<String> keyset = jsonObject.keySet();
			int rownum = 0;
			for (int i = 0; i < 5; i++) {
				// this creates a new row in the sheet
				Row row = sheet.createRow(rownum++);
				JsonValue objArr = jsonObject.get(i);
				int cellnum = 0;

				// this line creates a cell in the next column of that row
				Cell cell = row.createCell(cellnum++);
				cell.setCellValue(String.valueOf(jsonObject));
				//cell.setCellValue((Integer)obj);

			}
		}
		try {
			// this Writes the workbook gfgcontribute
			FileOutputStream out = new FileOutputStream(new File("gfgcontribute.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("gfgcontribute.xlsx written successfully on disk.");
		} catch (
				Exception e) {
			e.printStackTrace();
		}
	}
}