public class Fila<T> {
    Celula inicio;
    Celula fim;
    int tamanho;

    public Fila() {
        this.tamanho = 0;
    }
    public void Push(T elemento) {
        if (this.tamanho == 0) {
            this.inicio = new Celula(elemento);
        } else {
            Iterador<T> it = new Iterador(this.inicio);

            Celula<T> fim = null;

            while (it.hasNext()) {
                fim = it.getAtual();
                it.next();
            }

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
    public T Recuperar(int posicao) {
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
    public void Alterar( T elemento) {
        if (this.tamanho == 0) {
            this.Push(elemento);
        } else {
            this.inicio.setElemento(elemento);
        }

    }

    public T Remover() {
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

    public int tamanho() {
        return tamanho;
    }

    public void limpa() {
        inicio = fim = null;
        tamanho = 0;
    }
}