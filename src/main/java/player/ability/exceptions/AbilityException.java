package player.ability.exceptions;

public class AbilityException extends Exception {

    public AbilityException(String message) {
        super(message);
    }

    public AbilityException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
