package umc.study.apiPayload.exception.handler;

import umc.study.domain.apiPayload.code.BaseErrorCode;
import umc.study.domain.apiPayload.exception.GeneralException;


public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
