package com.example.qrcode.generator.ports;

public interface StoregePort {
    String uploadfile(byte[] fileData,  String filename, String contenType);

    String uploadFile(byte[] fileData, String fileName, String contentType);
}
