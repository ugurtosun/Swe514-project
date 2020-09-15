package com.company.InstructionSet;

import com.company.Instruction;
import com.company.MyCPU;

public class STORE extends Instruction {

    MyCPU cpu;

    public STORE(int opcode, int addressingMode, int operand, MyCPU cpu) {
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
            System.out.println("Invalid addressing mode for STORE instruction");
        }
        else if(addressingMode == 0x1){
            switch (operand){
                case 0x0:
                    cpu.writePC(cpu.readA());
                    break;
                case 0x1:
                    cpu.writeA(cpu.readA());
                    break;
                case 0x2:
                    cpu.writeB(cpu.readA());
                    break;
                case 0x3:
                    cpu.writeC(cpu.readA());
                    break;
                case 0x4:
                    cpu.writeD(cpu.readA());
                    break;
                case 0x5:
                    cpu.writeE(cpu.readA());
                    break;
                case 0x6:
                    cpu.writeSP(cpu.readA());
                    break;
                default:
                    System.out.println("Invalid addressing mode and register pair");
                    System.exit(0);
            }
        } else if(addressingMode == 0x2){
            switch (operand){
                case 0x0:
                    cpu.writeMemory(cpu.readPC(), cpu.readA());
                    break;
                case 0x1:
                    cpu.writeMemory(cpu.readA(), cpu.readA());
                    break;
                case 0x2:
                    cpu.writeMemory(cpu.readB(), cpu.readA());
                    break;
                case 0x3:
                    cpu.writeMemory(cpu.readC(), cpu.readA());
                    break;
                case 0x4:
                    cpu.writeMemory(cpu.readD(), cpu.readA());
                    break;
                case 0x5:
                    cpu.writeMemory(cpu.readE(), cpu.readA());
                    break;
                case 0x6:
                    cpu.writeMemory(cpu.readSP(), cpu.readA());
                    break;
                default:
                    System.out.println("Invalid addressing mode and register pair");
                    System.exit(0);
            }
        }else if(addressingMode == 0x3){
            cpu.writeMemory(operand, cpu.readA());
        }else{
            System.out.println("STORE: Invalid addressing mode");
            System.exit(0);
        }
    }
}
