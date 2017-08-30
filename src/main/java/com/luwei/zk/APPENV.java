package com.luwei.zk;

public class APPENV {
        
    @ZKConfig("A")
    private   String A;
    @ZKConfig("B")
    private    String B;
    @ZKConfig("c")
    private  String C;
    public  String getA() {
        return A;
    }
    public  void setA(String a) {
        A = a;
    }
    public  String getB() {
        return B;
    }
    public  void setB(String b) {
        B = b;
    }
    public  String getC() {
        return C;
    }
    public  void setC(String c) {
        C = c;
    }
    
    @Override
    public String toString() {
        return "ENV [A=" + A + ", B=" + B + ", C=" + C + "]";
    }
    
    
    
}
