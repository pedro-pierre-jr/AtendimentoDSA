public class NoFila {
    private Pessoa info;
    private NoFila proximo;

    public NoFila (Pessoa info){
        this.info = info;
        this.proximo = null;
    }
    public Pessoa getInfo(){
        return info;
    }
    public void setInfo(Pessoa info){
        this.info = info;
    }
    public NoFila getProximo(){
        return proximo;
    }
    public void setProximo(NoFila proximo){
        this.proximo = proximo;
    }
    @Override
    public String toString(){
        return "[" + info + "]";
    }
}
