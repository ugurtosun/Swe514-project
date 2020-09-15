package com.company.InstructionSet;

import com.company.Instruction;
import com.company.MyCPU;

public class PRINT extends Instruction{

    MyCPU cpu;

    public PRINT (int opcode, int addressingMode, int operand, MyCPU cpu) {
        this.opcode = opcode;
        this.operand = operand;
        this.addressingMode = addressingMode;
        this.hasEffectOnCF = true;
        this.hasEffectOnSF = true;
        this.hasEffectOnZF = true;
        this.cpu = cpu;
        operate();
    }

    private void operate(){

        if(addressingMode == 0x0){
            System.out.println((char)operand);
        }
        else if(addressingMode == 0x1){
            switch (operand){
                case 0x0:
                    System.out.println((char)cpu.readPC());
                    break;
                case 0x1:
                    System.out.println((char)cpu.readA());
                    break;
                case 0x2:
                    System.out.println((char)cpu.readB());
                    break;
                case 0x3:
                    System.out.println((char)cpu.readC());
                    break;
                case 0x4:
                    System.out.println((char)cpu.readD());
                    break;
                case 0x5:
                    System.out.println((char)cpu.readE());
                    break;
                case 0x6:
                    System.out.println((char)cpu.readSP());
                    break;
                default:
                    System.out.println("Invalid addressing mode and register pair");
                    System.exit(0);
            }
        } else if(addressingMode == 0x2){
            switch (operand){
                case 0x0:
                    System.out.println((char) cpu.readMemory(cpu.readPC()));
                    break;
                case 0x1:
                    System.out.println((char) cpu.readMemory(cpu.readA()));
                    break;
                case 0x2:
                    System.out.println((char) cpu.readMemory(cpu.readB()));
                    break;
                case 0x3:
                    System.out.println((char) cpu.readMemory(cpu.readC()));
                    break;
                case 0x4:
                    System.out.println((char) cpu.readMemory(cpu.readD()));
                    break;
                case 0x5:
                    System.out.println((char) cpu.readMemory(cpu.readE()));
                    break;
                case 0x6:
                    System.out.println((char) cpu.readMemory(cpu.readSP()));
                    break;
                default:
                    System.out.println("Invalid addressing mode and register pair");
                    System.exit(0);
            }
        }else if(addressingMode == 0x3){
            System.out.println(((char)cpu.readMemory(operand)));
        }else{
            System.out.println("PRINT: Invalid addressing mode");
            System.exit(0);
        }
    }
}
