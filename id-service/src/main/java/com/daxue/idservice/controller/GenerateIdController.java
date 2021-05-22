package com.daxue.idservice.controller;

import com.daxue.idservice.service.GenerateIdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author daxue0929
 * @date 2021/05/23
 **/
@Slf4j
@RestController
public class GenerateIdController {

    final GenerateIdService generateIdService;

    public GenerateIdController(GenerateIdService generateIdService) {
        this.generateIdService = generateIdService;
    }


    @GetMapping("/generateId")
    public String generateId() {
        return "";
    }
}
