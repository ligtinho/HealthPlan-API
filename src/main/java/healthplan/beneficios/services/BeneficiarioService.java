package healthplan.beneficios.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import healthplan.beneficios.entity.Beneficiario;
import healthplan.beneficios.entity.Documento;
import healthplan.beneficios.repository.BeneficiarioRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BeneficiarioService {
    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    public List<Beneficiario> getAllBeneficiarios() {
        return beneficiarioRepository.findAll();
    }

    public Optional<Beneficiario> getBeneficiarioById(Long id) {
        return beneficiarioRepository.findById(id);
    }

    public List<Documento> getDocumentosByBeneficiarioId(Long id) {
        Optional<Beneficiario> beneficiarioOptional = beneficiarioRepository.findById(id);
        return beneficiarioOptional.map(Beneficiario::getDocumentos).orElse(null);
    }

    public Beneficiario cadastrarBeneficiario(Beneficiario beneficiario) {
        beneficiario.setDataInclusao(LocalDate.now());
        beneficiario.setDataAtualizacao(LocalDate.now());
        
        if (beneficiario.getDocumentos() != null) {
            for (Documento documento : beneficiario.getDocumentos()) {
                documento.setBeneficiario(beneficiario);
                
            }
        }

        return beneficiarioRepository.save(beneficiario);
    }

    public Beneficiario atualizarBeneficiario(Long id, Beneficiario novoBeneficiario) {
        Optional<Beneficiario> beneficiarioOptional = beneficiarioRepository.findById(id);

        if (beneficiarioOptional.isPresent()) {
            Beneficiario beneficiarioExistente = beneficiarioOptional.get();
            
            beneficiarioExistente.setNome(novoBeneficiario.getNome());
            beneficiarioExistente.setTelefone(novoBeneficiario.getTelefone());
            beneficiarioExistente.setDataNascimento(novoBeneficiario.getDataNascimento());
            beneficiarioExistente.setDataAtualizacao(LocalDate.now());

            
            return beneficiarioRepository.save(beneficiarioExistente);
        } else {
           
            return null;
        }
    }

    public void removerBeneficiario(Long id) {
        beneficiarioRepository.deleteById(id);
    }
}
