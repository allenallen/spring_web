package rewards.web;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import rewards.domain.model.Account;

// TODO 01: Return accounts in Microsoft Excel format

// TODO 01a: Study the code in AccountsXlsxView

/**
 * This view generates an Excel report, in the Office 2007 XLSX format,
 * from Account objects.
 */
public class AccountsXlsxView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, Workbook workbook,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		@SuppressWarnings("unchecked")
		List<Account> accounts = (List<Account>) model.get("accounts");
		Sheet sheet = workbook.createSheet();
		
		CellStyle dateStyle = workbook.createCellStyle();
		dateStyle.setDataFormat((short) BuiltinFormats.getBuiltinFormat("m/d/yy"));

		int rowNum = 0;
		for (Account account : accounts) {
			Row row = sheet.createRow(rowNum++);
			addStringCell(row, 0, account.getName());
			addStringCell(row, 1, account.getNumber());
			addDateCell(row, 2, account.getDateOfBirth(), dateStyle);
		}
	}

	private Cell addStringCell(Row row, int index, String value) {
		Cell cell = row.createCell((short) index);
		cell.setCellValue(new XSSFRichTextString(value));
		return cell;
	}

	private Cell addDateCell(Row row, int index, Date date,
			CellStyle dateStyle) {
		Cell cell = row.createCell((short) index);
		cell.setCellValue(date);
		cell.setCellStyle(dateStyle);
		return cell;
	}

}
