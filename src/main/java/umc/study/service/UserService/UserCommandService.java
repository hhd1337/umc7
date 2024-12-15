package umc.study.service.UserService;

import umc.study.domain.common.User;
import umc.study.web.dto.UserRequestDTO;

public interface UserCommandService {
    User joinUser(UserRequestDTO.JoinDto request);
}
