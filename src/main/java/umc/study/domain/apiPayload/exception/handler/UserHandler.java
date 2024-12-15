package umc.study.domain.apiPayload.exception.handler;

import umc.study.domain.apiPayload.code.BaseErrorCode;
import umc.study.domain.apiPayload.exception.GeneralException;

public class UserHandler extends GeneralException {
    public UserHandler(BaseErrorCode message) {
        super(message);
    }
}
