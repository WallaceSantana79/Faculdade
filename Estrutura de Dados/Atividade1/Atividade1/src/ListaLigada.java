public class ListaLigada {
    private Celula primeira;
    private Celula ultima;
    private int totalDeElementos;

    public void adicionaNoComeco(Object elemento) {
        Celula nova = new Celula(this.primeira,this.ultima elemento);
        this.primeira = nova;

        if (this.totalDeElementos == 0){
            this.ultima = this.primeira;
        }
        this.totalDeElementos++;
    }
    
}
