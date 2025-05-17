package com.xdra.hub.controller;

import com.xdra.hub.api.TransmissionApi;
import com.xdra.hub.model.TransmitDataRequest;
import com.xdra.hub.transmission.TransmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 接收 Python 脚本发回来的数据，并存库
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class TransmissionController implements TransmissionApi {

    private final TransmissionService transmissionService;

    /**
     * Python 脚本通过 POST /api/v1/transmit-data 把最终 payload 发回这里
     */
    @Override
    @PostMapping("/transmit-data")
    public ResponseEntity<Void> transmitData(@RequestBody TransmitDataRequest request) {
        transmissionService.transmitData(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
