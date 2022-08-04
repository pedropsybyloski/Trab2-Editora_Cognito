package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ArtigoService {

	@Autowired
	private ArtigoRepository ar;
	
	public List<Artigo> listAll() {
		return ar.findAll();
	}

	public void save(Artigo artigo) {
		ar.save(artigo);
	}
	
	public Artigo get(long id) {
		return ar.findById(id).get();
	}
	
	public void delete(long id) {
		ar.deleteById(id);
	}
}
