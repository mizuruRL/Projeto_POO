import java.time.LocalDateTime;
public class ValuedElement<E> {

    private E e;
    private LocalDateTime date;

    public ValuedElement(E e, LocalDateTime date){
            this.e = e;
            this.date = date;
    }

    public E getE() {
        return e;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString(){
        return e.toString() + "| Data: " + date;
    }
}
