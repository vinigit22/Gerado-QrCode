package com.example.qrcode.generator.Controller;


import com.example.qrcode.generator.dto.QrCodeGenereteREquest;
import com.example.qrcode.generator.dto.QrCodeGenereteResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcode")
public class qrcodeCOntroller {
    public ResponseEntity<QrCodeGenereteResponse> generate(@RequestBody QrCodeGenereteREquest request) {
          return  null;
    }
}
