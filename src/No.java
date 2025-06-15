public class No{
    private Pessoa info;
    private No esquerda;
    private No direita;

    public No (Pessoa info){
        this.info = info;
    }
    public Pessoa getInfo() {
        return info;
    }
    public void setInfo(Pessoa info) {
        this.info = info;
    }
    public No getEsquerda() {
        return esquerda;
    }
    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }
    public No getDireita() {
        return direita;
    }
    public void setDireita(No direita) {
        this.direita = direita;
    }

    @Override
    public String toString(){
        return "[" + info + "]";
    }
}