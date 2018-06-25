package vsim.riscv.instructions.rtype;

import vsim.utils.Data;


public final class Fmins extends FRType {

  public Fmins() {
    super(
      "fmin.s",
      "fmin.s frd, frs1, frs2",
      "set frd = min(frs1, frs2)"
    );
  }

  @Override
  public int getFunct5() {
    return 0b00101;
  }

  @Override
  public float compute(float rs1, float rs2) {
    // if at least one input is a signaling NaN, return canonical NaN
    if (Data.signalingNaN(rs1) || Data.signalingNaN(rs2))
      return Float.NaN;
    // if both inputs are quiet nans, return canonical NaN
    else if (Data.quietNaN(rs1) && Data.quietNaN(rs2))
      return Float.NaN;
    // if one operand is a quiet NaN and the other is not a NaN, return
    // the non-NaN operand
    else if (Data.quietNaN(rs1) || Data.quietNaN(rs2)) {
      if (!Data.quietNaN(rs1))
        return rs1;
      else
        return rs2;
    }
    // return the smaller floating point number
    else
      return Math.min(rs1, rs2);
  }

}
