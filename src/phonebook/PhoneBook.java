package phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    public List<Records> records;

    public PhoneBook() {
        this.records = new ArrayList<>();
    }

    public void add(Records newRecord){
        this.records.add(newRecord);
    }

    public Records find(String nameToSearch){
        for (Records record :
                records) {
            if (record.getName().equals(nameToSearch)){
                return record;
            }
        }
        return null;
    }

    public List<Records> findAll(String nameToSearch){
        List<Records> result = new ArrayList<>();
        for (Records record :
                records){
            if (record.getName().equals(nameToSearch)) {
                result.add(record);
            }
        }
        if (result.isEmpty()) return null;
        return result;
    }
}
