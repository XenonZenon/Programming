section .data
  text db "What is your name?", 10
  text2 db "Name: ", 10

section .bss
  name resb 16

section .text
  global _start

_start:

  call _printquestion
  call _getname
  call _printtext2
  call _printname

  mov rax, 60
  mov rdi, 0
  syscall

_printquestion:
  mov rax, 1
  mov rdi,1
  mov rsi, text
  mov rdx, 19
  syscall
  ret

_getname:
  mov rax, 0
  mov rdi, 0
  mov rsi, name
  mov rdx, 16
  syscall
  ret

_printtext2:
  mov rax, 1
  mov rdi, 1
  mov rsi, text2
  mov rdx, 6
  syscall
  ret

_printname:
  mov rax, 1
  mov rdi, 1
  mov rsi, name
  mov rdx, 16
  syscall
  ret
