package com.example.Backend.services;

import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
@Service
@Slf4j
public class PdfExtractService {
    private final ResourceLoader resourceLoader;

    public PdfExtractService(@Qualifier("webApplicationContext")ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
    public String extractText(String classpathLocation) {
        Resource resource = resourceLoader.getResource(classpathLocation);
        try (InputStream inputStream = resource.getInputStream();
             PDDocument document = Loader.loadPDF(inputStream.readAllBytes())) {

            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);
            return text;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
