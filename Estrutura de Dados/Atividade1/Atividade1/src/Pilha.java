public class Pilha<T> {
    Celula inicio;
    Celula fim;
    int tamanho;
    Celula top;

    public Pilha() {
        this.tamanho = 0;
        this.top = null;
    }
    public void Push(T elemento) {
        if (this.tamanho == 0) {
            this.inicio = new Celula(elemento);
        } else {
            Celula<T> nova = new Celula(elemento);

            nova.setProximo(this.top);

            this.top = nova;

            fim.setProximo(new Celula<T>(elemento));
        }

        this.tamanho++;
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

    public boolean isEmpty() {
        if (this.tamanho == 0) {
            return true;
        } else {
            return false;
        }
    }
    public T Top() {
        if (this.tamanho == 0) {
            return null;
        } else {
            return this.top.getElemento();
        }
    }
    public void pull( T elemento) {
        if (this.tamanho == 0) {
            this.Push(elemento);
        } else {
            this.top.setElemento(elemento);
        }

    }

    public T Pop() {
        if (this.tamanho != 0) {
            this.top = this.top.getProximo();
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