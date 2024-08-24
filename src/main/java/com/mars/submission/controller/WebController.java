package com.mars.submission.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String home() {
        return "index";  // ชื่อไฟล์ index.html ในโฟลเดอร์ templates
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // ชื่อไฟล์ HTML ที่อยู่ใน templates
    }

    @GetMapping("/register")
    public String register() {
        return "register"; // หน้าเพจสำหรับการลงทะเบียน
    }
}