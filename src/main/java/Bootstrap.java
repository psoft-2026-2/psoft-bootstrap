public class Bootstrap {

    public static void main(String[] args) {

        System.out.println("Projeto de Software");

	private List<Pessoa> pessoas = new ArrayList<>();

	//CREATE
	public void add(Pessoa pessoa){
		pessoas.add(pessoa);
	}

	public Pessoa buscarPessoa(String cpf){
		for(Pessoa p : pessoas){
			if(p.getCpf().equals(cpf)){
				return p;
			}
		}

		return null;
	}

	//UPDATE
	public void update(Pessoa pessoa){
		//depende do que botar aqui
	}

	//READ
	public List<Pessoa> listarTodos(){
		return pessoas;
	}

    }
}
