import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Objects;

public class FinanceReport {
    private final Payment[] arr;
    private final String name;
    private final GregorianCalendar date;

    public FinanceReport(String name, GregorianCalendar date, Payment... arr) {
        this.date = date;
        this.name = name;
        this.arr = arr.clone();
    }

    public FinanceReport(FinanceReport financeReport) {
        this.date = financeReport.getDate();
        this.name = financeReport.getName();
        this.arr = financeReport.getArr().clone();
    }

    public String getName() {
        return name;
    }

    public Payment[] getArr() {
        return arr;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public int getCount() {
        return arr.length;
    }

    public Payment getPayment(int index) {
        if (index < 0) throw new IllegalArgumentException("index < 0");
        if (this.arr == null || this.arr.length <= index) throw new IllegalArgumentException("array is null or index > array length");
        return arr[index];
    }

    public void setPayment(int index, Payment payment) {
        if (index < 0) throw new IllegalArgumentException("index < 0");
        if (this.arr == null || this.arr.length <= index) throw new IllegalArgumentException("array is null or index > array length");
        arr[index] = new Payment(payment);
    }

    @Override
    public String toString() {
        return String.format("Автор: %s, Дата: %s, Платежи: %n%s", name, date.getTime(), Arrays.toString(arr));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinanceReport that = (FinanceReport) o;
        return date == that.date && Arrays.equals(arr, that.arr) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, date, Arrays.hashCode(arr));
    }
}
