package com.company.InstructionSet;

import com.company.Instruction;
import com.company.MyCPU;

public class DEC extends Instruction {

    MyCPU cpu;

    public DEC(int opcode, int addressingMode, int operand, MyCPU cpu) {
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

        if(addressingMode == 0x1){
            switch (operand){
                case 0x0:
                    cpu.writePC(cpu.readPC() - 1);
                    cpu.setZF(cpu.readPC() == 0);
                    cpu.setSF(cpu.readPC() < 0);
                    ////////
                    break;
                case 0x1:
                    cpu.writeA(cpu.readA() - 1);
                    cpu.setZF(cpu.readA() == 0);
                    cpu.setSF(cpu.readA() < 0);
                    ////////
                    break;
                case 0x2:
                    cpu.writeB(cpu.readB() - 1);
                    cpu.setZF(cpu.readB() == 0);
                    cpu.setSF(cpu.readB() < 0);
                    ////////
                    break;
                case 0x3:
                    cpu.writeC(cpu.readC() - 1);
                    cpu.setZF(cpu.readC() == 0);
                    cpu.setSF(cpu.readC() < 0);
                    ////////
                    break;
                case 0x4:
                    cpu.writeD(cpu.readD() - 1);
                    cpu.setZF(cpu.readD() == 0);
                    cpu.setSF(cpu.readD() < 0);
                    ////////
                    break;
                case 0x5:
                    cpu.writeE(cpu.readE() - 1);
                    cpu.setZF(cpu.readE() == 0);
                    cpu.setSF(cpu.readE() < 0);
                    ////////
                    break;
                case 0x6:
                    cpu.writeSP(cpu.readSP() - 1);
                    cpu.setZF(cpu.readSP() == 0);
                    cpu.setSF(cpu.readSP() < 0);
                    ////////
                    break;
                default:
                    System.out.println("Invalid addressing mode and register pair");
                    System.exit(0);
            }
        } else{
            System.out.println("DEC: Invalid addressing mode");
            System.exit(0);
        }
    }
}
