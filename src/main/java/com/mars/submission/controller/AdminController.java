package com.mars.submission.controller;

import com.mars.submission.constant.Status;
import com.mars.submission.reposotiry.model.InsuranceApplication;
import com.mars.submission.reposotiry.model.User;
import com.mars.submission.services.InsuranceApplicationService;
import com.mars.submission.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private InsuranceApplicationService insuranceApplicationService;


    @GetMapping
    public String viewApplications(Model model) {
        model.addAttribute("pendingApplications", insuranceApplicationService.findByStatusIn(Status.PENDING));
        model.addAttribute("processedApplications", insuranceApplicationService.findByStatusIn(Status.APPROVED, Status.REJECTED));
        return "admin";
    }

    @PostMapping("/approve/{id}")
    public String approve(@PathVariable String id) {
        insuranceApplicationService.UpdateSatusApplication(id, Status.APPROVED);
        return "redirect:/admin";
    }

    @PostMapping("/reject/{id}")
    public String reject(@PathVariable String id) {
        insuranceApplicationService.UpdateSatusApplication(id, Status.REJECTED);
        return "redirect:/admin";
    }

}