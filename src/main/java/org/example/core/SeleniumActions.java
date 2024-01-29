package org.example.core;

import com.codeborne.selenide.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.awaitility.Awaitility;
import org.awaitility.core.ConditionTimeoutException;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Slf4j
public class SeleniumActions {

    public static boolean waitUntilCondition(SelenideElement element, Condition condition, long time) {
        try {
            return Awaitility.given().pollInSameThread().ignoreExceptions().pollInterval(500, TimeUnit.MILLISECONDS)
                    .await().atMost(time, TimeUnit.MILLISECONDS)
                    .until(checkForCondition(element, condition), aBoolean -> aBoolean.equals(true));
        } catch (ConditionTimeoutException e) {
            log.warn("Condition [{}] for element [{}] was not met in [{}] millis!",
                    condition, StringUtils.left(element.toString().replaceAll(DataUtils.SPACES_REG_EXP, StringUtils.SPACE), 60), time);
            return false;
        }
    }

    private static Callable<Boolean> checkForCondition(SelenideElement element, Condition condition) {
        return () -> Selenide.$(element).is(condition);
    }

    public static Stream<SelenideElement> fixedStream(ElementsCollection collection) {
        return StreamSupport.stream(collection.asFixedIterable().spliterator(), false);
    }

}
