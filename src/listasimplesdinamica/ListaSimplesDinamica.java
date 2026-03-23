package listasimplesdinamica;

public class ListaSimplesDinamica {

    private No inicio;

    public ListaSimplesDinamica(){
        this.inicio = null;
    }

    public boolean listaVazia(){
        return (this.inicio == null);
    }

    private int tamanho() {
        int cont = 0;
        No temp = this.inicio;
        while (temp != null) {
            cont++;
            temp = temp.getProx();
        }
        return cont;
    }

    private void insereListaVazia(double valor){
        No aux = new No(valor);
        aux.setProx(null);
        this.inicio = aux;
    }

    private void insereFimLista(double valor){
        No aux = new No(valor);

        No temp = this.inicio;
        while(temp.getProx() != null){
            temp = temp.getProx();
        }

        aux.setProx(null);
        temp.setProx(aux);
    }

    private void insereMeioLista(double valor, int pos){
        No aux = new No(valor);
        int i = 1;

        No temp = this.inicio;
        while(i < pos){
            temp = temp.getProx();
            i++;
        }
        aux.setProx(temp.getProx());
        temp.setProx(aux);
    }

    private void insereInicioLista(double valor){
        No aux = new No(valor);
        aux.setProx(this.inicio);
        this.inicio = aux;
    }

    public boolean insere(double valor) {
        if (listaVazia()) {
            insereListaVazia(valor);
            return true;
        }
        insereFimLista(valor);
        return true;
    }


    public boolean insere(double valor, int pos) {
        int tam = tamanho();

        if (pos < 0 || pos > tam) {
            return false;
        }

        if (listaVazia()) {

            if (pos == 0) {
                insereListaVazia(valor);
                return true;
            }
            return false;
        }

        if (pos == 0) {
            insereInicioLista(valor);
            return true;
        }

        if (pos == tam) {
            insereFimLista(valor);
            return true;
        }


        insereMeioLista(valor, pos);
        return true;
    }

    public void printLista(){
        No temp = this.inicio;
        while(temp != null){
            System.out.println(temp.getValor());
            temp = temp.getProx();
        }
    }

   //atividade de remoção (03/03/2026
    public boolean removeInicio() {
        if (listaVazia()) return false;
        this.inicio = this.inicio.getProx();
        return true;
    }

    public boolean removeFim() {
        if (listaVazia()) return false;

      
        if (this.inicio.getProx() == null) {
            this.inicio = null;
            return true;
        }

        No temp = this.inicio;
        while (temp.getProx().getProx() != null) {
            temp = temp.getProx();
        }
        temp.setProx(null);
        return true;
    }

    public boolean removePos(int pos) {
        int tam = tamanho();
        if (pos < 0 || pos >= tam) return false;
        if (pos == 0) return removeInicio();

        No anterior = this.inicio;
        int i = 0;
        while (i < pos - 1) {
            anterior = anterior.getProx();
            i++;
        }

        No removido = anterior.getProx();
        anterior.setProx(removido.getProx());
        return true;
    }

    public boolean removeValor(double valor) {
        if (listaVazia()) return false;


        if (this.inicio.getValor() == valor) {
            return removeInicio();
        }

        No anterior = this.inicio;
        No atual = this.inicio.getProx();

        while (atual != null) {
            if (atual.getValor() == valor) {
                anterior.setProx(atual.getProx());
                return true;
            }
            anterior = atual;
            atual = atual.getProx();
        }

        return false;
    }
}




 