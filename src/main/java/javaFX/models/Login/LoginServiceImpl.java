package javaFX.models.Login;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class LoginServiceImpl implements LoginService {

	private final LoginRepository loginRepository;

	public List<Login> findAllLogins() {
		return loginRepository.findAll();
	}

	@Transactional
	public Login save(Login login) {
		return loginRepository.save(login);
	}
}
