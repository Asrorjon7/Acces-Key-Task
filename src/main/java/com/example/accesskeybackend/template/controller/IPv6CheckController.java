package com.example.accesskeybackend.template.controller;

import com.example.accesskeybackend.template.dto.IPv6CheckResponse;
import com.example.accesskeybackend.template.service.IPv6CheckService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownHostException;

@RestController
@RequestMapping("/api/public/checkIpv6Support")
@AllArgsConstructor
public class IPv6CheckController {
    private final IPv6CheckService iPv6CheckService;

    @GetMapping
    public ResponseEntity<IPv6CheckResponse> isCheckIPv6(@RequestParam("siteUrl") String siteUrl) throws UnknownHostException {

        return new ResponseEntity<>(iPv6CheckService.ipCheckResponse(siteUrl), HttpStatus.OK);

    }
}
