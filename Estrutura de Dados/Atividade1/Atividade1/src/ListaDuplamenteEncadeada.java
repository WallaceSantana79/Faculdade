public class ListaDuplamenteEncadeada<T> {

    private Celula inicio, fim, anterior, proxima, elemento;
    private int totalDeElementos, tam;
    private T[] elementos;

    public ListaDuplamenteEncadeada() {
        this.inicio = null;
        this.fim = null;
        this.totalDeElementos = 0;
        this.tam = 0;
        this.elementos = (T[]) new Object [tam];
    }
    
    public ListaDuplamenteEncadeada(T elemento){
        this.inicio = null;
        this.fim = null;
        this.totalDeElementos = 0;
        this.tam = tam;
        this.elementos = (T[]) new Object[tam];
        this.adicionaNoComeco(elemento);
        this.adicionaNoFim(elemento);
    
    }

    public void adicionaNoComeco(T elemento) {
        if (this.totalDeElementos == 0){
            Celula nova = new Celula(elemento);
            this.fim = this.inicio = nova;
            this.inicio.setAnterior(null);
            this.fim.setProximo(null);
        }else {
            Celula nova = new Celula (elemento);
            this.inicio.setAnterior(nova);
            nova.setProximo(this.inicio);
            this.inicio = nova;
            nova.setAnterior(null);
        }
        this.totalDeElementos++;
    }
    public void adicionaNoFim(T elemento) {
        if (this.totalDeElementos == 0){
            Celula nova = new Celula(elemento);
            this.fim = this.inicio = nova;
            this.inicio.setAnterior(null);
            this.fim.setProximo(null);
        }else {
            Celula nova = new Celula (elemento);
            this.fim.setProximo(nova);
            nova.setAnterior(this.fim);
            this.fim = nova;
            nova.setProximo(null);
        }
        this.totalDeElementos++;
    }
    public void adiciona(T elemento, int posicao) {
        if (posicao == 0) {
            Celula newCelula = new Celula(elemento);
            inicio.setAnterior(newCelula);
            inicio = newCelula;
        } else if (posicao == totalDeElementos - 1) {
            Celula newCelula = new Celula(elemento);
            fim.setProximo(newCelula);
            fim = newCelula;
        } else {
            Iterador<Celula> it = new Iterador<Celula>(this.inicio);
            int count = 0;
            while (it.hasNext()) {
                Celula c = it.getAtual();
                it.next();
                if (count == posicao) {
                    Celula newCelula = new Celula(elemento);
                    c.anterior.proximo = newCelula;
                    c.proximo.anterior = newCelula;
                    c.anterior = newCelula;
                }
                count++;
            }
        }
        totalDeElementos++;
    }
    public boolean existeDado(T elemento) {
        Iterador<Celula> it = new Iterador<Celula>(this.inicio);
        while (it.hasNext()) {
            Celula c = (Celula) it.next();
            if (elemento.equals(elemento))
                return true;
        }
        return false;
    }

    public T recupera(int posicao) {
        if (posicao == 0) {
            return (T) inicio.getElemento();
        } else if (posicao == totalDeElementos - 1) {
            return (T) fim.getElemento();
        } else {
            Iterador<Celula> it = new Iterador<Celula>(this.inicio);
            int count = 0;
            while (it.hasNext()) {
                Celula c = it.getAtual();
                it.next();
                if (count == posicao) {
                    return (T) c.getElemento();
                }
                count++;
            }
        }

        return (T) null;
    }
    public void remove(int posicao) {
        if (posicao == 0) {
            inicio.getProximo().setAnterior(null);
        } else if (posicao == totalDeElementos - 1) {
            fim.getAnterior().setProximo(null);
        } else {
            Iterador<Celula> it = new Iterador<Celula>(this.inicio);
            int count = 0;
            while (it.hasNext()) {
                Celula c = it.getAtual();
                it.next();
                if (count == posicao) {
                    Celula ant = c.getAnterior();
                    Celula prox = c.getProximo();

                    ant.setProximo(c.getProximo());
                    prox.setAnterior(c.getAnterior());
                }
                count++;
            }
        }
        totalDeElementos--;
    }


    public void removeInicio() {
        
        if (!this.posicaoOcupada(0)) {
            throw new IllegalArgumentException("Posição não existe");
            
        } else if (inicio == fim) {
            
            inicio = fim = null;
            this.totalDeElementos -= 1;
            
        } else {
            
            inicio = inicio.getProximo();
            this.totalDeElementos -= 1;
        }
    }

    public void removeFim() {
        
        if (!this.posicaoOcupada(0)) {
            throw new IllegalArgumentException("Posição não existe");
            
        } else if (inicio == fim) {
            
            inicio = fim = null;
            this.totalDeElementos -= 1;
            
        } else {
            
            fim = fim.getProximo();
            this.totalDeElementos -= 1;
        }
    }
    private boolean posicaoOcupada(int i) {
        return false;
    }
    public int tamanho() {
        return totalDeElementos;
    }
    public void limpa() {
        inicio = fim = null;
    }

}