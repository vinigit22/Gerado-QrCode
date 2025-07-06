package com.example.qrcode.generator.service;


import com.example.qrcode.generator.dto.QrCodeGenereteResponse;
import com.example.qrcode.generator.ports.StoregePort;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class QrCodeGeneratorService {
    private final StoregePort storege;

    public QrCodeGeneratorService(StoregePort storege) {
        this.storege = storege;
    }

    public QrCodeGenereteResponse generateAndUploadQrCode(String text) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 200, 200);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        byte[] pngQrCodeData = pngOutputStream.toByteArray();
        String url = storege.uploadFile(pngQrCodeData, UUID.randomUUID().toString(),"Image/png");

        return  new QrCodeGenereteResponse(url);
    }
}