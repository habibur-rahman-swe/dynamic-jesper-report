package com.dynamic.jesperreport.student;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	private final JasperReportService jasperReportService;
    private final ObjectMapper objectMapper;  // For JSON conversion

    public StudentController(JasperReportService jasperReportService, ObjectMapper objectMapper) {
        this.jasperReportService = jasperReportService;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/generate-pdf")
    public ResponseEntity<byte[]> generatePdf(@RequestBody List<Student> students) {
        try {
            // Generate PDF using JasperReportService
            byte[] pdfBytes = jasperReportService.generateStudentReport(students);

            // Set headers for the PDF response
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=students.pdf");
            headers.setContentType(org.springframework.http.MediaType.APPLICATION_PDF);

            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
        } catch (Exception e) {

        	e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
 // New method that accepts a JSON string in the request body
    @PostMapping("/generate-pdf-from-json")
    public ResponseEntity<byte[]> generatePdfFromJson(@RequestBody String jsonBody) {
        try {
            // Convert JSON string to List<Student> using Jackson
            List<Student> students = objectMapper.readValue(jsonBody, new TypeReference<List<Student>>() {});

            // Generate PDF using JasperReportService
            byte[] pdfBytes = jasperReportService.generateStudentReport(students);

            // Set headers for the PDF response
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=students.pdf");
            headers.setContentType(org.springframework.http.MediaType.APPLICATION_PDF);

            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
