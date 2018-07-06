

public class Cadastro {

	private EntityManager em = Persistence.createEntityManagerFactory("sorteadorCriteriosinho").createEntityManager();

	public void cadastrar(String nome, String email, String senha, String cpf) {
		Usuario u = new Usuario();
		u.setNome(nome);
		u.setEmail(email);
		u.setSenha(senha);
		u.setCpf(cpf);
		
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
	}


}
