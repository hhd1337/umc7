package umc.study.domain.apiPayload.exception.handler;

import umc.study.domain.apiPayload.code.BaseErrorCode;
import umc.study.domain.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
