package com.dynamic.jesperreport.student;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class JasperReportService {

    public byte[] generateStudentReport(List<Student> students) throws JRException, FileNotFoundException {
        // Load the JRXML file from resources
        InputStream jasperStream = this.getClass().getResourceAsStream("/reports/student_report.jrxml");
        
        if (jasperStream == null) {
            throw new FileNotFoundException("Jasper report template not found in path /reports/student_report.jrxml");
        }

        // Compile the JRXML file
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperStream);
        
        // Convert students to JRBeanCollectionDataSource
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(students);

        // Parameters for the report (can be empty if not needed)
        Map<String, Object> parameters = new HashMap<>();

        // Fill the report
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        // Export report to PDF
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}
