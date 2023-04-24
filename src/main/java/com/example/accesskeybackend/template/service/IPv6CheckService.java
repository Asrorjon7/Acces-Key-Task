package com.example.accesskeybackend.template.service;

import com.example.accesskeybackend.template.IPv6Util;
import com.example.accesskeybackend.template.dto.IPv6CheckResponse;
import org.springframework.stereotype.Service;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

@Service
public class IPv6CheckService {
    public IPv6CheckResponse ipCheckResponse(String siteUrl) throws UnknownHostException {

        siteUrl = siteUrl.replaceAll("(http:\\/\\/|https:\\/\\/|\\/|www.)?", "");

        return new IPv6CheckResponse(Arrays.stream(InetAddress.getAllByName(siteUrl))
                .map(InetAddress::getHostAddress)
                .anyMatch(IPv6Util::isIPv6Address));


    }
}
