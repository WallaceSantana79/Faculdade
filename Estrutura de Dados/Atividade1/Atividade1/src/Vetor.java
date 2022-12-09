public class Vetor<T> {

    public int tam;
    private T[] elementos;
    private Integer pretendedPosition;
    private String typeRedimensionar = null;

    public Vetor() {
        this.tam = 0;
        this.elementos = (T[]) new Object[tam];
    }

    public Vetor(int tam) {
        this.tam = tam;
        this.elementos = (T[]) new Object[tam];
    }

    public void adiciona(T elemento, int posicao) {
        try {
            elementos[posicao] = elemento;
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
            pretendedPosition = posicao;
            redimensiona();
            elementos[pretendedPosition] = elemento;
        }
    }

    public void adicionaInicio(T elemento) {
        pretendedPosition = 0;
        try {
            typeRedimensionar = "i";
            redimensiona();
            elementos[0] = elemento;
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

    public void adicionaFim(T elemento) {
        try {
            typeRedimensionar = "f";
            redimensiona();
            elementos[tam - 1] = elemento;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean existeDado(int pos) {
        try {
            return elementos[pos] != null;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
        return false;
    }

    public T recupera(int pos) {
        try {
            if (vazio() == false && existeDado(pos) == true) {
                return elementos[pos];
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean vazio() {
        try {
            Iterador it = new Iterador(elementos);
            int count = 0;

            while (it.hasNext()) {
                if (it.next() != null) {
                    count++;
                }
            }
            return count == 0;
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println(e);
            return true;
        }
    }

    public void remover(int pos) {
        try {
            elementos[pos] = null;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

    public void removerInicio() {
        remover(0);
    }

    public void removerFim() {
        remover(elementos.length - 1);
    }

    public int tamanho() {
        Iterador it = new Iterador(elementos);
        int count = 0;

        try {
            while (it.hasNext()) {
                if (it.next() != null) {
                    count++;
                }
            }
            return count;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
            return 0;
        }

    }

    public void limpa() {
        try {
            Iterador it = new Iterador(elementos);
            int count = 0;
            while (it.hasNext()) {
                it.next();
                remover(count);
                count++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

    public void redimensiona() {
        try {
            Iterador it = new Iterador(elementos);
            Integer startPos = -1;
            Integer size = null;

            switch (typeRedimensionar) {
                case "f":
                    startPos = 0;
                    break;
                case "i":
                    startPos = 1;
                    break;
                case "n":
                    startPos = 0;
                    break;
            }

            T[] novoElementos = (T[]) new Object[tam + 1];
            while (it.hasNext()) {
                novoElementos[startPos] = (T) it.next();
                startPos++;
            }
            elementos = novoElementos;
            this.tam++;
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println(e);
        }
    }
}
