package healthplan.beneficios.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import healthplan.beneficios.entity.Beneficiario;
import healthplan.beneficios.entity.Documento;
import healthplan.beneficios.services.BeneficiarioService;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/api/beneficiarios")
public class BeneficiarioController {
	@Autowired
	private BeneficiarioService beneficiarioService;
	
	
	@GetMapping("/listbeneficiarios")
	public List<Beneficiario> getAllBeneficiarios() {
		return beneficiarioService.getAllBeneficiarios();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Beneficiario> getBeneficiarioById(@PathVariable Long id) {
		Optional<Beneficiario> beneficiario = beneficiarioService.getBeneficiarioById(id);

		if (beneficiario.isPresent()) {
			
			return ResponseEntity.ok(beneficiario.get());
		} else {
			
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/{id}/documentos")
	public ResponseEntity<List<Documento>> getDocumentosByBeneficiarioId(@PathVariable Long id) {
		List<Documento> documentos = beneficiarioService.getDocumentosByBeneficiarioId(id);

		if (documentos != null) {
			return ResponseEntity.ok(documentos);
		} else {
			
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Beneficiario> cadastrarBeneficiario(@RequestBody Beneficiario beneficiario) {
		Beneficiario novoBeneficiario = beneficiarioService.cadastrarBeneficiario(beneficiario);
		
		return ResponseEntity.status(201).body(novoBeneficiario);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Beneficiario> atualizarBeneficiario(@PathVariable Long id,
			@RequestBody Beneficiario novoBeneficiario) {
		Beneficiario beneficiarioAtualizado = beneficiarioService.atualizarBeneficiario(id, novoBeneficiario);

		if (beneficiarioAtualizado != null) {
			
			return ResponseEntity.ok(beneficiarioAtualizado);
		} else {
			
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removerBeneficiario(@PathVariable Long id) {
		beneficiarioService.removerBeneficiario(id);
		
		return ResponseEntity.noContent().build();
	}
}