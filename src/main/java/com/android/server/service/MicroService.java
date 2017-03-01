package com.android.server.service;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.android.server.entities.Categorie;
import com.android.server.entities.Produit;
import com.android.server.metier.IMetierRepository;
/**
 * 
 * @author SABER KHALIFA
 *
 */
@Service
@Controller
@RequestMapping(value = "/ms")
public class MicroService implements Serializable {
	private static final long serialVersionUID = 1L;
	@Autowired
	private IMetierRepository<Produit> metierProd;
	@Autowired
	private IMetierRepository<Categorie> metierCat;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody String test() {
		return "Hello Word !";
	}
	@RequestMapping(value = "/getAllProds", method = RequestMethod.GET)
	public @ResponseBody List<Produit> getAllProduits() {
		List<Produit> prods = metierProd.findAll(Produit.class);
		return prods;
	}
	@RequestMapping(value = "/getAllCats", method = RequestMethod.GET)
	public @ResponseBody List<Categorie> getAllCats() {
		List<Categorie> cats = metierCat.findAll(Categorie.class);
		return cats;
	}

	@RequestMapping(value = "/getAllProdsByCat", method = RequestMethod.GET)
	public @ResponseBody List<Produit> getAllProduitsByCat(Long idCat) {
		return filterByCategorie(idCat);
	}

	@RequestMapping(value = "/getCat", method = RequestMethod.GET)
	public @ResponseBody Categorie getCategorieById(Long idCat) {
		return metierCat.find(Categorie.class, idCat);
	}
	public IMetierRepository<Produit> getMetierProd() {
		return metierProd;
	}

	public void setMetierProd(IMetierRepository<Produit> metierProd) {
		this.metierProd = metierProd;
	}

	public IMetierRepository<Categorie> getMetierCat() {
		return metierCat;
	}

	public void setMetierCat(IMetierRepository<Categorie> metierCat) {
		this.metierCat = metierCat;
	}

	private List<Produit> filterByCategorie(Long idCat) {
		List<Produit> prods = metierProd.findAll(Produit.class);
		List<Produit> temp = new ArrayList<Produit>();
		for (int i = 0; i < prods.size(); i++) {
			if (prods.get(i).getCategorie().getIdCategorie() == idCat) {
				temp.add(prods.get(i));
			}

		}
		return temp;
	}
}
