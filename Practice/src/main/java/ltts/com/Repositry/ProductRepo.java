package ltts.com.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import ltts.com.Model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

	
	@Query("SELECT p from Product p where p.productName like %:pName%")
	public List<Product> searchByProductName(String pName);
	
	
	
	

}
