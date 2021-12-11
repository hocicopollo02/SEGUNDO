				.globl __start
		
				.text 0x00400000
		
__start: 		li $v0, 5
				syscall
				move $t1, $v0		#lee el caracter ASCII
				
				
				li $a0, 22
				li $v0, 11
				syscall				#imprime las primeras comillas
				
				li $t2, 10
				li $t3, 0
				
				
				bne $t1, $t2, caso10

caso0: 			li $a0, 92			# el caracter \
				li $v0, 11
				syscall
			
				li $a0, 48
				li $v0, 11
				syscall				# el elemento 0
				j fin

caso10:			bne $t1, $t3 ,default
				li $a0, 92			# el caracter \
				li $v0, 11
				syscall
				
				li $a0, 110
				li $v0, 11
				syscall				# el elemento n
				j fin

default:		move $a0, $t1
				li $v0, 11
				syscall
				j fin

fin: 			li $a0, 22
				li $v0, 11
				syscall
				
				