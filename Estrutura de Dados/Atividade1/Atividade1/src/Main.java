class Main {
  public static void main(String[] args) {
    System.out.println("Deque Generico!");

    Deque<Integer> deque = new Deque();

    System.out.println(deque.isEmpty());

    deque.inserirNoInicio(1);
    deque.inserirNoInicio(2);
    deque.inserirNoFim(3);
    System.out.println(deque.existeDado(1));
    System.out.println(deque.existeDado(4));
    System.out.println(deque.recuperarInicio());
    System.out.println(deque.recuperarFim());
    deque.alterarInicio(4);
    System.out.println(deque.recuperarInicio());
    deque.alterarFim(5);
    System.out.println(deque.recuperarFim());
    deque.removerInicio();
    System.out.println(deque.recuperarInicio());
    deque.removerFim();
    System.out.println(deque.recuperarFim());
    System.out.println(deque.tamanho());
    deque.limpa();
    System.out.println(deque.tamanho());
    deque.inserirNoInicio(6);
    System.out.println(deque.tamanho());
    System.out.println(deque.recuperarInicio());
  }
}