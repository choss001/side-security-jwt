package com.security.jss.util;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;

public class AuthBaseUtil {

  private AuthBaseUtil() {
    throw new IllegalStateException("AuthBaseUtil class");
  }

  private static final String API_KEY = "PASSLOGIN";

  public static String getId(String token) {
    Decoder decoder = Base64.getDecoder();
    byte[] decodedAuth = decoder.decode(token.replaceAll("^[a-zA-Z\\s]{6}", ""));

    return (new String(decodedAuth).replaceAll(":([\\w]+-)+[\\w]+", ""));
  }

  public static String getPassword(String token) {
    Decoder decoder = Base64.getDecoder();
    byte[] decodedAuth = decoder.decode(token.replaceAll("^[a-zA-Z\\s]{6}", ""));

    return (new String(decodedAuth)).replaceAll("^[0-9]+:", "");
  }

  public static String getAuthKey(String id) {
    StringBuilder idAppend = new StringBuilder(id);
    UUID uuid = UUID.nameUUIDFromBytes(idAppend.append(API_KEY).toString().getBytes());
    Encoder encoder1 = Base64.getEncoder();
    idAppend = new StringBuilder(id);
    idAppend.append(":");
    idAppend.append(uuid.toString().toUpperCase());
    byte[] encodeResult = encoder1.encode(idAppend.toString().getBytes());
    return (new String(encodeResult));
  }

  public static boolean verify(String token) {
    AuthBaseUtil.getPassword(token);
    StringBuilder idAppend = new StringBuilder(AuthBaseUtil.getId(token));
    idAppend.append(API_KEY);
    UUID uuid = UUID.nameUUIDFromBytes(idAppend.toString().getBytes());
    return AuthBaseUtil.getPassword(token).equalsIgnoreCase(uuid.toString());
  }
}
