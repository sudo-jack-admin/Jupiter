.globl main

.text

main:
  li x1, 0x80000000
  li x2, 0xffff8000
  sub x30, x1, x2
  li x29, 0x80008000
  bne x30, x29, fail

sucess:
  li a0, 10
  ecall

fail:
  li a0, 17
  li a1, 1
  ecall