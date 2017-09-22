package rewards.web;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import rewards.domain.model.Account;

/**
 * This view generates an Excel report from Account objects.
 */
public class AccountsXlsView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, Workbook workbook,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		@SuppressWarnings("unchecked")
		List<Account> accounts = (List<Account>) model.get("accounts");
		Sheet sheet = workbook.createSheet();
		
		CellStyle dateStyle = workbook.createCellStyle();
		dateStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));

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
		cell.setCellValue(new HSSFRichTextString(value));
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
