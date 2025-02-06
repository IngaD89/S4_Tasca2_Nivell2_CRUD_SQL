package cat.itacademy.s04.t02.n02.S04T02N02.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
