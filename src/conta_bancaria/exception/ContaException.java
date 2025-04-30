package conta_bancaria.exception;

public class ContaException extends RuntimeException {

    public ContaException(String messege) {
        super(messege);
    }

    public ContaException() {
    }
}
