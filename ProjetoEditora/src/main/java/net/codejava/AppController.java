package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@Autowired
	private ArtigoService service;
	
	/*Rota principal mostrando todos os Artigos já criados*/
	@RequestMapping("/")
	public String index(Model model, Authentication a) {
		model.addAttribute("login", a);
		if (a != null) {
			List<Artigo> listArtigos = service.listAll();
			model.addAttribute("listArtigos", listArtigos);
			return "index";
		}else {
			List<Artigo> listArtigos = service.listAll();
			model.addAttribute("listArtigos", listArtigos);
			return "index";
		}
	}
	
	/*Rota para criação de um novo artigo*/
	@RequestMapping("/new")
	public String showNewProductPage(Model model, Authentication a) {
		Artigo artigo = new Artigo();
		model.addAttribute("artigo", artigo);
		
		return "new_artigo";
	}
	
	/*Rota de redirecinamento para salvar um NOVO arquivo ou um arquivo ATUALIZADO*/
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("artigo") Artigo artigo) {
		service.save(artigo);
		
		return "redirect:/";
	}
	
	
	/*Rota de edição de um determinado artigo*/
	@RequestMapping(value = "/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id, Authentication a) {
		ModelAndView mav = new ModelAndView("edit_artigo");
		Artigo artigo = service.get(id);
		mav.addObject("artigo", artigo);
		return mav;
	}
	
	/*Rota para deletar um determinado artigo*/
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id, Authentication a) {
		service.delete(id);
		return "redirect:/";		
	}
}
