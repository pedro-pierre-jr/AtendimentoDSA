public class Fila {
    private NoFila primeiro;
    private NoFila ultimo;

    public boolean filaVazia() {
        return primeiro == null;
    }

    public void enfileirar(Pessoa p) {
        NoFila novo = new NoFila(p);
        if (filaVazia()) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.setProximo(novo);
            ultimo = novo;
        }
    }

    public Pessoa desenfileirar() {
        if (filaVazia()) {
            return null;
        }
        Pessoa p = primeiro.getInfo();
        primeiro = primeiro.getProximo();
        if (primeiro == null) {
            ultimo = null;
        }
        return p;
    }

    public void imprimirFila() {
        if (filaVazia()) {
            System.out.println("Fila vazia");
        } else {
            NoFila atual = primeiro;
            while (atual != null) {
                System.out.println(atual.getInfo());
                atual = atual.getProximo();
            }
        }
    }

    public int buscarPosicao(String nome) {
        NoFila atual = primeiro;
        int posicao = 1;

        while (atual != null) {
            if (atual.getInfo().getNome().equalsIgnoreCase(nome)) {
                return posicao;
            }
            atual = atual.getProximo();
            posicao++;
        }

        return -1; // não encontrado
    }


    @Override
    public String toString(){
        if(filaVazia()) return "Fila Vazia!\n";
        NoFila atual = primeiro;
        String s = "";
        while(atual != null){
            s += atual; // chama o toString do NoFila
            atual = atual.getProximo();
        }
        return s + "\n";
 
    }
}