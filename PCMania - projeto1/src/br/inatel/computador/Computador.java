package br.inatel.computador;

public class Computador {
    private String marca;
    private float preco;
    private HardwareBasico[] hardBasicos; //array de hardwares basicos
    private SistemaOperacional sistop;
    private MemoriaUSB musb;

    // construtor da classe computador
    public Computador(String marca, float preco) {
        this.marca = marca;
        this.preco = preco;

        this.hardBasicos = new HardwareBasico[3];
    }

    public void setSistop(SistemaOperacional sistop) {
        this.sistop = sistop;
    }

    public void addMusb(MemoriaUSB musb) {
        this.musb = musb;
    }

    public void adicionarHardBasicos(HardwareBasico hb) {
        for(int i=0; i< hardBasicos.length; i++){
            if(hardBasicos[i] == null) {
                hardBasicos[i] = hb;
                break; // para o loop na hora em que a posição é preenchida
            }
        }
    }

    public String getMarca() {
        return marca;
    }

    public float getPreco() {
        return preco;
    }

    // exibe as informações do computador
    public void mostraPCConfigs(){
        System.out.println("Informações do computador da marca: " + this.getMarca());
        System.out.println("Preço: R$" + this.getPreco());
        System.out.println("Hardware básico");
        for(HardwareBasico hardwareBasico:hardBasicos){
            if(hardwareBasico != null){
                System.out.println(" -> Tipo de dispositivo: " + hardwareBasico.getNome());
                System.out.println(" -> Capacidade do dispositivo: " + hardwareBasico.getCapacidade());
            }
        }

        System.out.println("Sistema operacional");
        System.out.println(" -> Nome: " + sistop.getNome());
        System.out.println(" -> Tipo: " + sistop.getTipo());

        System.out.println("Memória USB");
        System.out.println(" -> Nome: " + musb.getNome());
        System.out.println(" -> Capacidade: " + musb.getCapacidade());

    }
}