package com.notdynamic.report;


import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
public class ReportModel<T> {
    private Map<String, Object> params = new HashMap<String, Object>();
    private List<T> data;
}
