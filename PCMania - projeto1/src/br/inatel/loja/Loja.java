package br.inatel.loja;

import br.inatel.computador.Computador;
import br.inatel.computador.HardwareBasico;
import br.inatel.computador.SistemaOperacional;
import br.inatel.computador.MemoriaUSB;

public class Loja {
    private static int matricula = 2142; //matricula fixa do cliente para definir o preço dos computadores

    private float preco1 = matricula;
    private float preco2 = matricula + 1234;
    private float preco3 = matricula + 5678;

    public float getPreco1() {
        return preco1;
    }

    public float getPreco2() {
        return preco2;
    }

    public float getPreco3() {
        return preco3;
    }

    private Computador[] comps = new Computador[3]; // array que armazena os computadores disponíveis

    public Loja() {
        // computador 1
        Computador comps1 = new Computador("Apple", this.getPreco1()); // criação do computador 1
        HardwareBasico hb11 = new HardwareBasico("i3", 2200); // criação dos componentes de hardware do computador 1
        HardwareBasico hb12 = new HardwareBasico("RAM", 8);
        HardwareBasico hb13 = new HardwareBasico("HD", 500);
        comps1.adicionarHardBasicos(hb11);// associação dos hardwares aos computador
        comps1.adicionarHardBasicos(hb12);
        comps1.adicionarHardBasicos(hb13);
        SistemaOperacional so1 = new SistemaOperacional("macOS Sequoia", 64); // definição do sistema operacional
        comps1.setSistop(so1);
        MemoriaUSB musb1 = new MemoriaUSB("Pen-drive", 16); // adição da memoriausb
        comps1.addMusb(musb1);
        comps[0] = comps1; // associação das configurações ao computador que ocupa posição 0 do array

        // computador 2
        Computador comps2 = new Computador("Samsung", this.getPreco2());
        HardwareBasico hb21 = new HardwareBasico("i5", 3370);
        HardwareBasico hb22 = new HardwareBasico("RAM", 16);
        HardwareBasico hb23 = new HardwareBasico("HD", 1000);
        comps2.adicionarHardBasicos(hb21);
        comps2.adicionarHardBasicos(hb22);
        comps2.adicionarHardBasicos(hb23);
        SistemaOperacional so2 = new SistemaOperacional("Windows 8", 64);
        comps2.setSistop(so2);
        MemoriaUSB musb2 = new MemoriaUSB("Pen-drive", 32);
        comps2.addMusb(musb2);
        comps[1] = comps2;

        // computador 3
        Computador comps3 = new Computador("Dell", this.getPreco3());
        HardwareBasico hb31 = new HardwareBasico("i7", 4500);
        HardwareBasico hb32 = new HardwareBasico("RAM", 32);
        HardwareBasico hb33 = new HardwareBasico("HD", 2000);
        comps3.adicionarHardBasicos(hb31);
        comps3.adicionarHardBasicos(hb32);
        comps3.adicionarHardBasicos(hb33);
        SistemaOperacional so3 = new SistemaOperacional("Windows 10", 64);
        comps3.setSistop(so3);
        MemoriaUSB musb3 = new MemoriaUSB("HD Externo", 1000);
        comps3.addMusb(musb3);
        comps[2] = comps3;
    }

    // getter que retorna os computadores disponíveis
    public Computador[] getComps() {
        return comps;
    }
}