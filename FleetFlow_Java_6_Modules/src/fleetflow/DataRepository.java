package fleetflow;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class DataRepository {
    public static final String[] HEADER = {"delivery_id","delivery_partner","package_type","vehicle_type","delivery_mode","region","weather_condition","distance_km","package_weight_kg","delivery_time_hours","expected_time_hours","delayed","delivery_status","delivery_rating","delivery_cost"};
    private final List<Shipment> shipments = new ArrayList<>();
    private String[] header = HEADER;
    public DataRepository(String path) throws IOException { load(path); }
    private void load(String path) throws IOException {
        Path p = Paths.get(path);
        if (!Files.exists(p)) throw new FileNotFoundException("Dataset not found: " + p.toAbsolutePath());
        try (BufferedReader br = Files.newBufferedReader(p, StandardCharsets.UTF_8)) {
            String line = br.readLine();
            if (line == null) return;
            header = parse(line);
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] values = parse(line);
                if (values.length < header.length) values = Arrays.copyOf(values, header.length);
                shipments.add(new Shipment(values));
            }
        }
    }
    private String[] parse(String line) {
        // Handles quoted CSV fields and commas inside quotes; no external libraries required.
        List<String> out = new ArrayList<>(); StringBuilder cell = new StringBuilder(); boolean quoted = false;
        for (int i=0;i<line.length();i++) { char c=line.charAt(i);
            if (c=='"') { if (quoted && i+1<line.length() && line.charAt(i+1)=='"') { cell.append('"'); i++; } else quoted=!quoted; }
            else if (c==',' && !quoted) { out.add(cell.toString()); cell.setLength(0); } else cell.append(c);
        }
        out.add(cell.toString()); return out.toArray(new String[0]);
    }
    public List<Shipment> all() { return Collections.unmodifiableList(shipments); }
    public String[] header() { return header.clone(); }
    public int count() { return shipments.size(); }
    public int column(String name) { for(int i=0;i<header.length;i++) if(header[i].equalsIgnoreCase(name)) return i; return -1; }
    public List<Shipment> search(String field, String query) {
        int col=column(field); List<Shipment> result=new ArrayList<>(); if(col<0) return result;
        for(Shipment s:shipments) if(s.get(col).toLowerCase(Locale.ROOT).contains(query.toLowerCase(Locale.ROOT))) result.add(s);
        return result;
    }
    public void summary() {
        int delayed=0; Map<String,Integer> status=new TreeMap<>(), partners=new TreeMap<>();
        int dc=column("delayed"), sc=column("delivery_status"), pc=column("delivery_partner");
        for(Shipment s:shipments){ if(s.get(dc).equalsIgnoreCase("yes")) delayed++; status.merge(s.get(sc),1,Integer::sum); partners.merge(s.get(pc),1,Integer::sum); }
        System.out.println("\nDataset records: "+shipments.size()+" | Delayed: "+delayed+" | Delay rate: "+(shipments.isEmpty()?0:100.0*delayed/shipments.size())+"%");
        System.out.println("Statuses: "+status); System.out.println("Delivery partners: "+partners);
    }
}
