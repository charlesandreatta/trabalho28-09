package modelo;

import java.util.ArrayList;
import java.util.List;

public class BancoCentral {
	private String pais;
	private List<Banco> bancos = new ArrayList<>();
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public List<Banco> getBancos() {
		return bancos;
	}
	public void setBancos(List<Banco> bancos) {
		this.bancos = bancos;
	}
	
	private Boolean bancoExistente(Integer codigo) {
		Banco bancoComparar = new Banco();
		bancoComparar.setCodigo(codigo);
		return bancos.contains(bancoComparar);
	}
	
	public Banco validarBanco(Integer codigo) {
		if (bancoExistente(codigo)) {
			Banco bancoEncontrado = new Banco();
			bancoEncontrado.setCodigo(codigo);
			return bancoEncontrado = bancos.get(bancos.indexOf(bancoEncontrado));
		}
		return null;
	}

	
	public void criarBanco(String nome) {
		Banco banco = new Banco();
		banco.setNome(nome);
		banco.setCodigo(bancos.size()+1);
		bancos.add(banco);
		System.out.println("Banco criado com sucesso...");
		System.out.println(banco);
	}
	
	public void realizarDoc(Integer codigoBanco,String contaBanco,Integer codigoBancoReceber, String contaReceber, Double valor) {
		Banco banco = validarBanco(codigoBanco);
		if(banco!=null) {
			Banco bancoReceber = validarBanco(codigoBancoReceber);
			if(bancoReceber!=null) {
				Boolean retorno = banco.enviarDoc(codigoBanco, contaBanco, valor, contaReceber);
				Boolean retornoRecebimento = bancoReceber.receberDoc(codigoBanco, contaBanco, valor, contaReceber);
				if(retorno) {
					System.out.println("Doc enviado com sucesso...");
				}else {
					System.out.println("Houve um erro no envio do doc");
				}
				
				if(retornoRecebimento) {
					System.out.println("Doc recebido com sucesso...");					
				}else {
					System.out.println("Houve um erro no recebimento do doc");
				}
			}
			
		}
	}
}
