public class ListaDuplamenteEncadeadaComNóCabeça<T> {

    private Celula inicio, fim, anterior, proxima, elemento;
    T[] head;
    private int totalDeElementos, tam;
    private T[] elementos;

    public ListaDuplamenteEncadeadaComNóCabeça() {
        this.inicio = null;
        this.fim = null;
        this.totalDeElementos = 0;
        this.tam = 0;
        this.elementos = (T[]) new Object [tam];
        this.head = (T[]) new Object [tam];
    }
    
    public ListaDuplamenteEncadeadaComNóCabeça(T elemento){
        this.inicio = null;
        this.fim = null;
        this.totalDeElementos = 0;
        this.tam = tam;
        this.elementos = (T[]) new Object[tam];
        this.head = (T[]) new Object [tam];
        this.adicionaNoComeco(elemento, head);
        this.adicionaNoFim(elemento, head);
    
    }

    public void adicionaNoComeco(T elemento, T head) {
        if (this.totalDeElementos == 0){
            Celula nova = new Celula(elemento);
            this.fim = this.inicio = nova;
            this.inicio.setAnterior(head);
            this.fim.setProximo(head);
            this.head.setAnterior(fim);
            this.head.setProximo(inicio);
        }else {
            Celula nova = new Celula (elemento);
            this.inicio.setAnterior(nova);
            nova.setProximo(this.inicio);
            this.inicio = nova;
            nova.setAnterior(head);
            this.head.setProximo(nova);
        }
        this.totalDeElementos++;
    }
    public void adicionaNoFim(T elemento, T head) {
        if (this.totalDeElementos == 0){
            Celula nova = new Celula(elemento);
            this.fim = this.inicio = nova;
            this.inicio.setAnterior(head);
            this.fim.setProximo(head);
            this.head.setAnterior(fim);
            this.head.setProximo(inicio);
        }else {
            Celula nova = new Celula (elemento);
            this.fim.setProximo(nova);
            nova.setAnterior(this.fim);
            this.fim = nova;
            nova.setProximo(head);
            this.head.setAnterior(nova);
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
            inicio.getProximo().setAnterior(head);
        } else if (posicao == totalDeElementos - 1) {
            fim.getAnterior().setProximo(head);
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


    public T removeInicio() {
        T elemento = null;
        if (fim == null && inicio == null) {
            System.out.println("- Vazio");
        } else if (inicio == fim) {
            elemento = (T) inicio.getElemento();
            inicio = null;
            fim = null;
            this.head.setAnterior = null;
            this.head.setProximo = null;
        } else if (tamanho == 2) {
            elemento = (T) inicio.getElemento();
            fim.setProximo(null);
            fim.setAnterior(null);
            inicio = fim;
            this.head.setAnterior(inicio);
            this.head.setProximo(inicio);
            this.inicio.setAnterior(head);
            this.inicio.setProximo(head);
        } else {
            elemento = (T) inicio.getElemento();

            inicio = inicio.getProximo();

            inicio.getAnterior().setAnterior(null);
            inicio.getAnterior().setProximo(null);

            inicio.setAnterior(head);
            fim.setProximo(head);
            this.head.setAnterior(fim);
            this.head.setProximo(inicio);
        }
        tamanho--;
        return elemento;
    }

    public T removeFim() {
        T elemento = null;
        if (fim == null && inicio == null) {
            System.out.println("- Vazio");
        } else if (inicio == fim) {
            elemento = (T) fim.getElemento();
            inicio = null;
            fim = null;
            this.head.setAnterior = null;
            this.head.setProximo = null;
        } else if (tamanho == 2) {
            elemento = (T) fim.getElemento();
            inicio.setProximo(null);
            inicio.setAnterior(null);
            fim = inicio;
            this.head.setAnterior(inicio);
            this.head.setProximo(inicio);
            this.fim.setAnterior(head);
            this.fim.setProximo(head);
        } else {
            elemento = (T) fim.getElemento();

            fim = fim.getAnterior();

            fim.getProximo().setAnterior(null);
            fim.getProximo().setProximo(null);

            fim.setProximo(head);
            inicio.setAnterior(head);
            this.head.setAnterior(fim);
            this.head.setProximo(inicio);
        }
        tamanho--;
        return elemento;
    }

}