program := oop
projdir := ..\ObjectOrientedProgramming
build := $(projdir)\build
source := $(projdir)\source

objects := main.o

build: $(objects)
	g++ -s $(build)/main.o -o $(build)/$(program)

main.o:
	g++ -c $(source)/main.cpp -o $(build)/main.o

test:
	$(build)/oop.exe

clean:
	del $(build)\*.exe
	del $(build)\*.o
