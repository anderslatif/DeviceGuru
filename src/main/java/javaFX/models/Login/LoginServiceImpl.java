package javaFX.models.Login;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class LoginServiceImpl implements LoginService {

	private final LoginRepository loginRepository;

	private final LoginSearchRepository loginSearchRepository;

	public List<Login> findAllLogins() {
		return loginRepository.findAll();
	}

	@Transactional
	public Login save(Login login) {
		return loginRepository.save(login);
	}

	public Login authenticateUser(String username, String password) {
		return loginSearchRepository.findByUsernameAndPassword(username, password);
	}
}

