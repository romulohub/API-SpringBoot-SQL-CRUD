package med.voll.api.paciente;

public record DadosListagemPaciente(String nome, String email, String telefone, Sexo sexo) {

    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getNome(), paciente.getEmail(), paciente.getEmail(), paciente.getSexo());
    }
}

