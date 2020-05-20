import java.time.LocalDateTime;
public class ValuedElement<E> {

    private E e;
    private int value;
    private LocalDateTime date;

    public ValuedElement(E e, int value, LocalDateTime date){
        if(value >= 0)
            this.e = e;
            this.date = date;
        this.value = value;
    }

    public E getE() {
        return e;
    }

    public int getValue() {
        return value;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
