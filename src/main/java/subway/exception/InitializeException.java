package subway.exception;

public class InitializeException extends IllegalStateException {

    public InitializeException(final ExceptionMessage message) {
        super(String.format(ExceptionMessage.EXCEPTION_MESSAGE_FORMAT.getMessage(), message.getMessage()));
    }

}
