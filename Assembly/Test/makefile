program := Test
directory := ../Test
build_dir := $(directory)/build
source_dir := $(directory)/source

objects := test.o

build: $(objects)
	ld $(build_dir)/test.o \
			-o $(build_dir)/$(program)

test.o:
	nasm -f elf64 $(source_dir)/test.asm \
			-o $(build_dir)/test.o

clean:
	rm $(build_dir)/*.o
	rm $(build_dir)/Test

run:
	$(build_dir)/$(program)
