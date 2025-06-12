package com.co.activos.msel0001.infrastructure.entryPoints.api;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/replication")
@AllArgsConstructor
public class Replication {


    @GetMapping
    public String status() {
        return "Up and running";
    }

}
