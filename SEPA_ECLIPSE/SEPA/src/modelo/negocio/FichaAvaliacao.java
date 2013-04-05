package modelo.negocio;

public class FichaAvaliacao {
	private int id;
	private String nome;
	private String descricao;
        private Area area;
	
	public FichaAvaliacao(int id, String nome,String descricao, Area area){
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
                this.area = area;
	}
	
	public FichaAvaliacao(String nome, String descricao, Area area){
		this.nome = nome;
		this.descricao = descricao;
                this.area = area;
	}

    
        public Area getArea(){
            return area;
        }

        public void setArea(Area area){
            this.area = area;
        }
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getDescricao() {
		return descricao;
	}

	public void descricao(String descricao) {
		this.descricao = descricao;
	}
        
	
	public String toString(){
		return this.nome;
	}
}
