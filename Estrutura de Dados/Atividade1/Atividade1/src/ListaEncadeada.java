public class ListaEncadeada<T> {
    
    Celula inicio;
    Celula fim;
    int tamanho;

    public ListaEncadeada() {
        this.tamanho = 0;
    }
    public void adiciona(T elemento, int posicao) {
        
         if (posicao == tamanho - 1) {
            Celula newCelula = new Celula(elemento, null);
            fim.setProximo(newCelula);
            fim = newCelula;
        } else {
            Iterador<Celula> it = new Iterador<Celula>(this.inicio);
            int count = 0;
            while (it.hasNext()) {
                Celula c = it.getAtual();
                it.next();
                if (count == posicao-1) {
                    Celula newCelula = new Celula(elemento, c.getProximo());
                    c.setProximo(newCelula);
                }
                count++;
            }
        }
        tamanho++;
    }
    public void adicionaInicio(T elemento) {
        if (fim == null && inicio == null) {
            Celula newCelula = new Celula(elemento, null);
            inicio = newCelula;
            fim = inicio;
        } else if (tamanho == 1) {
            Celula newCelula = new Celula(elemento, fim);
            inicio.setProximo(newCelula);
            inicio = newCelula;
        
        }
        tamanho++;
    }
    public void adicionaFim(T elemento) {
        if (fim == null && inicio == null) {
            Celula newCelula = new Celula(elemento, null);
            inicio = newCelula;
            fim = inicio;
        } else if (tamanho == 1) {
            Celula newCelula = new Celula(elemento, null);
            fim.setProximo(newCelula);
            fim = newCelula;
        } else {
            Celula newCelula = new Celula(elemento, null);
            fim.setProximo(newCelula);
            fim = newCelula;
        }
        tamanho++;
    }

    public boolean existeDado(T elemento) {
        Iterador<Celula> it = new Iterador<Celula>(this.inicio);
        while (it.hasNext()) {
            Celula c = (Celula) it.next();
            if (c.getElemento().equals(elemento))
                return true;
        }
        return false;
    }
    
    public T recupera(int posicao) {
        if (posicao == 0) {
            return (T) inicio.getElemento();
        } else if (posicao == tamanho - 1) {
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
        return null;
    }

    public void remove(int posicao) {
        if (posicao == 0) {
            inicio = inicio.getProximo();
        } else if (posicao == tamanho - 1) {
            Iterador<Celula> it = new Iterador<Celula>(this.inicio);
            int count = 0;
            while (count == this.tamanho-2) {
                Celula c = it.getAtual();
                it.next();
                if (count == posicao) {
                    
                    c.setProximo(null);
                }
                count++;
            }
        } else {
            Iterador<Celula> it = new Iterador<Celula>(this.inicio);
            int count = 0;
            while (it.hasNext()) {
                Celula c = it.getAtual();
                it.next();
                if (count == posicao-1) {
                    //todo

                    it.next();
                    
                    c.setProximo(it.getAtual());
                }
                count++;
            }
        }
        tamanho--;
    }

    public T removeInicio() {
        T elemento = null;
        if (fim == null && inicio == null) {
            System.out.println("- Vazio");
        } else if (inicio == fim) {
            elemento = (T) inicio.getElemento();
            inicio = null;
            fim = null;
        } else if (tamanho == 2) {
            elemento = (T) inicio.getElemento();
            inicio = fim;
        } else {
            elemento = (T) inicio.getElemento();

            inicio = inicio.getProximo();

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
        } else if (tamanho == 2) {
            elemento = (T) fim.getElemento();
            inicio.setProximo(null);
            fim = inicio;
        } else {
            elemento = (T) fim.getElemento();
            fim.setProximo(null);
        }
        tamanho--;
        return elemento;
    }
    public int tamanho() {
        return tamanho;
    }

    public void limpa() {
        inicio = fim = null;
    }

    public void iterar() {

        Iterador<String> it = new Iterador<String>(this.inicio);

        while (it.hasNext()) {
            String m = (String) it.next();
            System.out.println(m);

        }
    }
}