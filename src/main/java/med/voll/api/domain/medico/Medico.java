package med.voll.api.domain.medico;
import jakarta.persistence.*;
import lombok.*;
import med.voll.api.domain.endereco.Endereco;
 @Table(name = "medicos")
 @Entity(name = "Medico")
 @Getter
 @NoArgsConstructor
 @AllArgsConstructor
 @EqualsAndHashCode(of = "id")
    public class Medico {

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String email;
        private String telefone;
        private String crm;

        @Enumerated(EnumType.STRING)
        private Especialidade especialidade;

        @Embedded
        private Endereco endereco;

        private Boolean ativo;

     public Medico(DadosCadastroMedico dados) {
         this.ativo = true;
         this.nome = dados.getNome();
         this.email = dados.getEmail();
         this.telefone = dados.getTelefone();
         this.crm = dados.getCrm();
         this.especialidade = dados.getEspecialidade();
         this.endereco = new Endereco(dados.getEndereco());
     }

     public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
         if(dados.nome() != null) {
             this.nome = dados.nome();
         }
         if (dados.telefone() != null){
             this.telefone = dados.telefone();
         }
         if (dados.endereco() != null){
             this.endereco.atualizarInformacoes(dados.endereco());
         }
     }

     public void excluir() {
         this.ativo = false;
     }
 }
