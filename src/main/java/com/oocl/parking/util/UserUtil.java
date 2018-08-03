package com.oocl.parking.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserUtil {
   public String getRandomPassword(){
      return String.valueOf((int)(Math.random() * 1000000));
   }

   public String getEncryptionPassword(String password){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return  bCryptPasswordEncoder.encode(password);
   }

}
