         .globl __start
			.data 0x10000000
M: 	  		.asciiz "M="
Q: 	  		.asciiz "\nQ="
R: 	  		.asciiz "\nR="

			.text 0x00400000
__start:  	la $a0, M
			jal Input
			move $a2,$v0
	  

			la $a0, Q
			jal Input
			move $a3, $v0
			
	 		bgtz $a3, else
			add $t2, $zero, $a3
			add $t1, $zero, $a2
			sub $t1, $zero, $a2
			sub $t2, $zero, $a3
			move $a3, $t2
			move $a2, $t1
			j endif

else:		j endif

endif:	    jal Mult
			move $a1,$v0
			la $a0, R
			jal Output
			li $v0,10
			syscall

Mult:   	li $v0, 0
			beqz $a3, MultRet

MultFor: 	add $v0, $v0, $a2
			sub $a3, $a3, 1
			bne $a3, $zero, MultFor


MultRet:  	jr $ra


Input: 	  	li $v0,4
			syscall
			li $v0,5
			syscall
			jr $ra

Output:   	li $v0,4
			syscall
			move $a0, $a1
			li $v0, 1
			syscall
			jr $ra


	  

	  