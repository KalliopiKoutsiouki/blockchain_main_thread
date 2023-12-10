package com.warehouse.model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class BlockDto {
    private String hash;
    private String previousHash;
    private String productData;
    private long timeStamp;
    private int nonce;

    public BlockDto(String previousHash, String productData) {
        this.previousHash = previousHash;
        this.productData = productData;
        this.timeStamp = new Date().getTime();
        this.hash = calculateBlockHash();
    }

    public String calculateBlockHash(){
        String dataToHash = previousHash+String.valueOf(timeStamp)
                +productData+String.valueOf(nonce);
        MessageDigest digest = null;
        byte[] bytes = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            bytes = digest.digest(dataToHash.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes){
            builder.append(String.format("%02x",b));
        }
        return builder.toString();
    }

    public String mineBlock(int prefix){
        String prefixString = new String(new char[prefix]).replace('\0','0');
        while (!hash.substring(0,prefix).equals(prefixString)){
            nonce++;
            hash = calculateBlockHash();
        }
        return hash;
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setProduct(String productData) {
        this.productData = productData;
    }
}

