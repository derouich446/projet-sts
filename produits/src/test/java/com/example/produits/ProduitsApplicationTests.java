package com.example.produits;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.produits.entities.Categorie;
import com.example.produits.entities.produit;


@SpringBootTest
class ProduitsApplicationTests {
@Autowired
private ProduitRepository produitRepository;
@Test
public void testCreateProduit() {
produit prod = new produit("asus",2200.500,new Date());
produitRepository.save(prod);
}

@Test
public void testFindProduit()
{
produit p = produitRepository.findById(1L).get();
System.out.println(p);
}

@Test
public void testUpdateProduit()
{
produit p = produitRepository.findById(1L).get();
p.setPrixProduit(2000.0);
produitRepository.save(p);
}

@Test
public void testDeleteProduit()
{
produitRepository.deleteById(1L);;
}

@Test
public void testFindProduitByNom()
{
List<produit> prods = produitRepository.findByNomProduit("PS 4");
   for (produit p : prods)
     {
       System.out.println(p);
     }
}
 

@Test
public void testFindByNomProduitContains()
{
List<produit> prods = produitRepository.findByNomProduitContains("P");
   for (produit p : prods)
     {
       System.out.println(p);
     }
}
 
@Test
public void testfindByNomPrix()
{
List<produit> prods = produitRepository.findByNomPrix("PC Dell", 1000.0);
for (produit p : prods)
{
System.out.println(p);
}
}


@Test
public void testfindByCategorie()
{
Categorie cat = new Categorie();
cat.setIdCat(1L);
List<produit> prods = produitRepository.findByCategorie(cat);
for (produit p : prods)
{
System.out.println(p);
}
}





@Test
public void testListerTousProduits()
{
List<produit> prods = produitRepository.findAll();
for (produit p : prods)
{
System.out.println(p);
}
}

@Test
public void findByCategorieIdCat()
{
List<produit> prods = produitRepository.findByCategorieIdCat(1L);
for (produit p : prods)
{
  System.out.println(p);
}
 }

@Test
public void testfindByOrderByNomProduitAsc()
{
List<produit> prods =
produitRepository.findByOrderByNomProduitAsc();
for (produit p : prods)
{
System.out.println(p);
}
}

@Test
public void testTrierProduitsNomsPrix()
{
List<produit> prods = produitRepository.trierProduitsNomsPrix();
for (produit p : prods)
{
System.out.println(p);
}
}

}