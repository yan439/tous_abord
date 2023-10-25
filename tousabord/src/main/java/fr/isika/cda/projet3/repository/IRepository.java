package fr.isika.cda.projet3.repository;


import java.util.List;
import java.util.Optional;

public interface IRepository<T> {

	  T creer(T t);
      void modifier(T t);
      void supprimer(Long id);
      Optional<T> rechercherParId(Long id);
      List<T> rechercherTout();
	
}

