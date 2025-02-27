package llm.dynamics.toyapp;

import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ListActivity extends AppCompatActivity {
    private TextView listTextView;
    private SparseArray<String> largeList = new SparseArray<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listTextView = findViewById(R.id.listTextView);

        // Fill the list with 700+ items
        for (int i = 0; i < 710; i++) {
            largeList.put(i, "Item " + (i + 1));
        }

        // Display first 10 items for preview
        StringBuilder displayText = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            displayText.append(largeList.get(i)).append("\n");
        }

        listTextView.setText(displayText.toString());
        Log.d("ListActivity", "List populated with " + largeList.size() + " items.");
    }
}
