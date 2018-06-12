package vsim;

import vsim.riscv.Memory;
import vsim.riscv.RegisterFile;
import vsim.riscv.InstructionSet;
import vsim.assembler.SymbolTable;


public final class Globals {

  // RAM
  public static final Memory memory = Memory.ram;

  // RV register file
  public static final RegisterFile regfile = RegisterFile.regfile;

  // RV instruction set
  public static final InstructionSet iset = InstructionSet.insts;

  // reset state
  public static void resetState() {
    // reset memory
    Globals.memory.reset();
    // reset registers
    Globals.regfile.reset();
  }

}