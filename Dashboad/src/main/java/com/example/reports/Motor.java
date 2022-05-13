package com.example.reports;

public class Motor {
    public final int id;
    public final PIDF pidf;
    
    public Motor(){
        this(-1);
    }

    public Motor(int id){
        this.id = id;
        this.pidf = new PIDF();
        pidf.setP(Math.random());
        pidf.setI(Math.random());
        pidf.setD(Math.random());
        pidf.setF(Math.random());
    }

    @Override
    public String toString(){
        return "motor{id:"+id+", "+pidf.toString()+"}";
    }

    private class PIDF{
        public double p;
        public double i;
        public double d;
        public double f;

        public PIDF(){}

        public PIDF(double p, double i, double d, double f){
            this.p = p;
            this.i = i;
            this.d = d;
            this.f = f;
        }

        @Override
        public String toString(){
            return "pidf{p:"+p+", i:"+i+" d:"+d+", f:"+f+"}";
        }
        
        public void setP(double p) {
            this.p = p;
        }

        public void setI(double i) {
            this.i = i;
        }

        public void setD(double d) {
            this.d = d;
        }

        public void setF(double f) {
            this.f = f;
        }
    }
}
