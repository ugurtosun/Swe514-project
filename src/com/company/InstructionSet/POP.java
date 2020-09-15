package com.company.InstructionSet;

import com.company.Instruction;
import com.company.MyCPU;

public class POP extends Instruction {

    MyCPU cpu;

    public POP (int opcode, int addressingMode, int operand, MyCPU cpu) {
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
                    cpu.writePC(cpu.readMemory(cpu.readSP()));
                    cpu.writeSP(cpu.readSP() + 2); //////////// 2 ile ilgilenilmesi lazım + stack boş mu dolu mu kontolü ?
                    break;
                case 0x1:
                    cpu.writeA(cpu.readMemory(cpu.readSP()));
                    cpu.writeSP(cpu.readSP() + 2); //////////// 2 ile ilgilenilmesi lazım + stack boş mu dolu mu kontolü ?
                    break;
                case 0x2:
                    cpu.writeB(cpu.readMemory(cpu.readSP()));
                    cpu.writeSP(cpu.readSP() + 2); //////////// 2 ile ilgilenilmesi lazım + stack boş mu dolu mu kontolü ?
                    break;
                case 0x3:
                    cpu.writeC(cpu.readMemory(cpu.readSP()));
                    cpu.writeSP(cpu.readSP() + 2); //////////// 2 ile ilgilenilmesi lazım + stack boş mu dolu mu kontolü ?
                    break;
                case 0x4:
                    cpu.writeD(cpu.readMemory(cpu.readSP()));
                    cpu.writeSP(cpu.readSP() + 2); //////////// 2 ile ilgilenilmesi lazım + stack boş mu dolu mu kontolü ?
                    break;
                case 0x5:
                    cpu.writeE(cpu.readMemory(cpu.readSP()));
                    cpu.writeSP(cpu.readSP() + 2); //////////// 2 ile ilgilenilmesi lazım + stack boş mu dolu mu kontolü ?
                    break;
                case 0x6:
                    cpu.writeSP(cpu.readMemory(cpu.readSP()));
                    cpu.writeSP(cpu.readSP() + 2); //////////// 2 ile ilgilenilmesi lazım + stack boş mu dolu mu kontolü ?
                    break;
                default:
                    System.out.println("Invalid addressing mode and register pair");
                    System.exit(0);
            }
        } else{
            System.out.println("POP: Invalid addressing mode");
            System.exit(0);
        }
    }
}
