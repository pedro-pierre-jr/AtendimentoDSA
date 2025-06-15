public class ArvoreBinaria {
    private No raiz;

    public boolean estaVazia(){
        return raiz == null;
    }

    public void insere(Pessoa info){
        No novo = new No(info);
        if(estaVazia()){
            raiz = novo;
        } else {
            insereRec(novo, raiz);
        }
    }

    private void insereRec(No novo, No atual){
        if(novo.getInfo().getId() > atual.getInfo().getId()){ // direita
            if(atual.getDireita() == null){
                atual.setDireita(novo);
            } else {
                insereRec(novo, atual.getDireita());
            }
        } else { // esquerda
            if(atual.getEsquerda() == null){
                atual.setEsquerda(novo);
            } else {
                insereRec(novo, atual.getEsquerda());
            }
        }
    }

    @Override
    public String toString(){
        if(estaVazia()){
            return "Arvore vazia!";
        }
        return toStringRec(raiz);
    }

    private String toStringRec(No atual){
        if(atual == null) return "";
        String s = "";
        s += toStringRec(atual.getEsquerda());
        s += atual.getInfo() + " ";
        s += toStringRec(atual.getDireita());
        return s;
    }

    public int altura(){
        if(estaVazia() || (raiz.getEsquerda() == null && raiz.getDireita() == null)){
            return 0;
        }
        return alturaRec(raiz);
    }

    private int alturaRec(No atual){
        if(atual == null || (atual.getDireita() == null && atual.getEsquerda() == null)){
            return 0;
        }
        int alturaEsq = alturaRec(atual.getEsquerda());
        int alturaDir = alturaRec(atual.getDireita());
        return alturaDir > alturaEsq ? alturaDir+1 : alturaEsq+1;
    }

    public int contaNos(){
        if(estaVazia()){
            return 0;
        }
        return contaNosRec(raiz);
    }

    private int contaNosRec(No atual){
        if(atual == null) return 0;
        return contaNosRec(atual.getEsquerda()) + 1 + contaNosRec(atual.getDireita());
    }

    public boolean busca(int x){
        if(estaVazia()){
            return false;
        }
        return buscaRec(x, raiz);
    }

    private boolean buscaRec (int x, No atual){
        if(atual == null){
            return false;
        }
        if(atual.getInfo().getId() == x) return true;
        if(x > atual.getInfo().getId()) return buscaRec(x, atual.getDireita());
        return buscaRec(x, atual.getEsquerda());
    }

    public int maior(){
        if(estaVazia()) throw new RuntimeException("Arvore Vazia");
        No atual = raiz;
        while(atual.getDireita() != null){
            atual = atual.getDireita();
        }
        return atual.getInfo().getId();
    }

    //chama rec pra encontrar pessoa na base de atendimento
    public boolean foiAtendida(String nome) {
        return buscaNomeRec(nome, raiz);
    }

    private boolean buscaNomeRec(String nome, No atual){
        if(atual == null) return false;
        if(atual.getInfo().getNome().equalsIgnoreCase(nome)) return true;
        return buscaNomeRec(nome, atual.getEsquerda()) || buscaNomeRec(nome, atual.getDireita());
    }

    public void imprimirEmOrdem() {
        if (estaVazia()) {
            System.out.println("Não foi encontrado nenhum atendimento");
        } else {
            imprimirRec(raiz);
        }
    }

    private void imprimirRec(No atual) {
        if (atual != null) {
            imprimirRec(atual.getEsquerda());
            System.out.println(atual.getInfo());
            imprimirRec(atual.getDireita());
        }
    }
}
