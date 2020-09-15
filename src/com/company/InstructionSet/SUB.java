package com.company.InstructionSet;

import com.company.Instruction;
import com.company.MyCPU;

public class SUB extends Instruction {

    MyCPU cpu;

    public SUB(int opcode, int addressingMode, int operand, MyCPU cpu) {
        this.opcode = opcode;
        this.operand = operand;
        this.addressingMode = addressingMode;
        this.hasEffectOnCF = true;
        this.hasEffectOnSF = true;
        this.hasEffectOnZF = true;
        this.cpu = cpu;
        operate();
        updateFlags();
    }

    private void operate(){

        cpu.readA();

        if(addressingMode == 0x0){
            cpu.writeA(cpu.readA() - operand);
        }
        else if(addressingMode == 0x1){
            switch (operand){
                case 0x0:
                    cpu.writeA(cpu.readA() - cpu.readPC());
                    break;
                case 0x1:
                    cpu.writeA(cpu.readA() - cpu.readA());
                    break;
                case 0x2:
                    cpu.writeA(cpu.readA() - cpu.readB());
                    break;
                case 0x3:
                    cpu.writeA(cpu.readA() - cpu.readC());
                    break;
                case 0x4:
                    cpu.writeA(cpu.readA() - cpu.readD());
                    break;
                case 0x5:
                    cpu.writeA(cpu.readA() - cpu.readE());
                    break;
                case 0x6:
                    cpu.writeA(cpu.readA() - cpu.readSP());
                    break;
                default:
                    System.out.println("Invalid addressing mode and register pair");
                    System.exit(0);
            }
        } else if(addressingMode == 0x2){
            switch (operand){
                case 0x0:
                    cpu.writeA(cpu.readA() - cpu.readMemory(cpu.readPC()));
                    break;
                case 0x1:
                    cpu.writeA(cpu.readA() - cpu.readMemory(cpu.readA()));
                    break;
                case 0x2:
                    cpu.writeA(cpu.readA() - cpu.readMemory(cpu.readB()));
                    break;
                case 0x3:
                    cpu.writeA(cpu.readA() - cpu.readMemory(cpu.readC()));
                    break;
                case 0x4:
                    cpu.writeA(cpu.readA() - cpu.readMemory(cpu.readD()));
                    break;
                case 0x5:
                    cpu.writeA(cpu.readA() - cpu.readMemory(cpu.readE()));
                    break;
                case 0x6:
                    cpu.writeA(cpu.readA() - cpu.readMemory(cpu.readSP()));
                    break;
                default:
                    System.out.println("Invalid addressing mode and register pair");
                    System.exit(0);
            }
        }else if(addressingMode == 0x3){
            cpu.writeA(cpu.readA() - cpu.readMemory(operand));
        }else{
            System.out.println("SUB: Invalid addressing mode");
            System.exit(0);
        }
    }

    private void updateFlags(){
        cpu.setZF(cpu.readA() == 0);
        cpu.setSF(cpu.readA() < 0);
        cpu.setCF(cpu.readA() < 0);
    }
}
