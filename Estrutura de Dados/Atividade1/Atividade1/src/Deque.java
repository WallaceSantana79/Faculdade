public class Deque<T> {
    Celula inicio;
    Celula fim;
    int tamanho;

    public Deque() {
        this.tamanho = 0;
    }
    public void inserirNoInicio(T elemento) {
        if (this.tamanho == 0) {
            this.inicio = new Celula(elemento);
            this.fim = this.inicio;
        } else {
            Celula<T> adicionar = new Celula (elemento);
            this.inicio.setAnterior(adicionar);
            this.inicio = adicionar;
        }

        this.tamanho++;
    }
    
    public void inserirNoFim(T elemento) {
        if (this.tamanho == 0) {
            this.fim = new Celula(elemento);
            this.inicio = this.fim;
        }else {
            Celula<T> adicionar = newCelula (elemento);
            this.fim.setProximo(adicionar);
            this.fim= adicionar;
        }
        this.tamanho++;
    }

    public boolean existeDado(T elemento) {
        if (this.tamanho == 0) {
            return false;
        } else {
            Iterador<T> it = new Iterador(this.inicio);

            Celula<T> celula = null;

            while (it.hasNext()) {
                celula = it.getAtual();
                if (celula.getElemento().equals(elemento)) {
                    return true;
                }
                it.next();
            }

            return false;
        }
    }

    public boolean isEmpty() {
        if (this.tamanho == 0) {
            return true;
        } else {
            return false;
        }
    }
    public T recuperarInicio(int posicao) {
        if (this.tamanho == 0) {
            return null;
        } else {
            return this.inicio.getElemento();
        }
    }
    public T recuperarFim() {
        if (this.tamanho == 0) {
            return null;
        } else {
            return this.fim.getElemento();
        }
    }
    public void alterarInicio(T elemento) {
        if (this.tamanho == 0) {
            this.inserirNoInicio(elemento);
        } else {
            this.inicio.setElemento(elemento);
        }

    }

    public void alterarFim(T elemento) {
        if (this.tamanho == 0) {
            this.inserirNoFim(elemento);
        } else {
            this.fim.setElemento(elemento);
        }

    }

    public void removerInicio() {
        if (this.tamanho != 0) {
            if (this.tamanho < 2) {
                this.inicio = null;
                this.fim = null;
            } else if (tamanho > 1) {
                this.inicio = this.inicio.getProximo();
            }

            this.tamanho--;
        }
    }

    public void removerFim() {
        if (this.tamanho != 0) {
            if (this.tamanho < 2) {
                this.inicio = null;
                this.fim = null;
            } else if (tamanho > 1) {
                this.fim = this.fim.getAnterior();
            }

            this.tamanho--;
        }
    }

    public int tamanho() {
        return tamanho;
    }

    public void limpa() {
        inicio = fim = null;
        tamanho = 0;
    }
}