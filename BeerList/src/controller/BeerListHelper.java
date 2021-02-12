package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.BeerItem;

public class BeerListHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BeerList");
	
	public void insertBeer(BeerItem bi) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(bi);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<BeerItem> showAllBeers() {
		EntityManager em = emfactory.createEntityManager();
		List<BeerItem> allBeers = em.createQuery("SELECT i FROM BeerItem i").getResultList();
		return allBeers;
	}
	
	public void deleteBeer(BeerItem toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<BeerItem>typedQuery = em.createQuery("select bi from BeerItem bi where bi.brewery = :selectedBrewery and bi.beerName =:selectedBeerName and bi.beerType = :selectedBeerType", BeerItem.class);
		
		typedQuery.setParameter("selectedBrewery", toDelete.getBrewery());
		typedQuery.setParameter("selectedBeerName", toDelete.getBeerName());
		typedQuery.setParameter("selectedBeerType", toDelete.getBeerType());
		
		typedQuery.setMaxResults(1);
		
		BeerItem result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public BeerItem searchForBeerById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		BeerItem found = em.find(BeerItem.class, idToEdit);
		em.close();
		return found;
	}
	
	public List<BeerItem> searchForBeerByBrewery(String brewery) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<BeerItem> typedQuery = em.createQuery("select bi from BeerItem bi where bi.brewery = :selectedBrewery", BeerItem.class);
		typedQuery.setParameter("selectedBrewery", brewery);
		
		List<BeerItem> foundBeers = typedQuery.getResultList();
		em.close();
		return foundBeers;
	}
	
	public List<BeerItem> searchForBeerByBeerName(String beerName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<BeerItem> typedQuery = em.createQuery("select bi from BeerItem bi where bi.beerName = :selectedBeerName", BeerItem.class);
		typedQuery.setParameter("selectedBeerName", beerName);
		
		List<BeerItem> foundBeers = typedQuery.getResultList();
		em.close();
		return foundBeers;
	}
	
	public  List<BeerItem> searchForBeerByBeerType(String beerType) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<BeerItem> typedQuery = em.createQuery("select bi from BeerItem bi where bi.beerType = :selectedBeerType", BeerItem.class);
		typedQuery.setParameter("selectedBeerType", beerType);
		
		List<BeerItem> foundBeers = typedQuery.getResultList();
		em.close();
		return foundBeers;
	}
	
	public void updateBeer(BeerItem toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
