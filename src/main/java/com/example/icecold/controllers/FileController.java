package com.example.icecold.controllers;

import com.example.icecold.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class FileController {

    private final StorageService storageService;

    @Autowired
    public FileController(StorageService storageService){
        this.storageService = storageService;
    }


    @PostMapping("dashboard/imageupload")
    public String uploadImage(
            @RequestParam(name="file") MultipartFile uploadedImage,
            Model model){
        storageService.store(uploadedImage);
        model.addAttribute("success", true);
        return "redirect:/dashboard";
    }
}
