package edu.fa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fa.model.Fresher;
import edu.fa.repository.FresherRepository;

@Service
public class RegisterService {
	
	//@Autowired: Tự động khởi tạo đối tượng "FresherRepository" khi class này được gọi
	@Autowired
	private FresherRepository fresherRepository;
	
	public boolean register(Fresher fresher) {
		//Khi chưa kết nối DB, dùng dữ liệu tự tạo
		return fresherRepository.register(fresher);
		
		//Khi kết nối với CSDL bằng JPA
		//return (fresherRepository.save(fresher) != null );//Trả về true nếu Object # null, ngược lại fasle
	}
}
