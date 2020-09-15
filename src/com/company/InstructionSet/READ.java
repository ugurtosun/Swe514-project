package com.company.InstructionSet;

import com.company.Instruction;
import com.company.MyCPU;

import java.io.IOException;

public class READ extends Instruction {

    MyCPU cpu;
    char c;

    public READ (int opcode, int addressingMode, int operand, MyCPU cpu) {
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

        try {
            c = (char) System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(addressingMode == 0x0){
            System.out.println("READ: Invalid addressing mode");
            System.exit(0);
        }
        else if(addressingMode == 0x1){
                switch (operand){
                    case 0x0:
                        cpu.writePC(c);
                        break;
                    case 0x1:
                        cpu.writeA(c);
                        break;
                    case 0x2:
                        cpu.writeB(c);
                        break;
                    case 0x3:
                        cpu.writeC(c);
                        break;
                    case 0x4:
                        cpu.writeD(c);
                        break;
                    case 0x5:
                        cpu.writeE(c);
                        break;
                    case 0x6:
                        cpu.writeSP(c);
                        break;
                    default:
                        System.out.println("Invalid addressing mode and register pair");
                        System.exit(0);
                }
        }else if(addressingMode == 0x2){
            switch (operand){
                case 0x0:
                    cpu.writeMemory(cpu.readPC(), c);
                    break;
                case 0x1:
                    cpu.writeMemory(cpu.readA(), c);
                    break;
                case 0x2:
                    cpu.writeMemory(cpu.readB(), c);
                    break;
                case 0x3:
                    cpu.writeMemory(cpu.readC(), c);
                    break;
                case 0x4:
                    cpu.writeMemory(cpu.readD(), c);
                    break;
                case 0x5:
                    cpu.writeMemory(cpu.readE(), c);
                    break;
                case 0x6:
                    cpu.writeMemory(cpu.readSP(), c);
                    break;
                default:
                    System.out.println("Invalid addressing mode and register pair");
                    System.exit(0);
            }
        }else if(addressingMode == 0x3){
                    cpu.writeMemory(operand, c);
        }else{
                 System.out.println("READ: Invalid addressing mode");
                 System.exit(0);
        }
    }
}
