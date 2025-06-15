public class Fila {
    private NoFila primeiro;
    private NoFila ultimo;

    public boolean filaVazia(){
        return primeiro == null;
    }

    public void enfileira(Pessoa info){
        NoFila novo = new NoFila(info);
        if(filaVazia()){
            primeiro = novo;
        }
        else{
            ultimo.setProximo(novo);
        }
        ultimo = novo;
    }

    public Pessoa desenfileira(){
        if(filaVazia()) return null;
        Pessoa temp = primeiro.getInfo();
        primeiro = primeiro.getProximo();
        if(primeiro == null)
            ultimo = null;
        return temp;
    }
    
    @Override
    public String toString(){
        if(filaVazia()) return "Fila Vazia!\n";
        NoFila atual = primeiro;
        String s = "";
        while(atual != null){
            s += atual;
            atual = atual.getProximo();
        }
        return s + "\n";
    }
}