package com.example.Backend.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@org.springframework.data.mongodb.core.mapping.Document(collection = "documents")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Document {
    @id
    private String id;
    private String userID;
    private String documentId;
    private String fileName;
}
