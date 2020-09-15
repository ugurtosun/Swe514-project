package com.company.InstructionSet;

import com.company.Instruction;
import com.company.MyCPU;

public class LOAD extends Instruction {

    MyCPU cpu;

    public LOAD(int opcode, int addressingMode, int operand, MyCPU cpu) {
        this.opcode = opcode;
        this.operand = operand;
        this.addressingMode = addressingMode;
        this.hasEffectOnCF = false;
        this.hasEffectOnSF = false;
        this.hasEffectOnZF = false;
        this.cpu = cpu;
        operate();
    }

    private void operate(){

        if(addressingMode == 0x0){
            cpu.writeA(operand);
        }
        else if(addressingMode == 0x1){
            switch (operand){
                case 0x0:
                    cpu.writeA(cpu.readPC());
                    break;
                case 0x1:
                    cpu.writeA(cpu.readA());
                    break;
                case 0x2:
                    cpu.writeA(cpu.readB());
                    break;
                case 0x3:
                    cpu.writeA(cpu.readC());
                    break;
                case 0x4:
                    cpu.writeA(cpu.readD());
                    break;
                case 0x5:
                    cpu.writeA(cpu.readE());
                    break;
                case 0x6:
                    cpu.writeA(cpu.readSP());
                    break;
                default:
                    System.out.println("Invalid addressing mode and register pair");
                    System.exit(0);
            }
        } else if(addressingMode == 0x2){
            switch (operand){
                case 0x0:
                    cpu.writeA(cpu.readMemory(cpu.readPC()));
                    break;
                case 0x1:
                    cpu.writeA(cpu.readMemory(cpu.readA()));
                    break;
                case 0x2:
                    cpu.writeA(cpu.readMemory(cpu.readB()));
                    break;
                case 0x3:
                    cpu.writeA(cpu.readMemory(cpu.readC()));
                    break;
                case 0x4:
                    cpu.writeA(cpu.readMemory(cpu.readD()));
                    break;
                case 0x5:
                    cpu.writeA(cpu.readMemory(cpu.readE()));
                    break;
                case 0x6:
                    cpu.writeA(cpu.readMemory(cpu.readSP()));
                    break;
                default:
                    System.out.println("Invalid addressing mode and register pair");
                    System.exit(0);
            }
        }else if(addressingMode == 0x3){
            cpu.writeA(cpu.readMemory(operand));
        }else{
            System.out.println("LOAD: Invalid addressing mode");
            System.exit(0);
        }
    }
}
