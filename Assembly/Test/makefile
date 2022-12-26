program := Test
directory := ../Test
build_dir := $(directory)/build
source_dir := $(directory)/source

objects := test.o

build: $(objects)
	gcc $(build_dir)/test.o \
			$(source_dir)/callfactorial.c \
			-o $(build_dir)/$(program)

test.o:
	nasm -felf64 $(source_dir)/test.asm \
			-o $(build_dir)/test.o

clean:
	rm $(build_dir)/*.o
	rm $(build_dir)/Test

run:
	$(build_dir)/$(program)
