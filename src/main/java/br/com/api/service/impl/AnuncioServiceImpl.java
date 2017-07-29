package br.com.api.service.impl;

import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.api.model.Anuncio;
import br.com.api.model.Usuario;
import br.com.api.repository.AnuncioRepository;
import br.com.api.service.AnuncioService;
import br.com.api.service.SecurityService;

@Service
public class AnuncioServiceImpl implements AnuncioService{
	
	@Autowired
	private AnuncioRepository anuncioRepository;
	
	@Autowired
	private SecurityService securityService;
	
	@Value("${diretorio.dirFisico}")
	private String diretorioFisico;
	
	@Value("${diretorio.dirBd}")
	private String diretorioBd;

	@Override
	public Anuncio findOne(Long codigo) {
		return anuncioRepository.findOne(codigo);
	}

	@Override
	public List<Anuncio> findAll() {
		return retornarAnuncios();
	}	

	@Override
	public void delete(Long codigo) {
		anuncioRepository.delete(codigo);
	}

	@Override
	public Anuncio save(Anuncio anuncio) {				
		if (anuncio.getDataCriacao() == null) {
			anuncio.setDataCriacao(new Date());
		}		
		if (anuncio.getUsuario() == null) {
			anuncio.setUsuario(securityService.userLogged());
		}			
		return anuncioRepository.save(anuncio);
	}

	@Override
	public void edit(Anuncio anuncio) {
		anuncioRepository.save(anuncio);
	}
	
	private List<Anuncio> retornarAnuncios() {
        Usuario userLogado =  securityService.userLogged();						
		if (userLogado != null && userLogado.getRoles().equals(Usuario.ROLE_USER)) {
			return anuncioRepository.findByUsuario(userLogado);
		} else {
			return anuncioRepository.findAll();
		}
	}

	@Override
	public void upload(Long codigo, MultipartFile uploadfile) throws Exception {
		
		Anuncio anuncio = anuncioRepository.findOne(codigo);		
		
		if (!uploadfile.getOriginalFilename().isEmpty()) {
			String extensao[] = uploadfile.getOriginalFilename().split("\\.");
			String extencao = extensao[1];
			
			if (extencao.equalsIgnoreCase("PNG") || extencao.equalsIgnoreCase("JPEG") ||
				extencao.equalsIgnoreCase("JPG") || extencao.equalsIgnoreCase("BMP")) {
				
				String nomeArq = codigo + "." + extencao;
				String dirFisico = diretorioFisico + nomeArq; 
				String dirBd = diretorioBd + nomeArq;
				
				FileOutputStream fos = new FileOutputStream(dirFisico);
				fos.write(uploadfile.getBytes());
				fos.close();
				
				anuncio.setDiretorio(dirBd);
				anuncioRepository.save(anuncio);
			}
		} else {
			if (anuncio.getDiretorio() == null || anuncio.getDiretorio().isEmpty()) {
				anuncio.setDiretorio(diretorioBd + "semImagem.png");
				anuncioRepository.save(anuncio);
			}
		}		
	}
}
