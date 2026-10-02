public class Sprint {
  
    private int numero;
    private Pessoa lider;
    private boolean encerrada;

    public Sprint(int num, Pessoa lider) {
        this.numero = num;
        this.lider = lider;
        this.encerrada = false;

        // Adiciona o papel de líder apenas se a pessoa for um desenvolvedor válido
        if (lider != null && lider.possuiPapel("Desenvolvedor")) {
            lider.adicionarPapel(new Líder());
        }
    }

    public int getNumero() {
        return numero;
    }

    public Pessoa getLider() {
        return lider;
    }

    public boolean isEncerrada() {
        return encerrada;
    }

    public void encerrar() {
        if (!encerrada) {
            if (lider != null && lider.possuiPapel("Líder")) {
                lider.removerPapel(new Líder());
            }
            encerrada = true;
        }
    }
}