package com.dynamic.jesperreport.report;

public class ReportServiceImpl implements ReportService{
	
	@Override
	public <T> void exportDataReport(ReportModel<T> model) {

	}

	/*
	 * @Override public byte[] exportReport(ReportFormat format, ReportModel model)
	 * throws SystemException, BusinessRuleViolationException {
	 * 
	 * try { File file = ResourceUtils.getFile("classpath:templates/reports.jrxml");
	 * JasperReport jasperReport =
	 * JasperCompileManager.compileReport(file.getAbsolutePath());
	 * JRBeanCollectionDataSource dataSource = new
	 * JRBeanCollectionDataSource(model.getData());
	 * 
	 * JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
	 * model.getParams(), dataSource);
	 * 
	 * ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	 * 
	 * if (format == ReportFormat.PDF) {
	 * 
	 * JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
	 * 
	 * } else if (format == ReportFormat.EXCEL) {
	 * 
	 * JRXlsxExporter exporter = new JRXlsxExporter(); exporter.setExporterInput(new
	 * SimpleExporterInput(jasperPrint)); exporter.setExporterOutput(new
	 * SimpleOutputStreamExporterOutput(outputStream));
	 * 
	 * SimpleXlsxReportConfiguration configuration = new
	 * SimpleXlsxReportConfiguration(); configuration.setOnePagePerSheet(true);
	 * exporter.setConfiguration(configuration);
	 * 
	 * exporter.exportReport();
	 * 
	 * } else { throw new BusinessRuleViolationException("WRONG REPORT FORMAT"); }
	 * 
	 * return outputStream.toByteArray(); } catch (Exception e) {
	 * e.printStackTrace(); throw new SystemException(e.getMessage()); } }
	 */
	private <T> byte[] exportReport(ReportModel<T> model) {
		// TODO Auto-generated method stub
		return null;
	}

}
