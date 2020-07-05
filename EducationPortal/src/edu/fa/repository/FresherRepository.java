package edu.fa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.fa.model.Fresher;

//Lớp mô tả kết nối, truy vấn CSDL (giống dao). Ở đây chưa kết nối DB
@Repository
public class FresherRepository {
	
	//Hàm giống kiểm tra tài khoản đăng nhập với csdl, 
	//Ở đây không có csdl nên kiểm tra: tên = password => đăng nhập sai
	public boolean authenticate(Fresher fresher) {
		if( fresher.getUsername().equals(fresher.getPassword()) ) {
			return false;
		}
		
		return true;
	}

	public boolean register(Fresher fresher) {
		//Tạm thời chưa kết nối DB thì cho đăng ký khi username khác password
		if( fresher.getUsername().equals(fresher.getPassword()) ) {
			return false;
		}
		
		return true;
	}
	
}

//Khi kết nối với CSDL bằng JPA
/*
 * public interface FresherRepository extends JpaRepository<Fresher, Integer>{
 * //Dùng Query method(trong JPA) để truy vấn DB với 2 tiêu chí là username và
 * password
 *  Fresher findByUsernameAndPassword(String username, String password);
 * }
 */
