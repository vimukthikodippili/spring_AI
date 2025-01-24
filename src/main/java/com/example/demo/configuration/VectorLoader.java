//package com.example.demo.configuration;
//
//import org.springframework.ai.document.Document;
//import org.springframework.ai.embedding.EmbeddingModel;
//import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
//import org.springframework.ai.reader.pdf.config.PdfDocumentReaderConfig;
//import org.springframework.ai.transformer.splitter.TokenTextSplitter;
//import org.springframework.ai.vectorstore.SimpleVectorStore;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.Resource;
//
//import java.io.File;
//import java.util.List;
//
//@Configuration
//public class VectorLoader {
//
//    @Value("classpath:/pdf/2023050195.pdf")
//    private Resource pdfResource;
//
//    @Bean
//    SimpleVectorStore simpleVectorStore(EmbeddingModel embeddingModel) {
//        SimpleVectorStore vectorStore = new SimpleVectorStore(embeddingModel);
//
//        File vectorStoreFile = new File("F://freecodecampm Ai/demo/src/main/resources/pdf/6 Unit Testing.pdf/vector_store.json");
//
//        if (vectorStoreFile.exists()) {
//            System.out.println("Loaded vector store from file.");
//            vectorStore.load(vectorStoreFile);
//        } else {
//            System.out.println("Creating vector store...");
//            PdfDocumentReaderConfig config = PdfDocumentReaderConfig.builder().build();
//
//            // Use the correct constructor
//            PagePdfDocumentReader reader = new PagePdfDocumentReader(pdfResource, config);
//
//            TokenTextSplitter textSplitter = new TokenTextSplitter();
//            List<Document> docs = textSplitter.apply(reader.get());
//            vectorStore.add(docs);
//
//            vectorStore.save(vectorStoreFile);
//            System.out.println("Vector store created successfully.");
//        }
//
//        return vectorStore;
//    }
//}
