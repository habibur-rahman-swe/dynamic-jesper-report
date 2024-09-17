package com.dynamic.jesperreport.report;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReportModel<T> {
	private String title;
	private String requestType;
	private List<T> dataList;
	private Map<String, Object> params = new HashMap<String, Object>();
}
