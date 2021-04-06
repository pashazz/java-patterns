package io.github.pashazz.patterns.utils;

import java.time.Duration;

import static java.lang.String.format;

public class Utils {
    public static String durationToString(Duration dur) {
        StringBuilder sb = new StringBuilder();
        if (dur.toDaysPart() > 0) {
            sb.append(format(" %s days", dur.toDaysPart()));
        }
        if (dur.toHoursPart() > 0) {
            sb.append(format(" %s hours", dur.toHoursPart()));
        }
        if (dur.toMinutesPart() > 0) {
            sb.append(format(" %s minutes", dur.toMinutesPart()));
        }
        if (dur.toSecondsPart() > 0) {
            sb.append(format(" %s seconds", dur.toSecondsPart()));
        }
        if (dur.toMillisPart() > 0 || sb.length() == 0) {
            sb.append(format(" %s ms", dur.toMillisPart()));
        }
        return sb.toString();
    }
}
