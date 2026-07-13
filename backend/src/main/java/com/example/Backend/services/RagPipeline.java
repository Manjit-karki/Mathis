package com.example.Backend.services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.pdf.config.PdfDocumentReaderConfig;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RagPipeline {
    private final VectorStore vectorStore;

    private Resource pdfResource;

    @PostConstruct
    public void runPipeline() {
        System.out.println("RagPipeline started");
        PagePdfDocumentReader pdfReader = new PagePdfDocumentReader("documents/Chemistry-XII-2077-full-book.pdf",PdfDocumentReaderConfig.defaultConfig());
        List<Document> extractedDocuments = pdfReader.read();
        System.out.println("Extraction complete.");

        TokenTextSplitter transformer = TokenTextSplitter.builder().build();
        List<Document> chunkedDocuments = transformer.apply(extractedDocuments);
        System.out.println("Transformation complete. Created " + chunkedDocuments.size() + " chunks.");

        vectorStore.accept(chunkedDocuments);
        System.out.println("Load complete. Data is ready for RAG!");
    }
}
