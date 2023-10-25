package fr.isika.cda.projet3.service;


import java.util.List;
import java.util.Optional;

public interface IService<T> {

	  void creer(T t);
      void modifier(T t);
      void supprimer(Long id);
      Optional<T> rechercherParId(Long id);
      List<T> rechercherTout();
	
}


