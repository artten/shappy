package com.example.shappy;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddEditNoteActivity extends AppCompatActivity {
    public static final String EXTRA_ID =
            "com.example.shappy.EXTRA_ID";
    public static final String EXTRA_NAME =
            "com.example.shappy.EXTRA_NAME";
    public static final String EXTRA_PRICE =
            "com.example.shappy.EXTRA_PRICE";
    private EditText editTextName;
    private EditText editTextPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        editTextName = findViewById(R.id.edit_text_name);
        editTextPrice = findViewById(R.id.edit_text_price);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_ID)) {
            setTitle("Edit Note");
            editTextName.setText(intent.getStringExtra(EXTRA_NAME));
            editTextPrice.setText(intent.getStringExtra(EXTRA_PRICE));
        } else {
            setTitle("Add Note");
        }
    }
    private void saveNote() {
        String name = editTextName.getText().toString();
        String price = editTextPrice.getText().toString();
        if (name.trim().isEmpty() || price.trim().isEmpty()) {
            Toast.makeText(this, "Please insert a title and description", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data = new Intent();
        data.putExtra(EXTRA_NAME, name);
        data.putExtra(EXTRA_PRICE, price);

        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if (id != -1) {
            data.putExtra(EXTRA_ID, id);
        }

        setResult(RESULT_OK, data);
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
