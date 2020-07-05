package edu.fa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fa.model.Fresher;
import edu.fa.repository.FresherRepository;

//Lớp kết nối giữa @Controller với @Repository(kết nối, truy vấn db)
@Service
public class LoginService {
	
	//Nếu không dùng @Autowired (private LoginService loginService;)  ở controller thì phải
	//khởi tạo đối tượng fresherRepository ở trong hàm constructor 
	//và phải k.tạo đối tượng LoginService ở bên controller
	/*
	 * FresherRepository fresherRepository; public LoginService() {
	 * fresherRepository = new FresherRepository(); }
	 */
	
	//@Autowired ..."FresherRepository" sẽ add class tương ứng ở @Repository vào đây 
	//(Giống khởi tạo [new] đối tương  "FresherRepository" ở đây, nếu không có sẽ lỗi do chưa khởi tạo đối tượng)
	
	@Autowired 
	private FresherRepository fresherRepository;
	
	public boolean login(Fresher fresher) {
		//Khi chưa kết nối DB, dùng dữ liệu tự tạo
		return fresherRepository.authenticate(fresher);
		
		//Khi kết nối với CSDL bằng JPA
		//Fresher savedFresher = fresherRepository.findByUsernameAndPassword(fresher.getUsername(), fresher.getPassword());
		//return (savedFresher != null ); //Nếu tồn tại trả về true, không tồn tại trả về Object = null => false
	}
}
