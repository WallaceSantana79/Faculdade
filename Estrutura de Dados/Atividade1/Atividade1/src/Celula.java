public class Celula {

    Celula proximo;
    Celula anterior;
    private Object elemento;
    private Object head;
    private Object top;

    public Celula() {
    }

    public Celula(Object elemento, Object head) {
        this.elemento = elemento;
        this.head = head;
        this.top = top;
    }

    public Celula(Celula proximo,Celula anterior, Object elemento) {
        this.proximo = proximo;
        this.anterior = anterior;
        this.elemento = elemento;
        this.head = head;
        this.top = top;
    }

    public Celula getProximo() {
        return proximo;
    }
    public Celula getAnterior() {
        return anterior;
    }

    public void setProximo(Celula proximo) {
        this.proximo = proximo;
    }
    public void setAnterior(Celula anterior) {
        this.anterior = anterior;
    }

    public Object getElemento() {
        return elemento;
    }
    public Object getHead() {
        return head;
    }
    public Object getTop() {
        return top;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
    public void setHead(Object head) {
        this.head = head;
    }
    public void setTop(Object top) {
        this.top = top;
    }

}