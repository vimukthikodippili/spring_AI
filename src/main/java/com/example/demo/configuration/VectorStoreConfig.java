//package com.example.demo.configuration;
//import org.springframework.ai.document.Document;
//import org.springframework.ai.embedding.EmbeddingModel;
//import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
//import org.springframework.ai.reader.pdf.config.PdfDocumentReaderConfig;
//import org.springframework.ai.transformer.splitter.TokenTextSplitter;
//import org.springframework.ai.vectorstore.SimpleVectorStore;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.core.io.Resource;
//
//import java.io.File;
//import java.util.List;
//
//@Configuration
//public class VectorStoreConfig {
//
//    @Bean
//    public SimpleVectorStore vectorStore(EmbeddingModel embeddingModel) {
//        SimpleVectorStore vectorStore = new SimpleVectorStore(embeddingModel);
//
//        File vectorStoreFile = new File("vector_store.json");
//
//        if (!vectorStoreFile.exists()) {
//            PdfDocumentReaderConfig config = PdfDocumentReaderConfig.builder().build();
//            // Use FileSystemResource to wrap the PDF file
//            Resource pdfResource = new FileSystemResource(
//                    "F:\\freecodecampm Ai\\demo\\src\\main\\resources\\pdf\\JavaInterviewQuestions-UdemyCourse-September2016.pdf");
//            PagePdfDocumentReader reader = new PagePdfDocumentReader(pdfResource, config);
//
//            TokenTextSplitter textSplitter = new TokenTextSplitter();
//            List<Document> documents = textSplitter.apply(reader.get());
//
//            vectorStore.add(documents);
//            vectorStore.save(vectorStoreFile);
//            System.out.println("Vector store created successfully!");
//        } else {
//            vectorStore.load(vectorStoreFile);
//            System.out.println("Loaded existing vector store.");
//        }
//
//        return vectorStore;
//    }
//}