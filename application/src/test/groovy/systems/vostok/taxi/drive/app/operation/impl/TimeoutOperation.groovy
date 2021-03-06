package systems.vostok.taxi.drive.app.operation.impl

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Component
import systems.vostok.taxi.drive.app.dao.domain.operation.OperationContext
import systems.vostok.taxi.drive.app.operation.CoreOperation

@Component
@Slf4j
class TimeoutOperation<T, ID extends Serializable> implements CoreOperation {
    String operationName = 'CORE_TIMEOUT_OPERATION'
    String operationTimeout

    @Override
    Object enroll(OperationContext context) {
        log.info('Start CORE_TIMEOUT_OPERATION')
        sleep(11000)
        throw new Exception('Circuit breaker FAIL')
    }

    @Override
    Object rollback(OperationContext context) {
        null
    }

    @Override
    Object breakEnroll(OperationContext context) {
        log.info('Start break of CORE_TIMEOUT_OPERATION')
        new BigDecimal(5)
    }
}
