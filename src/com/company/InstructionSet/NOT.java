package com.company.InstructionSet;

import com.company.Instruction;
import com.company.MyCPU;

public class NOT extends Instruction {

    MyCPU cpu;

    public NOT (int opcode, int addressingMode, int operand, MyCPU cpu) {
        this.opcode = opcode;
        this.operand = operand;
        this.addressingMode = addressingMode;
        this.hasEffectOnCF = false;
        this.hasEffectOnSF = true;
        this.hasEffectOnZF = true;
        this.cpu = cpu;
        operate();
    }

    private void operate(){

         if(addressingMode == 0x1){
            switch (operand){
                case 0x0:
                    cpu.writePC(~cpu.readPC());
                    cpu.setZF(cpu.readPC() == 0);
                    cpu.setSF(cpu.readPC() < 0);
                    break;
                case 0x1:
                    cpu.writeA(~cpu.readA());
                    cpu.setZF(cpu.readA() == 0);
                    cpu.setSF(cpu.readA() < 0);
                    break;
                case 0x2:
                    cpu.writeB(~cpu.readB());
                    cpu.setZF(cpu.readB() == 0);
                    cpu.setSF(cpu.readB() < 0);
                    break;
                case 0x3:
                    cpu.writeC(~cpu.readC());
                    cpu.setZF(cpu.readC() == 0);
                    cpu.setSF(cpu.readC() < 0);
                    break;
                case 0x4:
                    cpu.writeD(~cpu.readD());
                    cpu.setZF(cpu.readD() == 0);
                    cpu.setSF(cpu.readD() < 0);
                    break;
                case 0x5:
                    cpu.writeE(~cpu.readE());
                    cpu.setZF(cpu.readE() == 0);
                    cpu.setSF(cpu.readE() < 0);
                    break;
                case 0x6:
                    cpu.writeSP(~cpu.readSP());
                    cpu.setZF(cpu.readSP() == 0);
                    cpu.setSF(cpu.readSP() < 0);
                    break;
                default:
                    System.out.println("Invalid addressing mode and register pair");
                    System.exit(0);
            }
        } else if(addressingMode == 0x2){
            switch (operand){
                case 0x0:
                    cpu.writeMemory(cpu.readPC(), ~cpu.readMemory(cpu.readPC()));
                    cpu.setZF(cpu.readMemory(cpu.readPC()) == 0);
                    cpu.setSF(cpu.readMemory(cpu.readPC()) < 0);
                    break;
                case 0x1:
                    cpu.writeMemory(cpu.readA(), ~cpu.readMemory(cpu.readA()));
                    cpu.setZF(cpu.readMemory(cpu.readA()) == 0);
                    cpu.setSF(cpu.readMemory(cpu.readA()) < 0);
                    break;
                case 0x2:
                    cpu.writeMemory(cpu.readB(), ~cpu.readMemory(cpu.readB()));
                    cpu.setZF(cpu.readMemory(cpu.readB()) == 0);
                    cpu.setSF(cpu.readMemory(cpu.readB()) < 0);
                    break;
                case 0x3:
                    cpu.writeMemory(cpu.readC(), ~cpu.readMemory(cpu.readC()));
                    cpu.setZF(cpu.readMemory(cpu.readC()) == 0);
                    cpu.setSF(cpu.readMemory(cpu.readC()) < 0);
                    break;
                case 0x4:
                    cpu.writeMemory(cpu.readD(), ~cpu.readMemory(cpu.readD()));
                    cpu.setZF(cpu.readMemory(cpu.readD()) == 0);
                    cpu.setSF(cpu.readMemory(cpu.readD()) < 0);
                    break;
                case 0x5:
                    cpu.writeMemory(cpu.readE(), ~cpu.readMemory(cpu.readE()));
                    cpu.setZF(cpu.readMemory(cpu.readE()) == 0);
                    cpu.setSF(cpu.readMemory(cpu.readE()) < 0);
                    break;
                case 0x6:
                    cpu.writeMemory(cpu.readSP(), ~cpu.readMemory(cpu.readSP()));
                    cpu.setZF(cpu.readMemory(cpu.readSP()) == 0);
                    cpu.setSF(cpu.readMemory(cpu.readSP()) < 0);
                    break;
                default:
                    System.out.println("Invalid addressing mode and register pair");
                    System.exit(0);
            }
        }else if(addressingMode == 0x3){
             cpu.writeMemory(operand, ~cpu.readMemory(operand));
             cpu.setZF(cpu.readMemory(operand) == 0);
             cpu.setSF(cpu.readMemory(operand) < 0);
        }else{
            System.out.println("NOT: Invalid addressing mode");
            System.exit(0);
        }
    }
}
