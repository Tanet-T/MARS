package com.mars.submission.reposotiry;

import com.mars.submission.constant.Status;
import com.mars.submission.reposotiry.model.InsuranceApplication;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface InsuranceApplicationRepository extends ElasticsearchRepository<InsuranceApplication, String> {

    List<InsuranceApplication> findByStatusIn(Status... statuses);

}