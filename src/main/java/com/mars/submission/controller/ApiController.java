package com.mars.submission.controller;

import com.mars.submission.constant.Status;
import com.mars.submission.reposotiry.model.InsuranceApplication;
import com.mars.submission.services.InsuranceApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("/api/applications")
public class ApiController {


    @Autowired
    private InsuranceApplicationService insuranceApplicationService;

    @PostMapping("/apply")
    public String apply(
            @RequestParam("name") String name,
            @RequestParam("address") String address,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("photo") MultipartFile photo,
            Model model) {

        // Create a new InsuranceApplication object and set its fields
        InsuranceApplication application = new InsuranceApplication();
        application.setName(name);
        application.setAddress(address);
        application.setPhoneNumber(phoneNumber);

        try {
            String photoBase64 = Base64.getEncoder().encodeToString(photo.getBytes());

            application.setPhotoBase64(photoBase64);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Save the application using the service
        insuranceApplicationService.saveApplication(application);

        // เพิ่มข้อความสำเร็จไปที่ model
        model.addAttribute("message", "Application submitted successfully!");
        return "index";
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable String id, @RequestBody InsuranceApplication application) {
        insuranceApplicationService.updateApplication(id, application);
        return "Application updated successfully!";
    }

    @DeleteMapping("/cancel/{id}")
    public String cancel(@PathVariable String id) {
        insuranceApplicationService.cancelApplication(id);
        return "Application cancelled successfully!";
    }

    @PostMapping("/approve/{id}")
    public String approve(@PathVariable String id) {
        insuranceApplicationService.UpdateSatusApplication(id, Status.APPROVED);
        return "Application approve successfully!";
    }

    @PostMapping("/reject/{id}")
    public String reject(@PathVariable String id) {
        insuranceApplicationService.UpdateSatusApplication(id, Status.REJECTED);
        return "Application reject successfully!";
    }

    @GetMapping("/listAll")
    public List<InsuranceApplication> getAllApplications() {
        return insuranceApplicationService.findByStatusIn(Status.PENDING, Status.APPROVED, Status.REJECTED);
    }
}