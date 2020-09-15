package com.company;

public class MyCPU {

    private boolean ZF;  //holds Zero Flag value as a boolean
    private boolean CF;  //holds Carry Flag value as a boolean
    private boolean SF;  //holds Sign Flag value as a boolean
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int SP;
    private int PC;
    private int[] memory = new int[64000];

    public MyCPU() {
        PC = 0;
    }

    public int readA(){
        return A;
    }
    public boolean writeA(int binaryNumber){
        if(binaryNumber > 65535){
            A = binaryNumber - 65536;
            return true;
        }else{
            A = binaryNumber;
            return false;
        }
    }
    public int readB(){
        return B;
    }
    public boolean writeB(int binaryNumber){
        if(binaryNumber > 65535){
            B = binaryNumber - 65536;
            return true;
        }else{
            B = binaryNumber;
            return false;
        }
    }
    public int readC(){
        return C;
    }
    public boolean writeC(int binaryNumber){
        if(binaryNumber > 65535){
            C = binaryNumber - 65536;
            return true;
        }else{
            C = binaryNumber;
            return false;
        }
    }
    public int readD(){
        return D;
    }
    public boolean writeD(int binaryNumber){
        if(binaryNumber > 65535){
            D = binaryNumber - 65536;
            return true;
        }else{
            D = binaryNumber;
            return false;
        }
    }
    public int readE(){
        return E;
    }
    public boolean writeE(int binaryNumber){
        if(binaryNumber > 65535){
            E = binaryNumber - 65536;
            return true;
        }else{
            E = binaryNumber;
            return false;
        }
    }
    public int readSP(){
        return SP;
    }
    public boolean writeSP(int binaryNumber){
        if(binaryNumber > 65535){
            SP = binaryNumber - 65536;
            return true;
        }else{
            SP = binaryNumber;
            return false;
        }
    }
    public int readPC(){
        return PC;
    }
    public boolean writePC(int binaryNumber){
        if(binaryNumber > 65535){
            PC = binaryNumber - 65536;
            return true;
        }else{
            PC = binaryNumber;
            return false;
        }
    }
    public boolean writeMemory(int memoryIndex, int binaryNumber){
        if(binaryNumber > 65535){
            memory[memoryIndex] = binaryNumber - 65536;
            return true;
        }else{
            memory[memoryIndex] = binaryNumber;
            return false;
        }
    }
    public int readMemory(int memoryIndex){
        return memory[memoryIndex];
    }

    public boolean isZF() {
        return ZF;
    }

    public void setZF(boolean ZF) {
        this.ZF = ZF;
    }

    public boolean isCF() {
        return CF;
    }

    public void setCF(boolean CF) {
        this.CF = CF;
    }

    public boolean isSF() {
        return SF;
    }

    public void setSF(boolean SF) {
        this.SF = SF;
    }
}
