package fleetflow;

public class Shipment {
    public final String[] fields;
    public Shipment(String[] fields) { this.fields = fields; }
    public String get(int index) { return index >= 0 && index < fields.length ? fields[index] : ""; }
    public String toString() {
        return String.format("ID=%s | Code=%s | Address=%s | Partner=%s | Region=%s | Status=%s | Delayed=%s | Cost=%s",
            get(0), get(15), get(16), get(1), get(5), get(12), get(11), get(14));
    }
}
