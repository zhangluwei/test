package com.luwei.test;
 

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Map;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class CharsetMain {
    /**
    * Logger for this class
    */
 
    public static void main(String[] args) {
        
        Charset cs = Charset.forName("utf8");
        
        System.out.println("charset --" +cs);
        
        
        ByteBuffer bf =  cs.encode("种");
        
        while(bf.hasRemaining()){
            System.out.println(byteToHexString(bf.get()));
        }
        
        System.out.println(cs.aliases());
        
//        Map<String,Charset> csMap = Charset.availableCharsets();
//        for (String key:csMap.keySet()) {
//            System.out.println("main(String[]) -key=" + key+ " , csMap=" + csMap.get(key));
//        }
        
    }
    
    public static String byteToHexString(byte src){   
        StringBuilder stringBuilder = new StringBuilder("");   
        
            int v = src & 0xFF;   
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {   
                stringBuilder.append(0);   
            }   
            stringBuilder.append(hv);   
        return stringBuilder.toString();   
    }   
}
