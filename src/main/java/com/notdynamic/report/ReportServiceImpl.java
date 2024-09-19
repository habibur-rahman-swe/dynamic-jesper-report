package com.notdynamic.report;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

@Service
public class ReportServiceImpl implements ReportService {
/*
	@Override
	public byte[] exportReport(ReportFormat format, RequestType requestType, ReportModel model)
			throws SystemException, BusinessRuleViolationException {

		String templateName = "";
		JasperPrint jasperPrint = null;

		switch (requestType.name()) {
		case "FNF":
			templateName = requestType.getName().toLowerCase();
			break;
		}

		try {
			jasperPrint = generateReport(templateName, model);
		} catch (FileNotFoundException | JRException e) {
			throw new SystemException();
		}

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		try {
			if (format == ReportFormat.PDF) {

				JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

			} else if (format == ReportFormat.EXCEL) {

				JRXlsxExporter exporter = new JRXlsxExporter();
				exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
				exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));

				SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
				configuration.setOnePagePerSheet(false);  // Ensures the entire report fits in a single sheet.
				configuration.setRemoveEmptySpaceBetweenRows(true);  // Compact rows.
				configuration.setWhitePageBackground(false);  // Avoid extra page background.
				configuration.setAutoFitRow(true);  // Adjust column widths automatically.
				configuration.setWrapText(true);  // Wrap text within cells to avoid unnecessary page breaks
				configuration.setIgnoreCellBorder(true);  // Ensures borders don't affect layout and pagination
				configuration.setDetectCellType(true); // Correctly identifies cell data types.
				
				exporter.setConfiguration(configuration);
				exporter.exportReport();

			} else {
				throw new BusinessRuleViolationException("WRONG REPORT FORMAT");
			}

			return outputStream.toByteArray();

		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemException(e.getMessage());
		}
	}

	public <T> JasperPrint generateReport(String templateName, ReportModel model)
			throws JRException, FileNotFoundException {
		String templatePath = "/reports/" + templateName + ".jrxml";
		// Load the JRXML file from resources
		InputStream jasperStream = this.getClass().getResourceAsStream(templatePath);

		if (jasperStream == null) {
			throw new FileNotFoundException("Jasper report template not found in path " + templatePath);
		}

		// Compile the JRXML file
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperStream);

		// Convert students to JRBeanCollectionDataSource
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(model.getData());

		// Parameters for the report (can be empty if not needed)
		Map<String, Object> parameters = model.getParams();

		// Fill the report
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

//		// Export report to PDF
//		return JasperExportManager.exportReportToPdf(jasperPrint);

		return jasperPrint;
	}
*/
}
