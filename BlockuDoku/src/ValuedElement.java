import java.time.LocalDate;
import java.time.LocalDateTime;
public class ValuedElement<E> {

    private E e;
    private LocalDate date;

    public ValuedElement(E e, LocalDate date){
            this.e = e;
            this.date = date;
    }

    public E getE() {
        return e;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString(){
        return e.toString() + "| Data: " + date;
    }
}
