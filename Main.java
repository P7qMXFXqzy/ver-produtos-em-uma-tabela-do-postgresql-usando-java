import postgre.Conexao;

public class Main {
	
	public static void main(String[] args) {
		Conexao objetoConexao = new Conexao();
		//se a conexão com o banco de dados for bem sucedida, mostrar todos os produtos salvos na tabela produtos
		if(objetoConexao.conectar() == true) {
			objetoConexao.mostrarProdutos();	
		}
	}

}
