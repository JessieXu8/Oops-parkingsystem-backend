package com.oocl.parking.util;

public class UserUtil {
   public String getRandomPassword(){
      return String.valueOf((int)(Math.random() * 1000000));
   }
}
