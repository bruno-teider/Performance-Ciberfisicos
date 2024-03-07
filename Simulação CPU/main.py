import sys
from MemoriaCache import MemoriaCache

CPU_DEBUG = True
flag_zero = False

registrador_cp = 0x00
registrador_ax = 0x00
registrador_bx = 0x00
registrador_cx = 0x00
registrador_dx = 0x00

# Lista para armazenar os valores de dentro de cada registrador
listaRegistradores = [0, 0, 0, 0, 0]

def conversaoPrint(valor1):
    match valor1-2:
        case 0: var_print = "AX"
        case 1: var_print = "BX"
        case 2: var_print = "CX"
        case 3: var_print = "DX"
    return var_print

def selecionarArquivo():
    print("Escolha qual arquivo de memória deseja utilizar: ")
    print("1 - mov_mov_add.bin \n2 - inc_dec.bin \n3 - todas_instrucoes.bin \n4 - programa_simples.bin \n5 - fibonacci_10.bin")
    op = int(input("Opcão escolhida: "))
    match op:
        case 1: memoria = MemoriaCache('arquivos_memoria/mov_mov_add.bin')
        case 2: memoria = MemoriaCache('arquivos_memoria/inc_dec.bin')
        case 3: memoria = MemoriaCache('arquivos_memoria/todas_instrucoes.bin')
        case 4: memoria = MemoriaCache('arquivos_memoria/programa_simples.bin')
        case 5: memoria = MemoriaCache('arquivos_memoria/fibonacci_10.bin')
        case _: print("Valor Inválido")

    return memoria

def buscarEDecodificarInstrucao():
    match memoria.getValorMemoria(registrador_cp):
        case 0x00:
            idInstrucao = 0
            terminal = "buscarEDecodificar: instrução ADD Registrador e Byte"
        case 0x01:
            idInstrucao = 1
            terminal = "buscarEDecodificar: instrução ADD Registrador e Registrador"
        case 0x10:
            idInstrucao = 2
            terminal = "buscarEDecodificar: instrução INC Registrador"
        case 0x20:
            idInstrucao = 3
            terminal = "buscarEDecodificar: instrução DEC Registrador"
        case 0x30:
            idInstrucao = 4
            terminal = "buscarEDecodificar: instrução SUB Registrador e Byte"
        case 0x31:
            idInstrucao = 5
            terminal = "buscarEDecodificar: instrução SUB Registrador e Registrador"
        case 0x40:
            idInstrucao = 6
            terminal = "buscarEDecodificar: instrução MOV Registrador e Byte"
        case 0x41:
            idInstrucao = 7
            terminal = "buscarEDecodificar: instrução MOV Registrador e Registrador"
        case 0x50:
            idInstrucao = 8
            terminal = "buscarEDecodificar: instrução JMP Byte"
        case 0x60:
            idInstrucao = 9
            terminal = "buscarEDecodificar: instrução CMP Registrador e Byte"
        case 0x61:
            idInstrucao = 10
            terminal = "buscarEDecodificar: instrução CMP Registrador e Registrador"
        case 0x70:
            idInstrucao = 11
            terminal = "buscarEDecodificar: instrução JZ Byte"
        
    if CPU_DEBUG == True: print(terminal)
    return idInstrucao

def lerOperadoresExecutarInstrucao(idInstrucao):
    global registrador_cp, registrador_ax, registrador_bx, registrador_cx, registrador_dx, flag_zero, listaRegistradores

    registrador_cp += 1
    valor1 = memoria.getValorMemoria(registrador_cp)

    # Checagem número de operadores da instrução 
    if (idInstrucao in [2, 3, 8, 11]):
        match idInstrucao:
            case 2: # INC Reg
                listaRegistradores[valor1-1] += 1
                terminal = f"lerOperadoresExecutarInstrucao: incrementando em {conversaoPrint(valor1)}"
            case 3: # DEC Reg
                listaRegistradores[valor1-1] -= 1
                terminal = f"lerOperadoresExecutarInstrucao: decrementando em {conversaoPrint(valor1)}"
            case 8: # JMP Byte (sem print)
                registrador_cp = valor1-1
                return None
            case 11: # ZF Byte (sem print)
                if flag_zero == True: registrador_cp = valor1-1
                return None
    else:
        registrador_cp += 1
        valor2 = memoria.getValorMemoria(registrador_cp)
        match idInstrucao:
            case 0: # Add Reg Byte
                listaRegistradores[valor1-1] += valor2
                terminal = f"lerOperadoresExecutarInstrucao: somando {hex(valor2)} em {conversaoPrint(valor1)}"
            case 1: # Add Reg Reg
                listaRegistradores[valor1-1] += listaRegistradores[valor2-1]
                terminal = f"lerOperadoresExecutarInstrucao: somando valor de {conversaoPrint(valor2)} em {conversaoPrint(valor1)}"
            case 4: # Sub Reg Byte
                listaRegistradores[valor1-1] -= valor2
                terminal = f"lerOperadoresExecutarInstrucao: subtraindo {hex(valor2)} em {conversaoPrint(valor1)}"
            case 5: # Sub Reg Reg
                listaRegistradores[valor1-1] -= listaRegistradores[valor2-1]
                terminal = f"lerOperadoresExecutarInstrucao: subtraindo valor de {conversaoPrint(valor2)} em {conversaoPrint(valor1)}"
            case 6: # Mov Reg Byte
                listaRegistradores[valor1-1] = valor2
                terminal = f"lerOperadoresExecutarInstrucao: atribuindo {hex(valor2)} em {conversaoPrint(valor1)}"
            case 7: # Mov Reg Reg
                listaRegistradores[valor1-1] = listaRegistradores[valor2-1]
                terminal = f"lerOperadoresExecutarInstrucao: atribuindo valor de {conversaoPrint(valor2)} em {conversaoPrint(valor1)}"
            case 9: # Cmp Reg Byte
                if(listaRegistradores[valor1-1] == valor2): flag_zero = True
                terminal = f"lerOperadoresExecutarInstrucao: comparando valor {valor2} com {conversaoPrint(valor1)}"
            case 10: # Cmp Reg Reg
                if(listaRegistradores[valor1-1] == listaRegistradores[valor2-1]): flag_zero = True
                terminal = f"lerOperadoresExecutarInstrucao: comparando {conversaoPrint(valor2)} com {conversaoPrint(valor1)}"

    if CPU_DEBUG == True: print(terminal)

    # Aplica valores da lista nos registradores
    registrador_ax = listaRegistradores[1]
    registrador_bx = listaRegistradores[2]
    registrador_cx = listaRegistradores[3]
    registrador_dx = listaRegistradores[4]

def calcularProximaInstrucao(idInstrucao):    
    global registrador_cp

    registrador_cp += 1
    if CPU_DEBUG == True: print(f"calcularProximaInstrucao: mudando CP para {registrador_cp}")

    return registrador_cp

def dumpRegistradores():
    if CPU_DEBUG:
        print(f'\nCP[{registrador_cp:02X}]\n\
AX[{registrador_ax:02X}]\n\
BX[{registrador_bx:02X}]\n\
CX[{registrador_cx:02X}]\n\
DX[{registrador_dx:02X}]\n\
ZF[{flag_zero}] ')


if __name__ == '__main__':
    memoria = selecionarArquivo()
    while (True):
        idInstrucao = buscarEDecodificarInstrucao()
        lerOperadoresExecutarInstrucao(idInstrucao)
        calcularProximaInstrucao(idInstrucao)
        dumpRegistradores() 

        # O usuário precisa apertar enter para rodar próximo loop
        sys.stdin.read(1) 