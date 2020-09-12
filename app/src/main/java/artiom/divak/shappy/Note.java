package artiom.divak.shappy;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String sum;


    public Note(String name, String sum) {
        this.name = name;
        this.sum = sum;
    }

    public String getName() { return name; }

    public String getSum() {
        return sum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }
    public void setSum(String sum) { this.sum = sum; }
    public void setName(String name) { this.name = name; }


}
