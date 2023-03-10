package com.example.backEnd.document;
import com.example.backEnd.application.*;

import java.util.List;

public interface DocumentService {
    public List<Document> getAllDocuments();
    public Document saveDocument(Document newDocument);
    public Document findById(Long documentId);
}
