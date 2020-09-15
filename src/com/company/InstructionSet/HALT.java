package com.company.InstructionSet;

import com.company.Instruction;
import com.company.MyCPU;

public class HALT extends Instruction {

    public HALT(int opcode, int addressingMode, int operand, MyCPU mycpu) {
       this.opcode = opcode;
       this.operand = operand;
       this.addressingMode = addressingMode;
       this.hasEffectOnCF = false;
       this.hasEffectOnSF = false;
       this.hasEffectOnZF = false;
       operate();
    }

    private void operate(){

        System.out.println("End Of Program: CPU is halting..");
        System.exit(0);

    }
}
