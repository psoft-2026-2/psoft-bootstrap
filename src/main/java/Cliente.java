public class Cliente {
   private String nome;
   private String idCliente;
   private Perfil perfil;
   
   public Cliente(String nome, String idCliente, Perfil perfil) {
        this.nome = nome;
        this.idCliente = idCliente;
        this.perfil = perfil;
   }

   public String getNome() {
        return this.nome;
   }

   public String getId() {
        return this.idCliente;
   }

   public Perfil getPerfil() {
        return this.perfil;
   }

   public void setPerfil(Perfil newPerfil) {
     this.perfil = newPerfil;
   }
}
