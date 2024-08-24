package com.mars.submission.services;

import com.mars.submission.constant.Status;
import com.mars.submission.reposotiry.InsuranceApplicationRepository;
import com.mars.submission.reposotiry.model.InsuranceApplication;
import com.mars.submission.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceApplicationService {

    @Autowired
    private InsuranceApplicationRepository repository;

    public void saveApplication(InsuranceApplication application) {
        application.setStatus(Status.PENDING);
        application.setCreatedAt(DateUtil.getCurrentDate());
        repository.save(application);
    }

    public InsuranceApplication getApplication(String id) {
        return repository.findById(id)
                .map(application -> {
                    application.setUpdatedAt(DateUtil.getCurrentDate());
                    return application;
                })
                .orElse(null);
    }

    public void updateApplication(String id, InsuranceApplication updatedApplication) {
        repository.findById(id).map(application -> {
            application.setName(updatedApplication.getName());
            application.setAddress(updatedApplication.getAddress());
            application.setPhoneNumber(updatedApplication.getPhoneNumber());
            application.setUpdatedAt(DateUtil.getCurrentDate());
            return repository.save(application);
        }).orElseThrow(() -> new ResourceNotFoundException("Application not found"));
    }

    public void cancelApplication(String id) {
        repository.deleteById(id);
    }

    public InsuranceApplication UpdateSatusApplication(String id, Status status) {
        return repository.findById(id).map(application -> {
            application.setStatus(status);
            application.setLastUpdateStatusAt(DateUtil.getCurrentDate());
            return repository.save(application);
        }).orElseThrow(() -> new ResourceNotFoundException("Application not found"));
    }

    public List<InsuranceApplication> findByStatusIn(Status... statuses) {
        return repository.findByStatusIn(statuses);
    }
}