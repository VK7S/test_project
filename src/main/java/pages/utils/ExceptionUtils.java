package pages.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

public final class ExceptionUtils {
    private ExceptionUtils() {
    }

    public static String findRootMessage(Exception target) {
        Object current;
        for (current = target; ((Throwable) current).getCause() != null && current != ((Throwable) current).getCause(); current = ((Throwable) current).getCause()) {
        }

        return String.format("%s: %s", current.getClass().getSimpleName(), ((Throwable) current).getMessage());
    }

    public static Throwable findRootCause(Exception target) {
        Object current;
        for (current = target; ((Throwable) current).getCause() != null && current != ((Throwable) current).getCause(); current = ((Throwable) current).getCause()) {
        }

        return (Throwable) current;
    }

    public static String fullStackTrace(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter writer = new PrintWriter(sw);
        e.printStackTrace(writer);
        writer.close();
        return sw.toString();
    }
}
