
                ##########################################################
                # Segmento de datos
                ##########################################################

                .data 0x10000000
reloj:          .word 0                # HH:MM:SS (3 bytes de menor peso)

cad_asteriscos: .asciiz "\n  **************************************"
cad_horas:      .asciiz "\n   Horas: "
cad_minutos:    .asciiz " Minutos: "
cad_segundos:   .asciiz " Segundos: "
cad_reloj_en_s: .asciiz "\n   Reloj en segundos: "
error_f:	.asciiz "ERROR: formato incorrecto."

                ##########################################################
                # Segmento de código
                ##########################################################

                .globl __start
                .text 0x00400000

__start:        la $a0, reloj
		li $a1, 0x0002030C
		jal inicializa_reloj
		la $a0, reloj
		jal imprime_reloj
             
salir:          li $v0, 10              # Código de exit (10)
                syscall                 # Última instrucción ejecutada
                .end

inicializar_alt:	li $t0, 3
			and $t1, $t0, $a1
			bne $t1, $a1, error_f
			li $t0, 3
			and $t2, $t0, $a2
			bne $t2, $a2, error_f
			and $t3, $t0, $a3
			bne $t3, $a3, error_f
				
			sb $a1, 2($a0)
			sb $a2, 1($a0)
			sb $a3, 0($a0)
			jr $ra


inicializar_hh:		sb $a1, 2($a0)
			jr $ra

inicializar_mm:		sb $a1, 1($a0)
			jr $ra

inicializar_ss:		sb $a1, 0($a0)
			jr $ra

devuelve_reloj_en_s:
			li $t0, 60		# Carga el multiplicador de 60.	
			lb $a1, 2($a0)		# Lee las horas y las guarda en a1. 
			mult $t0, $a1
			mflo $v0
			mult $v0, $t0
			mflo $v0
			lb $a2, 1($a0)
			mult $a2, $t0
			mflo $t1
			add $v0, $v0, $t1
			lb $a3, 0($a0)
			add $v0, $a3, $v0
			jr $ra


devuelve_reloj_en_s_sd:
				lb $t0, 2($a0)			# Carga las horas en el registro $t0.
				sll $t1, $t0, 11
				sll $t2, $t0, 10
				sll $t3, $t0, 9
				sll $t4, $t0, 4
				addu $t1, $t1, $t2
				addu $t1, $t1, $t3
				addu $t1, $t1, $t4
				addu $v0, $zero, $t1
				
				lb $t0, 1($a0)			# Carga los minutos en el registro $t0.
				sll $t1, $t0, 5
				sll $t2, $t0, 4
				sll $t3, $t0, 3
				sll $t4, $t0, 2
				addu $t1, $t1, $t2
				addu $t1, $t1, $t3
				addu $t1, $t1, $t4
				addu $v0, $v0, $t1

				lb $t0, 0($a0)			# Carga los segundos en el registro $t0.
				addu $v0, $t0, $v0
				jr $ra


devuelve_reloj_en_s_srd:
				lb $t0, 2($a0)			# Carga las horas en el registro $t0.
				sll $t1, $t0, 12
				sll $t2, $t0, 9
				sll $t3, $t0, 5
				sll $t4, $t0, 4
				subu $t1, $t1, $t2
				addu $t1, $t1, $t3
				subu $t1, $t1, $t4
				addu $v0, $zero, $t1
				
				lb $t0, 1($a0)			# Carga los minutos en el registro $t0.
				sll $t1, $t0, 6
				sll $t2, $t0, 2
				subu $t1, $t1, $t2
				addu $v0, $v0, $t1

				lb $t0, 0($a0)			# Carga los segundos en el registro $t0.
				addu $v0, $t0, $v0
				jr $ra
                ########################################################## 

                ########################################################## 
                # Subrutina que imprime el valor del reloj
                # Entrada: $a0 con la dirección de la variable reloj
                ########################################################## 

imprime_reloj:  move $t0, $a0
                la $a0, cad_asteriscos  # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall

                la $a0, cad_horas       # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall

                lbu $a0, 2($t0)         # Lee el campo HH
                li $v0, 1               # Código de print_int
                syscall

                la $a0, cad_minutos     # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall

                lbu $a0, 1($t0)         # Lee el campo MM
                li $v0, 1               # Código de print_int
                syscall

                la $a0, cad_segundos    # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall

                lbu $a0, 0($t0)         # Lee el campo SS
                li $v0, 1               # Código de print_int
                syscall

                la $a0, cad_asteriscos  # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall
                jr $ra

                ########################################################## 
                # Subrutina que imprime los segundos calculados
                # Entrada: $a0 con los segundos a imprimir
                ########################################################## 

imprime_s:      move $t0, $a0
                la $a0, cad_asteriscos  # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall


                la $a0, cad_reloj_en_s  # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall

                move $a0, $t0           # Valor entero a imprimir
                li $v0, 1               # Código de print_int
                syscall

                la $a0, cad_asteriscos  # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall
                jr $ra
                
                ########################################################## 
                # Subrutina que incrementa el reloj en una hora
                # Entrada: $a0 con la dirección del reloj
                # Salida: reloj incrementado en memoria
                # Nota: 23:MM:SS -> 00:MM:SS
                ########################################################## 
                
pasa_hora:      lbu $t0, 2($a0)         # $t0 = HH
                addiu $t0, $t0, 1       # $t0 = HH++
                li $t1, 24
                beq $t0, $t1, H24       # Si HH==24 se pone HH a cero
                sb $t0, 2($a0)          # Escribe HH++
                j fin_pasa_hora

H24:            sb $zero, 2($a0)        # Escribe HH a 0
fin_pasa_hora:  jr $ra


pasa_segundo:	lbu $t0, 0($a0)			# Carga los segundos

				addiu $t0, $t0, 1		# $t0 ++
				li $t1, 60				# Limite de segundos
				beq $t0, $t1, c_sec		# segundos == 60? YES --> salta a c_sec
				jr $ra

c_sec:			sb $zero, 0($a0)		# Vuelve a poner los segundos a cero
				j pasa_minutos			# Ahora llama a la func que incrementa en un minuto
				

pasa_minutos:	lbu $t0, 1($a0)			# Carga los minutos

				addiu $t0, $t0, 1		# $t0 ++
				li $t1, 60				# Limite de minutos
				beq $t0, $t1, c_min		# minutos == 60? YES --> salta a c_min
				jr $ra

c_min:			sb $zero, 1($a0)		# Vuelve a poner los minutos a cero
				j pasa_hora				# Ahora llama a la func que incrementa en una hora.
				

inicializa_reloj: 	li $t0, 0x001f3f3f
			and $a2, $a1, $t0	 	#Máscara de bits para comprobar el formato.
			bne $a2, $a1, error_init	#Si el formato no es correcto sale del programa.
			sw $a1, 0($a0)
			jr $ra
					
error_init:		la $a0, error_f
			li $v0, 4
			syscall
			j salir


