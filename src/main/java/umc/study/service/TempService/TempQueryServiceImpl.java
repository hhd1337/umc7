package umc.study.service.TempService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import umc.study.domain.apiPayload.code.status.ErrorStatus;
import umc.study.domain.apiPayload.exception.handler.TempHandler;

@Service
@RequiredArgsConstructor
@Slf4j

public class TempQueryServiceImpl implements TempQueryService{

    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}
