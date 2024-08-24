package com.mars.submission.reposotiry.model;

import com.mars.submission.constant.Status;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Document(indexName = "insurance_application")
public class InsuranceApplication {

    @Id
    private String id;
    private String name;
    private String address;
    private String phoneNumber;
    private String photoBase64;
    private Status status; // e.g., PENDING, APPROVED, REJECTED

    private Date createdAt;
    private Date updatedAt;
    private Date lastUpdateStatusAt;

    // Getters and Setters
}