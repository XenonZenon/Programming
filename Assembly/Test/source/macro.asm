section .data
  digit db 0, 10

section .text
  global _start

%macro exit 0
  mov rax, 60
  mov rdi, 0
  syscall
%endmacro

%macro printdigit 1
  mov rax, %1
  call _printRAXDigit
%endmacro

%macro printdigitsum2 2
  mov rax, %1
  add rax, %2
  call _printRAXDigit
%endmacro

%macro printdigitsum3 3
  mov rax, %1
  add rax, %2
  add rax, %3
  call _printRAXDigit
%endmacro

%macro freeze 0
  %%loop:
    jmp %%loop
%endmacro

_start:
  printdigit 3
  printdigit 4

  printdigitsum2 3, 2
  printdigitsum3 3, 2, 1

  freeze
  freeze

  exit

_printRAXDigit:
  add rax, 48
  mov [digit], al
  mov rax, 1
  mov rdi, 1
  mov rsi, digit
  mov rdx, 2
  syscall
  ret
