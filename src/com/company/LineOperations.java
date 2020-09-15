package com.company;

import java.util.Arrays;
import java.util.List;

public class LineOperations {

    private String line;
    private String[] splitLine;
    private final List<String> registerList = Arrays.asList("A", "B", "PC", "C", "D", "E", "S");
    private final List<String> indirectRegisterList = Arrays.asList("[A]", "[B]", "[PC]", "[C]", "[D]", "[E]", "[S]");
    private int opcode;
    private int addressingMode;
    private int operand;
    private String binaryOpcode;
    private String binaryAddressingMode;
    private String binaryOperand;
    private String binaryInstruction;
    private String hexInstruction;
    private boolean is00Supported = false;
    private boolean is01Supported = false;
    private boolean is10Supported = false;
    private boolean is11Supported = false;

    public LineOperations(String line) {
        this.line = line;
    }

    public void splitLine(){
        this.splitLine = line.trim().split(" ");
    }

    public String getBinaryInstruction() {
        return binaryInstruction;
    }

    public String getHexInstruction() {
        return hexInstruction;
    }

    public void findOpcode(){

        switch (splitLine[0]){
            case "HALT":
                this.opcode = 0x1;
                break;
            case "LOAD":
                this.opcode = 0x2;
                this.is00Supported = true;
                this.is01Supported = true;
                this.is10Supported = true;
                this.is11Supported = true;
                break;
            case "STORE":
                this.opcode = 0x3;
                this.is01Supported = true;
                this.is10Supported = true;
                this.is11Supported = true;
                break;
            case "ADD":
                this.opcode = 0x4;
                this.is00Supported = true;
                this.is01Supported = true;
                this.is10Supported = true;
                this.is11Supported = true;
                break;
            case "SUB":
                this.opcode = 0x5;
                this.is00Supported = true;
                this.is01Supported = true;
                this.is10Supported = true;
                this.is11Supported = true;
                break;
            case "INC":
                this.opcode = 0x6;
                this.is01Supported = true;
                break;
            case "DEC":
                this.opcode = 0x7;
                this.is01Supported = true;
                break;
            case "MUL":
                this.opcode = 0x8;
                this.is00Supported = true;
                this.is01Supported = true;
                this.is10Supported = true;
                this.is11Supported = true;
                break;
            case "DIV":
                this.opcode = 0x9;
                this.is00Supported = true;
                this.is01Supported = true;
                this.is10Supported = true;
                this.is11Supported = true;
                break;
            case "XOR":
                this.opcode = 0xA;
                this.is00Supported = true;
                this.is01Supported = true;
                this.is10Supported = true;
                this.is11Supported = true;
                break;
            case "AND":
                this.opcode = 0xB;
                this.is00Supported = true;
                this.is01Supported = true;
                this.is10Supported = true;
                this.is11Supported = true;
                break;
            case "OR":
                this.opcode = 0xC;
                this.is00Supported = true;
                this.is01Supported = true;
                this.is10Supported = true;
                this.is11Supported = true;
                break;
            case "NOT":
                this.opcode = 0xD;
                this.is00Supported = true;
                this.is01Supported = true;
                this.is10Supported = true;
                this.is11Supported = true;
                break;
            case "SHL":
                this.opcode = 0xE;
                this.is01Supported = true;
                break;
            case "SHR":
                this.opcode = 0xF;
                this.is01Supported = true;
                break;
            case "NOP":
                this.opcode = 0x10;
                break;
            case "PUSH":
                this.opcode = 0x11;
                this.is01Supported = true;
                break;
            case "POP":
                this.opcode = 0x12;
                this.is01Supported = true;
                break;
            case "CMP":
                this.opcode = 0x13;
                this.is00Supported = true;
                this.is01Supported = true;
                this.is10Supported = true;
                this.is11Supported = true;
                break;
            case "JMP":
                this.opcode = 0x14;
                this.is00Supported = true;
                break;
            case "JZ":
            case "JE":
                this.opcode = 0x15;
                this.is00Supported = true;
                break;
            case "JNZ":
            case "JNE":
                this.opcode = 0x16;
                this.is00Supported = true;
                break;
            case "JC":
                this.opcode = 0x17;
                this.is00Supported = true;
                break;
            case "JNC":
                this.opcode = 0x18;
                this.is00Supported = true;
                break;
            case "JA":
                this.opcode = 0x19;
                this.is00Supported = true;
                break;
            case "JAE":
                this.opcode = 0x20;
                this.is00Supported = true;
                break;
            case "JB":
                this.opcode = 0x21;
                this.is00Supported = true;
                break;
            case "JBE":
                this.opcode = 0x22;
                this.is00Supported = true;
                break;
            case "READ":
                this.opcode = 0x23;
                this.is01Supported = true;
                this.is10Supported = true;
                this.is11Supported = true;
                break;
            case "PRINT":
                this.opcode = 0x24;
                this.is00Supported = true;
                this.is01Supported = true;
                this.is10Supported = true;
                this.is11Supported = true;
                break;
            default:
                this.opcode = 0xFF;
        }
    }

    public void findAddressingMode(){

        if(splitLine.length == 1)
        {
            this.addressingMode = 0x0;
            this.operand = 0x0000;
            return;
        }
        String address = splitLine[1];

        if(registerList.contains(address) && is01Supported){
            this.addressingMode = 0x1;
            switch (address){
                case "PC":
                    this.operand = 0x0000;
                    break;
                case "A":
                    this.operand = 0x0001;
                    break;
                case "B":
                    this.operand = 0x0002;
                    break;
                case "C":
                    this.operand = 0x0003;
                    break;
                case "D":
                    this.operand = 0x0004;
                    break;
                case "E":
                    this.operand = 0x0005;
                    break;
                case "S":
                    this.operand = 0x0006;
                    break;
                default:
                    this.operand = 0xFFFF;
                    break;
            }
            return;
        }

        if(indirectRegisterList.contains(address) && is10Supported){
            this.addressingMode = 0x2;
            switch (address){
                case "[PC]":
                    this.operand = 0x0000;
                    break;
                case "[A]":
                    this.operand = 0x0001;
                    break;
                case "[B]":
                    this.operand = 0x0002;
                    break;
                case "[C]":
                    this.operand = 0x0003;
                    break;
                case "[D]":
                    this.operand = 0x0004;
                    break;
                case "[E]":
                    this.operand = 0x0005;
                    break;
                case "[S]":
                    this.operand = 0x0006;
                    break;
                default:
                    this.operand = 0xFFFF;
                    break;
            }
            return;
        }

        if(address.trim().startsWith("[") && address.trim().endsWith("]")){

            String substring = address.trim().substring(1, address.trim().length() - 1);
            if(isBitSet(substring, 4)){
                this.addressingMode = 0x03;
                this.operand = Integer.parseInt(substring,16);
                return;
            }
        }

        if(address.matches("^[0123456789abcdefABCDEFh]+$") && is00Supported){

            if(address.indexOf(address.length()-1) == 'h'){
                address = address.substring(0, address.length()-1);
            }
            this.addressingMode = 0x0;
            this.operand = Integer.parseInt(address,16);
            if(operand > 65535){
                System.out.println("Invalid Immediate Data Error: Value out of range");
                System.exit(0);
            }
        }
    }

    public void createBinaryForm(){

        binaryOpcode = Integer.toBinaryString(opcode);
        binaryOpcode = binaryOpcode.length() == 6 ? binaryOpcode : "000000".substring(0 ,6 - binaryOpcode.length()) + binaryOpcode;

        binaryAddressingMode = Integer.toBinaryString(addressingMode);
        binaryAddressingMode = binaryAddressingMode.length() == 2 ? binaryAddressingMode : "00".substring(0 ,2 - binaryAddressingMode.length()) + binaryAddressingMode;

        binaryOperand = Integer.toBinaryString(operand);
        binaryOperand = binaryOperand.length() == 16 ? binaryOperand : "0000000000000000".substring(0 ,16 - binaryOperand.length()) + binaryOperand;

        binaryInstruction = binaryOpcode + binaryAddressingMode + binaryOperand;
 //       System.out.println(binaryInstruction);

        hexInstruction = Integer.toString(Integer.parseInt(binaryInstruction,2),16);
        hexInstruction = hexInstruction.length() == 6 ? hexInstruction : "000000".substring(0 ,6 - hexInstruction.length()) + hexInstruction;
 //       System.out.println(hexInstruction.toUpperCase());
    }

    private boolean isBitSet(String hexValue, int bitNumber) {
        int val = Integer.valueOf(hexValue, 16);
        return (val & (1 << bitNumber)) != 0;
    }
}
