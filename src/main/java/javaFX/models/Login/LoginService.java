package javaFX.models.Login;

import javax.transaction.Transactional;
import java.util.List;

public interface LoginService {

	List<Login> findAllLogins();

	@Transactional
	Login save(Login login);


}
