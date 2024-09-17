package com.dynamic.jesperreport.report;

public interface ReportService {
	public <T> void exportDataReport(ReportModel<T> model);
}
