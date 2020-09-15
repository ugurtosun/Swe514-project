package com.company.InstructionSet;

import com.company.Instruction;
import com.company.MyCPU;

public class PUSH extends Instruction {

    MyCPU cpu;

    public PUSH (int opcode, int addressingMode, int operand, MyCPU cpu) {
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

        if(addressingMode == 0x1){
            switch (operand){
                case 0x0:
                    cpu.writeMemory(cpu.readSP(), cpu.readPC());
                    cpu.writeSP(cpu.readSP() - 2); //////////// 2 ile ilgilenilmesi lazım
                    break;
                case 0x1:
                    cpu.writeMemory(cpu.readSP(), cpu.readA());
                    cpu.writeSP(cpu.readSP() - 2); //////////// 2 ile ilgilenilmesi lazım
                    break;
                case 0x2:
                    cpu.writeMemory(cpu.readSP(), cpu.readB());
                    cpu.writeSP(cpu.readSP() - 2); //////////// 2 ile ilgilenilmesi lazım
                    break;
                case 0x3:
                    cpu.writeMemory(cpu.readSP(), cpu.readC());
                    cpu.writeSP(cpu.readSP() - 2); //////////// 2 ile ilgilenilmesi lazım
                    break;
                case 0x4:
                    cpu.writeMemory(cpu.readSP(), cpu.readD());
                    cpu.writeSP(cpu.readSP() - 2); //////////// 2 ile ilgilenilmesi lazım
                    break;
                case 0x5:
                    cpu.writeMemory(cpu.readSP(), cpu.readE());
                    cpu.writeSP(cpu.readSP() - 2); //////////// 2 ile ilgilenilmesi lazım
                    break;
                case 0x6:
                    cpu.writeMemory(cpu.readSP(), cpu.readSP());
                    cpu.writeSP(cpu.readSP() - 2); //////////// 2 ile ilgilenilmesi lazım
                    break;
                default:
                    System.out.println("Invalid addressing mode and register pair");
                    System.exit(0);
            }
        } else{
            System.out.println("PUSH: Invalid addressing mode");
            System.exit(0);
        }
    }
}
