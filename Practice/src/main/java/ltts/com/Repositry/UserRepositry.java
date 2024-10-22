package ltts.com.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ltts.com.Model.User;
@Repository
public interface UserRepositry extends JpaRepository<User,Integer> {

}
